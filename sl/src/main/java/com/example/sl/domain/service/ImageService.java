package com.example.sl.domain.service;

import com.example.sl.entity.ImageEntity;
import com.example.sl.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageService {

    @Autowired
    private ImageRepository imageRepository;

    public List<ImageEntity> getAllImages(int page, int pageSize) {
        int offset = page * pageSize;
        return imageRepository.findAllWithPagination(offset, pageSize);
    }

    public ImageEntity getImageById(Long id) {
        return imageRepository.findById(id).orElse(null);
    }

    public void saveImage(ImageEntity image) {
        imageRepository.save(image);
    }

    public List<ImageEntity> searchImagesByName(String name) {
        return imageRepository.findByNameContaining(name);
    }

    public long countImages() {
        return imageRepository.count();
    }
}
