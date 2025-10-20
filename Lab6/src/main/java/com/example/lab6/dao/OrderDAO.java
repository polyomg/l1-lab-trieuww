package com.example.lab6.dao;

import com.example.lab6.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDAO extends JpaRepository<Order, Long> {}
