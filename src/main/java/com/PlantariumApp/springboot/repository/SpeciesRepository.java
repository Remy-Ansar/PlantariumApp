package com.PlantariumApp.springboot.repository;

import com.PlantariumApp.springboot.model.Species;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpeciesRepository extends JpaRepository<Species, Long> {

    Species findSpeciesById(Long id);
}
