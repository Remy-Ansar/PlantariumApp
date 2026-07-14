package com.PlantariumApp.springboot.repository;

import com.PlantariumApp.springboot.model.Genus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenusRepository extends JpaRepository<Genus, Long> {

    Genus findGenusById(Long id);

}
