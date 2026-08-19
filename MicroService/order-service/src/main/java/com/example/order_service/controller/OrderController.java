package com.example.order_service.controller;


import com.example.order_service.dto.OrderRequestDto;
import com.example.order_service.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/products")
public class OrderController {

    private final OrderService orderService;

    @GetMapping("/helloOrders")
    public String hello() {
        return "Hello from Order Service!";
    }

    @GetMapping
    public ResponseEntity<?> getAllInventory() {
        List<OrderRequestDto> productDtoList = orderService.getAllOrders();
        return ResponseEntity.ok().body(productDtoList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getInventoryById(@PathVariable Long id) {
        OrderRequestDto productDto = orderService.getProductById(id);
        return ResponseEntity.ok().body(productDto);
    }
}
