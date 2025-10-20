package com.example.lab6.dao;

import com.example.lab6.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDAO extends JpaRepository<Product, Integer> {}
