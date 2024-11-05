package com.semicolon.africa.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RetrieveCategoryRequest {
    private Long categoryId;
    private String name;

}
