package com.semicolon.africa.service.prouct;

import com.semicolon.africa.data.model.Category;
import com.semicolon.africa.data.model.Product;
import com.semicolon.africa.data.repository.CategoryRepository;
import com.semicolon.africa.data.repository.ProductRepository;
import com.semicolon.africa.dto.request.AddProductRequest;
import com.semicolon.africa.dto.request.UpdateProductRequest;
import com.semicolon.africa.dto.response.AddProductResponse;
import com.semicolon.africa.dto.response.DeleteProductResponse;
import com.semicolon.africa.dto.response.UpdateProductResponse;
import com.semicolon.africa.exception.CategoryCanNotBeNul;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements  ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public AddProductResponse addProduct(AddProductRequest productRequest) {

        Category category = categoryRepository.findCategoryByName(productRequest.getCategory().getName());
        if (category == null){
            Category newCategory = new Category();
            newCategory.setName(productRequest.getCategory().getName());
            categoryRepository.save(newCategory);

        }

        Product product = new Product();
        product.setName(productRequest.getName());
        product.setBrand(productRequest.getBrand());
        product.setPrice(productRequest.getPrice());
        product.setInventory(productRequest.getInventory());
        product.setDescription(productRequest.getDescription());
        product.setCategory(productRequest.getCategory());
        category.getProducts().add(product);
        productRepository.save(product);
        AddProductResponse addProductResponse = getAddProductResponse(product);
        return addProductResponse;
    }

    private static AddProductResponse getAddProductResponse(Product product) {
        AddProductResponse addProductResponse = new AddProductResponse();
        addProductResponse.setProductId(product.getId());
        addProductResponse.setName(product.getName());
        addProductResponse.setBrand(product.getBrand());
        addProductResponse.setPrice(product.getPrice());
        addProductResponse.setInventory(product.getInventory());
        addProductResponse.setDescription(product.getDescription());
        addProductResponse.setCategory(product.getCategory());
        addProductResponse.setMessage("Product added");
        return addProductResponse;
    }

    @Override
    public UpdateProductResponse updateProduct(UpdateProductRequest updateProductRequest) {
        return null;
    }

    @Override
    public DeleteProductResponse deleteProduct(String id) {
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> findProductByName(String name) {
        return  productRepository.findProductByName(name);
    }

    @Override
    public List<Product> findProductByBrand(String brand) {
        return productRepository.findProductByBrand(brand);
    }

    @Override
    public List<Product> findProductByCategory(String categoryName) {
        return productRepository.findProductByCategoryName(categoryName);
    }

    @Override
    public List<Product> getProductByCategoryAndBrand(String categoryName, String brand) {
        return  productRepository.getProductByCategoryNameAndBrand(categoryName, brand );
    }

    @Override
    public List<Product> getProductByBrandAndName(String brand, String name) {
        return productRepository.getProductByBrandAndName(brand, name);
    }

    @Override
    public Long countProductsByBrandAndName(String brand, String name) {
        return productRepository.countByBrandAndName(brand, name);
    }
}
