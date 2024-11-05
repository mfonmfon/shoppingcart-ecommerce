package com.semicolon.africa.dto.request;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;
@Getter
@Setter
public class SaveImageRequest {
    private MultipartFile file;
    private Long productId;
}
