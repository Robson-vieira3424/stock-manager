package com.StockManager.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.StockManager.Model.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT COUNT( p.name) FROM Product p")
    long countTotalProducts();

    @Query("SELECT COALESCE(SUM(p.quantity), 0) FROM Product p")
    long sumTotalInventoryQuantity();

    long countByQuantityGreaterThan(Long quantity);

    @Query("SELECT COUNT(p) FROM Product p WHERE p.quantity < p.min")
    long countProductsBelowMinimum();


}

