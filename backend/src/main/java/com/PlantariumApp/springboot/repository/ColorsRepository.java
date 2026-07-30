package com.PlantariumApp.springboot.repository;

import com.PlantariumApp.springboot.model.Colors;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ColorsRepository extends JpaRepository<Colors, Long> {

    Colors findColorsById(Long id);
}
