package com.semicolon.africa.service.product;

import com.semicolon.africa.data.model.Product;
import com.semicolon.africa.dto.request.AddProductRequest;
import com.semicolon.africa.dto.request.UpdateProductRequest;
import com.semicolon.africa.dto.response.AddProductResponse;
import com.semicolon.africa.dto.response.DeleteProductResponse;
import com.semicolon.africa.dto.response.UpdateProductResponse;

import java.util.List;

public interface ProductService {
    AddProductResponse addProduct(AddProductRequest productRequest);
    UpdateProductResponse updateProduct(UpdateProductRequest updateProductRequest);
    DeleteProductResponse deleteProduct(String id);
    List<Product> getAllProducts();
    List<Product> findProductByName(String name);
    List<Product> findProductByBrand(String brand);
    List<Product> findProductByCategory(String category);
    List<Product> getProductByCategoryAndBrand(String category, String brand);
    List<Product> getProductByBrandAndName(String brand, String name);
    Long countProductsByBrandAndName(String brand, String name);



}
