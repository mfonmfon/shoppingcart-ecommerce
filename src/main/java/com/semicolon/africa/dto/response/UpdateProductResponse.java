package com.semicolon.africa.dto.response;

import com.semicolon.africa.data.model.Category;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
@Getter
@Setter
public class UpdateProductResponse {
    private String name;
    private String brand;
    private BigDecimal price;
    private int inventory;
    private String description;
    private Category category;
    private String message;
}
