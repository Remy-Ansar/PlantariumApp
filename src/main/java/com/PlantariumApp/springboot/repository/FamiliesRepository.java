package com.PlantariumApp.springboot.repository;

import com.PlantariumApp.springboot.model.Families;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FamiliesRepository extends JpaRepository<Families, Long> {

    Families findFamiliesById(Long id);

}
