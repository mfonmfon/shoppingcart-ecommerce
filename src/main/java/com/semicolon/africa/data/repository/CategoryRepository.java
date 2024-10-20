package com.semicolon.africa.data.repository;

import com.semicolon.africa.data.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findCategoryByName(String name);

}
