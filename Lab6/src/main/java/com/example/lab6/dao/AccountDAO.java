package com.example.lab6.dao;

import com.example.lab6.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountDAO extends JpaRepository<Account, String> {}
