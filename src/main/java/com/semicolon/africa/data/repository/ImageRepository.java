package com.semicolon.africa.data.repository;

import com.semicolon.africa.data.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ImageRepository extends JpaRepository<Image,Long> {
    Optional<Image> findImageById(Long id);
}
