package com.example.inventory_service.service;

import com.example.inventory_service.dto.OrderRequestDto;
import com.example.inventory_service.dto.OrderRequestItemDto;
import com.example.inventory_service.dto.ProductDto;
import com.example.inventory_service.entity.Product;
import com.example.inventory_service.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;

    public List<ProductDto> getAllInventory() {
        log.info("Fetching all products from inventory");
        List<Product> inventories = productRepository.findAll();
        return inventories.stream().map(product -> modelMapper.map(product, ProductDto.class)).toList();
    }

    public ProductDto getProductById(Long id) {
        log.info("Fetching product with id {}", id);
        Optional<Product> inventory = productRepository.findById(id);
        return inventory.map(product -> modelMapper.map(product, ProductDto.class)).orElseThrow(() -> new RuntimeException("Inventory not found"));
    }

    @Transactional
    public Double reduceStocks(OrderRequestDto orderRequestDto) {
        log.info("Reducing stocks from inventory");
        double totalPrice = 0.0;
        for (OrderRequestItemDto orderRequestItemDto : orderRequestDto.getItems()) {
            Long productId = orderRequestItemDto.getProductId();
            Integer quantity = orderRequestItemDto.getQuantity();

            Product product = productRepository.findById(productId).orElseThrow(() -> new RuntimeException("Product not found with id: " + productId));

            if (product.getStock() < quantity) {
                throw new RuntimeException("Not enough stock for product with id: " + productId);
            }

            product.setStock(product.getStock() - quantity);
            productRepository.save(product);
            totalPrice += quantity * product.getPrice();
        }

        return totalPrice;
    }
}
