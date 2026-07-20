package com.PlantariumApp.springboot.repository;

import com.PlantariumApp.springboot.model.Watering;
import com.PlantariumApp.springboot.model.Weather;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WateringRepository extends JpaRepository<Watering, Long> {

    Watering findWateringById(Long id);
}
