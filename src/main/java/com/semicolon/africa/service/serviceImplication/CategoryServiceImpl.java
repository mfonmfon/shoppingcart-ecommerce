package com.semicolon.africa.service.serviceImplication;

import com.semicolon.africa.data.model.Category;
import com.semicolon.africa.data.repository.CategoryRepository;
import com.semicolon.africa.dto.request.AddCategoryRequest;
import com.semicolon.africa.dto.request.RetrieveCategoryRequest;
import com.semicolon.africa.dto.response.AddCategoryResponse;
import com.semicolon.africa.dto.response.DeleteCategoryResponse;
import com.semicolon.africa.dto.response.RetrieveCategoryResponse;
import com.semicolon.africa.exception.CategoryNotFoundException;
import com.semicolon.africa.exception.ResourceNotFoundException;
import com.semicolon.africa.service.interfaces.Category.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public AddCategoryResponse addToCategory(AddCategoryRequest addCategoryRequest) {
        Category category = new Category();
        category.setName(addCategoryRequest.getName());
        categoryRepository.save(category);
        AddCategoryResponse addCategoryResponse = new AddCategoryResponse();
        addCategoryResponse.setId(category.getId());
        addCategoryResponse.setName(category.getName());
        addCategoryResponse.setMessage(STR."Added \{addCategoryRequest.getName()} to category ");
        return addCategoryResponse;
    }
    @Override
    public RetrieveCategoryResponse retrieveCategory(RetrieveCategoryRequest retrieveCategoryRequest) {
        Category category = categoryRepository.findCategoryById(retrieveCategoryRequest.getCategoryId());

        category.setName(retrieveCategoryRequest.getName());
        RetrieveCategoryResponse retrieveCategoryResponse = new RetrieveCategoryResponse();
        retrieveCategoryResponse .setMessage("Updated category ");
        return retrieveCategoryResponse ;
    }

    @Override
    public DeleteCategoryResponse deleteCategory(Long categoryId) {
        Category category =  findCategoryById(categoryId);
        categoryRepository.delete(category);
        DeleteCategoryResponse deleteCategoryResponse = new DeleteCategoryResponse();
        deleteCategoryResponse.setMessage("Category deleted successfully");
        return deleteCategoryResponse;
    }

    private Category findCategoryById(Long categoryId) {
        return categoryRepository.findById(categoryId)
                .orElseThrow(()-> new ResourceNotFoundException("Category not found"));
    }

    @Override
    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(()-> new CategoryNotFoundException("Category not found"));
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getCategoryByName(String categoryName) {
        return categoryRepository.findByName(categoryName);
    }
}
