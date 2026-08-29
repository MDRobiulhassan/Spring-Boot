package com.example.order_service.service;

import com.example.order_service.clients.InventoryOpenFeignClient;
import com.example.order_service.dto.OrderRequestDto;
import com.example.order_service.entity.OrderItem;
import com.example.order_service.entity.OrderStatus;
import com.example.order_service.entity.Orders;
import com.example.order_service.repository.OrderRepository;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final ModelMapper modelMapper;
    private final InventoryOpenFeignClient inventoryOpenFeignClient;

    public List<OrderRequestDto> getAllOrders() {
        log.info("Fetching all orders");
        List<Orders> inventories = orderRepository.findAll();
        return inventories.stream().map(product -> modelMapper.map(product, OrderRequestDto.class)).toList();
    }

    public OrderRequestDto getProductById(Long id) {
        log.info("Fetching order with id {}", id);
        Optional<Orders> inventory = orderRepository.findById(id);
        return inventory.map(product -> modelMapper.map(product, OrderRequestDto.class)).orElseThrow(() -> new RuntimeException("Order not found"));
    }

    @Retry(name = "inventoryRetry",fallbackMethod = "createOrderFallback")
    @CircuitBreaker(name = "inventoryCircuitBreaker",fallbackMethod = "createOrderFallback")
    @RateLimiter(name = "inventoryRateLimiter",fallbackMethod = "createOrderFallback")
    public OrderRequestDto createOrder(OrderRequestDto orderRequestDto) {
        log.info("Creating new order");
        Double totalPrice = inventoryOpenFeignClient.reduceStock(orderRequestDto);

        Orders orders = modelMapper.map(orderRequestDto, Orders.class);
        for (OrderItem orderItem:orders.getItems()){
            orderItem.setOrder(orders);
        }
        orders.setTotalPrice(totalPrice);
        orders.setOrderStatus(OrderStatus.CONFIRMED);
        Orders savedOrder = orderRepository.save(orders);
        return modelMapper.map(savedOrder, OrderRequestDto.class);
    }

    public OrderRequestDto createOrderFallback(OrderRequestDto orderRequestDto,Throwable throwable) {
        log.error("Fallback occurred due to : {}",throwable.getMessage());
        return orderRequestDto;

    }
}
