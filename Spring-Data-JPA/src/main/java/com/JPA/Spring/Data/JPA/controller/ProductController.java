package com.JPA.Spring.Data.JPA.controller;

import com.JPA.Spring.Data.JPA.entity.ProductEntity;
import com.JPA.Spring.Data.JPA.repository.ProductRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductRepository productRepository;
    private final int PAGE_SIZE = 5;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping
    public List<ProductEntity> getProducts(@RequestParam(defaultValue = "id") String sortBy,@RequestParam(defaultValue = "0") Integer pageNumber) {
//        return productRepository.findAllByOrderByTitle();
//        return productRepository.findBy(Sort.by(Sort.Direction.DESC,sortBy));
//        return productRepository.findAll(pageable).getContent();
        Pageable pageable = PageRequest.of(pageNumber,PAGE_SIZE,Sort.by(sortBy));
        return productRepository.findAll(pageable).getContent();
    }
}
