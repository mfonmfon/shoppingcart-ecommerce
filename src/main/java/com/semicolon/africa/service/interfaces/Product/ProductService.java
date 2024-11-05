package com.semicolon.africa.service.interfaces.Product;

import com.semicolon.africa.data.model.Product;
import com.semicolon.africa.dto.request.AddProductRequest;
import com.semicolon.africa.dto.request.UpdateProductRequest;
import com.semicolon.africa.dto.response.AddProductResponse;
import com.semicolon.africa.dto.response.DeleteProductResponse;
import com.semicolon.africa.dto.response.UpdateProductResponse;

import java.util.List;

public interface ProductService {

    AddProductResponse addProduct(AddProductRequest request);

    UpdateProductResponse updateProduct(UpdateProductRequest request);

    DeleteProductResponse deleteProduct(Long id);

    Product getProductById(Long id);
    List<Product> getAllProducts();
    List<Product> getProductByCategory(String category);
    List<Product>  findProductByBrand(String brand);
    List<Product> getProductByBrandAndCategory(String brand, String category);
    List<Product> getProductByName(String productName);
    List<Product> getProductByBrandAndName(String brand, String name);
    Long countProductByBrandAndName(String brand, String name);



}
