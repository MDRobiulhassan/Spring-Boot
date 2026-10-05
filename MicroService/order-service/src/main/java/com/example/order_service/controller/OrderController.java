package com.example.order_service.controller;


import com.example.order_service.dto.OrderRequestDto;
import com.example.order_service.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/core")
public class OrderController {

    private final OrderService orderService;

    @Value("${my.variable}")
    private String myVariable;

    @GetMapping("/helloOrders")
    public String helloOrders() {
        return "Hello from Order Service, variable value: " + myVariable;
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
