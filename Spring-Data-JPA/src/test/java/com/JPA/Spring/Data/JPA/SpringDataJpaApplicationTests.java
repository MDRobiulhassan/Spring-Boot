package com.JPA.Spring.Data.JPA;

import com.JPA.Spring.Data.JPA.entity.ProductEntity;
import com.JPA.Spring.Data.JPA.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
class SpringDataJpaApplicationTests {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void contextLoads() {
    }

    @Test
    void createProductEntity() {
        ProductEntity productEntity = ProductEntity.builder()
                .sku("nestle123")
                .title("Nestle Chocolate")
                .price(BigDecimal.valueOf(123))
                .build();
        ProductEntity product = productRepository.save(productEntity);
        System.out.println(product);
    }

    @Test
    void getAllProducts() {
        List<ProductEntity> products = productRepository.findAll();
        System.out.println(products);
    }

    @Test
    void getProductById() {
        ProductEntity productEntity = productRepository.findById(2L).orElse(null);
        System.out.println(productEntity);
    }

    @Test
    void getProductByTitle() {
        List<ProductEntity> product = productRepository.findProductByTitle("Nestle Chocolate");
        System.out.println(product);
    }

    @Test
    void getProductCreatedAfter() {
        List<ProductEntity> products = productRepository.findProductByCreatedAtAfter(LocalDateTime.of(2025,01,01,00,00,00));
        System.out.println(products);
    }

    @Test
    void getProductByTitleAndPrice() {
        ProductEntity product = productRepository.findProductByTitleAndPrice("Mechanical Keyboard",BigDecimal.valueOf(199.50));
        System.out.println(product);
    }

    @Test
    void getProductBySkuOrTitle() {
        List<ProductEntity> product = productRepository.findProductBySkuOrTitle("SKU-1002","Gaming Mouse");
        System.out.println(product);
    }

    @Test
    void getProductByPriceGreaterThan() {
        List<ProductEntity> product = productRepository.findProductByPriceGreaterThan(BigDecimal.valueOf(200));
        System.out.println(product);
    }

    @Test
    void getProductByTitleLike() {
        List<ProductEntity> product = productRepository.findProductByTitleLike("%Choco%");
        System.out.println(product);
    }

    @Test
    void getProductByTitleContains() {
        List<ProductEntity> product = productRepository.findProductByTitleContaining("Choco");
        System.out.println(product);
    }

    @Test
    void getProductByTitleContainsIgnoreCase() {
        List<ProductEntity> product = productRepository.findProductByTitleContainingIgnoreCase(("choco"));
        System.out.println(product);
    }

    @Test
    void getProductByCreatedAt(){
        List<ProductEntity> products = productRepository.findByCreatedAt(LocalDateTime.of(2025,12,13 ,21,44,24));
        System.out.println(products);
    }

    @Test
    void getProductByCreatedAtDate(){
        List<ProductEntity> products = productRepository.findByCreatedDate(LocalDate.of(2025,12,13));
        System.out.println(products);
    }
}
