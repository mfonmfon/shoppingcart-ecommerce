package com.semicolon.africa.service.serviceImplication;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.semicolon.africa.data.model.Category;
import com.semicolon.africa.data.model.Product;
import com.semicolon.africa.data.repository.CategoryRepository;
import com.semicolon.africa.data.repository.ProductRepository;
import com.semicolon.africa.dto.request.AddProductRequest;
import com.semicolon.africa.dto.request.UpdateProductRequest;
import com.semicolon.africa.dto.response.AddProductResponse;
import com.semicolon.africa.dto.response.DeleteProductResponse;
import com.semicolon.africa.dto.response.UpdateProductResponse;
import com.semicolon.africa.exception.CategoryNotFoundException;
import com.semicolon.africa.exception.ProductIdNotFoundException;
import com.semicolon.africa.exception.ProductNotFoundException;
import com.semicolon.africa.service.interfaces.Product.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final ObjectMapper objectMapper;

    @Override
    public AddProductResponse addProduct(AddProductRequest addProductRequest) {
        Category category = categoryRepository.findByName(addProductRequest.getCategory().getName());
        if(category == null){
            throw new CategoryNotFoundException("Category not found ");
        }
        Category newCategory = new Category();
        addProductRequest.setCategory(category);
        categoryRepository.save(newCategory);
        Product product = new Product();
        product.setName(addProductRequest.getName());
        product.setDescription(addProductRequest.getDescription());
        product.setBrand(addProductRequest.getBrand());
        product.setPrice(addProductRequest.getPrice());
        product.setInventory(addProductRequest.getInventory());
        product.setCategory(addProductRequest.getCategory());
        productRepository.save(product);
        AddProductResponse addProductResponse = new AddProductResponse();
        addProductResponse.setMessage("Product added successfully");
        return addProductResponse;

    }

    @Override
    public UpdateProductResponse updateProduct(UpdateProductRequest request) {
        Category category = categoryRepository.findByName(request.getCategory().getName());
        request.setCategory(category);
        Product product = findProductById(request.getProductId());
        product.setName(request.getName());
        product.setDescription(request.getDescription());
        product.setBrand(request.getBrand());
        product.setPrice(request.getPrice());
        product.setInventory(request.getInventory());
        product.setCategory(request.getCategory());
        UpdateProductResponse updateProductResponse = new UpdateProductResponse();
        updateProductResponse.setMessage("Product updated successfully");
        return updateProductResponse;
    }

    @Override
    public DeleteProductResponse deleteProduct(Long id) {
       Product product =  findProductById(id);
       productRepository.delete(product);
       DeleteProductResponse deleteProductResponse = new DeleteProductResponse();
       deleteProductResponse.setMessage("Product deleted successfully");
       return deleteProductResponse;
    }

    private Product findProductById(Long id) {
        return productRepository.findProductById(id)
                .orElseThrow(()-> new ProductIdNotFoundException("product not found"));
    }


    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id).
                orElseThrow(()-> new ProductNotFoundException("Product not found"));
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> getProductByCategory(String category) {
        return productRepository.findProductByCategoryName(category);
    }

    @Override
    public List<Product> findProductByBrand(String brand) {
        return productRepository.findByBrand((brand).toLowerCase());
    }

    @Override
    public List<Product> getProductByBrandAndCategory(String brand, String category) {
        return productRepository.getProductByCategoryNameAndBrand(brand, category);
    }

    @Override
    public List<Product> getProductByName(String productName) {
        return productRepository.findProductByName(productName);
    }


    @Override
    public List<Product> getProductByBrandAndName(String brand, String name) {
        return productRepository.findProductByBrandAndName(brand, name);
    }

    @Override
    public Long countProductByBrandAndName(String brand, String name) {
        return productRepository.countByBrandAndName(brand, name);
    }
}
