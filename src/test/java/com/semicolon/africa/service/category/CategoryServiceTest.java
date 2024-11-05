package com.semicolon.africa.service.category;

import com.semicolon.africa.data.repository.CategoryRepository;
import com.semicolon.africa.dto.request.AddCategoryRequest;
import com.semicolon.africa.dto.request.RetrieveCategoryRequest;
import com.semicolon.africa.dto.response.AddCategoryResponse;


import com.semicolon.africa.dto.response.RetrieveCategoryResponse;
import com.semicolon.africa.service.interfaces.Category.CategoryService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CategoryServiceTest {

    @Autowired
    private CategoryService categoryService;
    @Autowired
    private  CategoryRepository categoryRepository;

    @Test
    void setup(){
        categoryRepository.deleteAll();
    }

    @Test
    public void testThatItemsCanBeAddedToCategory(){
        AddCategoryRequest addCategoryRequest = new AddCategoryRequest();
        addCategoryRequest.setName("Electronics");
        AddCategoryResponse addCategoryResponse = categoryService.addToCategory(addCategoryRequest);
        assertThat(addCategoryResponse.getMessage()).contains( "Added Electronics to category ");
        assertThat(addCategoryResponse).isNotNull();
    }

    @Test
    public void testThatCategoryCanBeUpdatedAndRetrieved(){
        AddCategoryRequest addCategoryRequest = new AddCategoryRequest();
        addCategoryRequest.setName("Electronics");
        AddCategoryResponse addCategoryResponse = categoryService.addToCategory(addCategoryRequest);
        assertThat(addCategoryResponse.getMessage()).contains( "Added Electronics to category ");
        assertThat(addCategoryResponse).isNotNull();
        RetrieveCategoryRequest retrieveCategoryRequest = new RetrieveCategoryRequest();
        retrieveCategoryRequest.setName("Phones");
        RetrieveCategoryResponse retrieveCategoryResponse = categoryService.retrieveCategory(retrieveCategoryRequest);
        assertThat(retrieveCategoryResponse.getMessage()).contains("Updated successfully");
    }

//     String PAYSTACK_API_KEY =   " pk_test_077e5a4bf18edd4a3419ba7195f8904a75b6798d";
//

}