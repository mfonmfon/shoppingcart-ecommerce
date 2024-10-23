package com.semicolon.africa.service.category;

import com.semicolon.africa.data.repository.CategoryRepository;
import com.semicolon.africa.dto.request.AddCategoryRequest;
import com.semicolon.africa.dto.response.AddCategoryResponse;
import com.semicolon.africa.exception.WrongEmailException;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CategoryServiceTest {

    @Autowired
    private  CategoryService categoryService;
    @Autowired
    private  CategoryRepository categoryRepository;



    @Test
    void setup(){
        categoryRepository.deleteAll();
    }


    @Test
    public void testThatItemsCanBeAddedToCategory(){
        AddCategoryRequest addCategoryRequest = new AddCategoryRequest();
        addCategoryRequest.setName("Mfon Mfon");
        addCategoryRequest.setEmail("mfon@gmail.com");
        addCategoryRequest.setPhoneNumber("08123115688");
        AddCategoryResponse addCategoryResponse = categoryService.addItemToCategory(addCategoryRequest);
        assertThat(addCategoryResponse.getMessage()).contains("Item added successfully");
        assertThat(addCategoryResponse).isNotNull();
    }

    @Test
    public void testThatWhenWrongEmailIsEntered_throwWrongEmailException(){
        AddCategoryRequest addCategoryRequest = new AddCategoryRequest();
        addCategoryRequest.setEmail("mfon@gmail.com");
        addCategoryRequest.setName("Mfon Mfon");
        addCategoryRequest.setPhoneNumber("08123115688");
        assertThrows(WrongEmailException.class, ()-> categoryService.addItemToCategory(addCategoryRequest));
    }







}