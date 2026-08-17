package com.example.inventory_service.repository;

import com.example.inventory_service.entity.Product;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<@NonNull Product,@NonNull Long> {
}
