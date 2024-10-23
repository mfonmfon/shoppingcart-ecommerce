package com.semicolon.africa.service.category;

import com.semicolon.africa.dto.request.AddCategoryRequest;
import com.semicolon.africa.dto.response.AddCategoryResponse;

public interface CategoryService {

    AddCategoryResponse addItemToCategory(AddCategoryRequest request);
}
