package com.example.order_service.repository;

import com.example.order_service.entity.Orders;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<@NonNull Orders,@NonNull Long> {
}
