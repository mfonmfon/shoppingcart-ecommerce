package com.semicolon.africa.service.product;

import com.semicolon.africa.data.model.Category;
import com.semicolon.africa.data.repository.CategoryRepository;
import com.semicolon.africa.data.repository.ProductRepository;
import com.semicolon.africa.dto.request.AddProductRequest;
import com.semicolon.africa.dto.request.UpdateProductRequest;
import com.semicolon.africa.dto.response.AddProductResponse;
import com.semicolon.africa.dto.response.UpdateProductResponse;
import com.semicolon.africa.service.interfaces.Product.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
public class ProductServiceTest {
    @Autowired
    private ProductService productService;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    private Category testCategory;

    @BeforeEach
    void setUp(){
        productRepository.deleteAll();
    }


    @Test
    public void testThatProductCanBeAdded(){
        AddProductRequest addProductRequest = new AddProductRequest();
        addProductRequest.setName("Iphone 12");
        addProductRequest.setBrand("Iphone");
        addProductRequest.setInventory(20);
        addProductRequest.setPrice(BigDecimal.valueOf(700000));
        addProductRequest.setDescription("Brand new iphone 12");
        addProductRequest.setCategory(testCategory);
        AddProductResponse addProductResponse = productService.addProduct(addProductRequest);
        assertEquals("Product added", addProductResponse.getMessage());
    }

    @Test
    public void testThatWhenProductIsAddedItCanBeUpdated(){
        AddProductRequest productRequest = new AddProductRequest();
        productRequest.setName("Iphone 12");
        productRequest.setBrand("Iphone");
        productRequest.setInventory(20);
        productRequest.setPrice(BigDecimal.valueOf(700000));
        productRequest.setDescription("Brand new iphone 12");

        AddProductResponse productResponse = productService.addProduct(productRequest);
        assertEquals("Product added", productResponse.getMessage());
        UpdateProductRequest updateProductRequest = new UpdateProductRequest();
        updateProductRequest.setProductId(1L);
        updateProductRequest.setName("Iphone 15");
        updateProductRequest.setBrand("Apple");
        updateProductRequest.setInventory(100);
        updateProductRequest.setPrice(BigDecimal.valueOf(12000000.00));
        updateProductRequest.setDescription("Brand new Iphone 15 high quality camera");
        UpdateProductResponse updateProductResponse = productService.updateProduct(updateProductRequest);
        assertEquals("Product updated ", updateProductResponse.getMessage());




    }

}