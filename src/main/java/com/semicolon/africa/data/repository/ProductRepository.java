package com.semicolon.africa.data.repository;

import com.semicolon.africa.data.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
