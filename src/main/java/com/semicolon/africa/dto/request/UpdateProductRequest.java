package com.semicolon.africa.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
@Getter
@Setter
public class UpdateProductRequest {
    private Long productId;
    private String name;
    private String brand;
    private BigDecimal price;
    private int inventory;
}