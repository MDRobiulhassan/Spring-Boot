package com.example.order_service.service;

import com.example.order_service.dto.OrderRequestDto;
import com.example.order_service.entity.Orders;
import com.example.order_service.repository.OrderRepository;
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
}
