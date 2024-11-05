package com.semicolon.africa.service.serviceImplication;

import com.semicolon.africa.data.model.Image;
import com.semicolon.africa.data.repository.ImageRepository;
import com.semicolon.africa.dto.response.DeleteImageResponse;
import com.semicolon.africa.dto.response.SaveImageResponse;
import com.semicolon.africa.dto.response.UpdateImageResponse;
import com.semicolon.africa.exception.ImageNotFoundException;
import com.semicolon.africa.service.interfaces.Image.ImageService;
import com.semicolon.africa.service.interfaces.Product.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
@Service
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService {

    private final ImageRepository imageRepository;
    private final ProductService productService;

    @Override
    public Image getImageById(Long id) {
        return  imageRepository.findImageById(id)
                .orElseThrow(()-> new ImageNotFoundException("Image not found"));
    }
    @Override
    public SaveImageResponse saveImage(MultipartFile file, Long productId) {
        return null;
    }
    @Override
    public DeleteImageResponse deleteImage(Long id) {
        Image image = findImageById(id);
        imageRepository.delete(image);
        DeleteImageResponse deleteImageResponse = new DeleteImageResponse();
        deleteImageResponse.setMessage("Image deleted successfully");
        return deleteImageResponse;
    }
    private Image findImageById(Long id) {
        return imageRepository.findImageById(id)
                .orElseThrow(()-> new ImageNotFoundException("No such image"));
    }

    @Override
    public UpdateImageResponse editImage(MultipartFile file, Long imageId) {
        return null;
    }

    @Override
    public List<Image> getAllImages() {
        return List.of();
    }
}
