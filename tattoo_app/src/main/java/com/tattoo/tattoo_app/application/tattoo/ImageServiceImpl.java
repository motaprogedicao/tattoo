package com.tattoo.tattoo_app.application.tattoo;

import com.tattoo.tattoo_app.domain.entity.Image;
import com.tattoo.tattoo_app.domain.service.ImageService;
import com.tattoo.tattoo_app.infra.repository.ImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService {

    private final ImageRepository repository;

    @Override
    @Transactional
    public Image save(Image image) {
        return repository.save(image);
    }
}
