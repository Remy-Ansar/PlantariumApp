package com.PlantariumApp.springboot.repository;

import com.PlantariumApp.springboot.model.Diseases;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiseasesRepository extends JpaRepository<Diseases, Long> {

    Diseases findDiseasesById(Long id);

}
