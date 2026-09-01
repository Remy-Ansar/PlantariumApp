package com.PlantariumApp.springboot.repository;

import com.PlantariumApp.springboot.model.Seasons;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeasonsRepository extends JpaRepository<Seasons, Long> {

    Seasons findSeasonsById(long id);
}
