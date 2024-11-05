package com.semicolon.africa.service.interfaces.Category;

import com.semicolon.africa.data.model.Category;
import com.semicolon.africa.dto.request.AddCategoryRequest;
import com.semicolon.africa.dto.request.RetrieveCategoryRequest;
import com.semicolon.africa.dto.response.AddCategoryResponse;
import com.semicolon.africa.dto.response.DeleteCategoryResponse;
import com.semicolon.africa.dto.response.RetrieveCategoryResponse;

import java.util.List;

public interface CategoryService {
    AddCategoryResponse addToCategory(AddCategoryRequest addCategoryRequest);
    RetrieveCategoryResponse retrieveCategory(RetrieveCategoryRequest retrieveCategoryRequest);
    DeleteCategoryResponse deleteCategory(Long categoryId);
    Category getCategoryById(Long id);
    List<Category> getAllCategories();
    Category getCategoryByName(String categoryName);
}
