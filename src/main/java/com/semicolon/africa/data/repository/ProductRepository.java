package com.semicolon.africa.data.repository;

import com.semicolon.africa.data.model.Category;
import com.semicolon.africa.data.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findProductByName(String name);

    List<Product> findProductByBrand(String brand);

    List<Product> findProductByCategoryName(String categoryName);

    List<Product> getProductByCategoryNameAndBrand(String categoryName, String brand);


    Long countByBrandAndName(String brand, String name);

   Optional<Product> findProductById(Long id);

    List<Product> findByBrand(String brand);


    List<Product> findProductByBrandAndName(String brand, String name);
}

