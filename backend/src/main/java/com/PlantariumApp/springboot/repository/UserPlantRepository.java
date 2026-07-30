package com.PlantariumApp.springboot.repository;

import com.PlantariumApp.springboot.model.UserPlant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserPlantRepository extends JpaRepository<UserPlant, Long> {

    UserPlant findUserPlantById(Long id);

}
