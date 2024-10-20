package com.semicolon.africa.service.prouct;

import com.semicolon.africa.data.model.Category;
import com.semicolon.africa.data.repository.CategoryRepository;
import com.semicolon.africa.data.repository.ProductRepository;
import com.semicolon.africa.dto.request.AddProductRequest;
import com.semicolon.africa.dto.response.AddProductResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
public class ProductServiceTest {
    @Autowired
    private  ProductService productService;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;


    @Test
    public void testThatProductCanBeAdded(){
        AddProductRequest addProductRequest = new AddProductRequest();
        addProductRequest.setName("Iphone 12");
        addProductRequest.setBrand("Iphone");
        addProductRequest.setInventory(20);
        addProductRequest.setPrice(BigDecimal.valueOf(700000));
        addProductRequest.setDescription("Brand new iphone 12");
        AddProductResponse addProductResponse = productService.addProduct(addProductRequest);
        assertEquals("Product added", addProductResponse.getMessage());
    }

}