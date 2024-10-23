package com.semicolon.africa.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddCategoryResponse {
    private Long id;
    private String name;
    private String email;
    private String phoneNumber;
    private String message;
}
