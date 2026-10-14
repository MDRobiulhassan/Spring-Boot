package com.example.order_service.controller;


import com.example.order_service.config.FeaturesEnableConfig;
import com.example.order_service.dto.OrderRequestDto;
import com.example.order_service.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/core")
@RefreshScope
public class OrderController {

    private final OrderService orderService;
    private final FeaturesEnableConfig featuresEnableConfig;
    @Value("${my.variable}")
    private String myVariable;

    @GetMapping("/helloOrders")
    public String helloOrders() {
        if (featuresEnableConfig.isUserTrackingEnabled()) {
            return "User tracking is enabled. Hello from Order Service! My variable value is: " + myVariable;
        } else {
            return "User tracking is disabled. Hello from Order Service!";
        }
    }

    @GetMapping
    public ResponseEntity<?> getAllInventory() {
        List<OrderRequestDto> productDtoList = orderService.getAllOrders();
        return ResponseEntity.ok().body(productDtoList);
    }

    @PostMapping("/create-order")
    public ResponseEntity<?> createOrder(@RequestBody OrderRequestDto orderRequestDto) {
        OrderRequestDto createdOrder = orderService.createOrder(orderRequestDto);
        return ResponseEntity.ok().body(createdOrder);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getInventoryById(@PathVariable Long id) {
        OrderRequestDto productDto = orderService.getProductById(id);
        return ResponseEntity.ok().body(productDto);
    }
}
