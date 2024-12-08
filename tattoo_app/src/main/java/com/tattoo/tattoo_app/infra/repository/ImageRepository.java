package com.tattoo.tattoo_app.infra.repository;

import com.tattoo.tattoo_app.domain.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, String> {
}
