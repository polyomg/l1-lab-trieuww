package com.example.lab7.repository;

import com.example.lab7.entity.Product;
import com.example.lab7.dto.Report;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductDAO extends JpaRepository<Product, Integer> {

    @Query("SELECT o FROM Product o WHERE o.price >= ?1 AND o.price <= ?2")
    List<Product> findByPrice(double minPrice, double maxPrice);

    List<Product> findByPriceBetween(double minPrice, double maxPrice);

    @Query("SELECT o FROM Product o WHERE o.name LIKE ?1")
    Page<Product> findByKeywords(String keywords, Pageable pageable);

    Page<Product> findAllByNameLike(String keywords, Pageable pageable);

    @Query("SELECT o.category.name AS group, SUM(o.price) AS sum, COUNT(o) AS count " +
            "FROM Product o GROUP BY o.category.name ORDER BY SUM(o.price) DESC")
    List<Report> getInventoryByCategory();
}
