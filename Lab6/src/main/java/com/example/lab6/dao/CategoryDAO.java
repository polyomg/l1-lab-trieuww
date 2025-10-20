package com.example.lab6.dao;

import com.example.lab6.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryDAO extends JpaRepository<Category, String> {}
