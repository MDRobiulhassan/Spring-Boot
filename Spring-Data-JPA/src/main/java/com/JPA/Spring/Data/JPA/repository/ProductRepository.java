package com.JPA.Spring.Data.JPA.repository;

import com.JPA.Spring.Data.JPA.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
    List<ProductEntity> findProductByTitle(String title);

    List<ProductEntity> findProductByCreatedAtAfter(LocalDateTime time);

    ProductEntity findProductByTitleAndPrice(String title, BigDecimal price);

    List<ProductEntity> findProductBySkuOrTitle(String sku, String title);

    List<ProductEntity> findProductByPriceGreaterThan(BigDecimal price);

    List<ProductEntity> findProductByTitleLike(String title);

    List<ProductEntity> findProductByTitleContaining(String title);

    List<ProductEntity> findProductByTitleContainingIgnoreCase(String title);

    @Query("SELECT e FROM ProductEntity e WHERE e.createdAt = :time")
    List<ProductEntity> findByCreatedAt(LocalDateTime time);

    @Query("""
            SELECT p FROM ProductEntity p
            WHERE DATE(p.createdAt) = :date
            """)
    List<ProductEntity> findByCreatedDate(@Param("date") LocalDate date);

}
