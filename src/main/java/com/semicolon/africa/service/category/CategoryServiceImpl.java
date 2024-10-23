package com.semicolon.africa.service.category;

import com.semicolon.africa.data.model.Category;
import com.semicolon.africa.dto.request.AddCategoryRequest;
import com.semicolon.africa.dto.response.AddCategoryResponse;
import com.semicolon.africa.exception.InvalidPhoneNumberException;
import com.semicolon.africa.exception.WrongEmailException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService{
    
    private static final Pattern EMAIL_VALIDATION = Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$") ;
    private static final Pattern MOBILE_PHONE_NUMBER_VALIDATION = Pattern.compile("\\+?[0-9]{1,3}?[ -]?[0-9]{11}$");

    @Override
    public AddCategoryResponse addItemToCategory(AddCategoryRequest request) {

        if (!isValidEmail(request.getEmail())) throw new WrongEmailException("Invalid email");
        if (!isValidPassword(request.getPhoneNumber())) throw new InvalidPhoneNumberException("Invalid phone number exception");

        Category category = new Category();
        category.setName(request.getName());
        category.setEmail(request.getEmail());
        category.setPhoneNumber(request.getPhoneNumber());
        AddCategoryResponse addCategoryResponse = new AddCategoryResponse();
        addCategoryResponse.setName(category.getName());
        addCategoryResponse.setEmail(category.getEmail());
        addCategoryResponse.setPhoneNumber(category.getPhoneNumber());
        addCategoryResponse.setMessage("Item added successfully");
        return addCategoryResponse;
    }

    private boolean isValidPassword(String phoneNumber) {
        return MOBILE_PHONE_NUMBER_VALIDATION.matcher(phoneNumber).matches();

    }

    private boolean isValidEmail(String email) {
        return EMAIL_VALIDATION.matcher(email).matches();
    }
}
