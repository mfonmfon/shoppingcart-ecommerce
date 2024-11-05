package com.semicolon.africa.service.interfaces.Image;

import com.semicolon.africa.data.model.Image;
import com.semicolon.africa.dto.request.SaveImageRequest;
import com.semicolon.africa.dto.response.DeleteImageResponse;
import com.semicolon.africa.dto.response.SaveImageResponse;
import com.semicolon.africa.dto.response.UpdateImageResponse;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ImageService {
    Image getImageById(Long id);
    SaveImageResponse saveImage(MultipartFile file, Long productId);
    DeleteImageResponse deleteImage(Long id);
    UpdateImageResponse editImage(MultipartFile file, Long imageId);
    List<Image> getAllImages();
}
