package com.PlantariumApp.springboot.repository;

import com.PlantariumApp.springboot.model.Plants;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlantsRepository extends JpaRepository<Plants, Long> {

    Plants findPlantsById(Long id);
}
