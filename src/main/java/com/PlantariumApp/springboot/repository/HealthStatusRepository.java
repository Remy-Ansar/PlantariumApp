package com.PlantariumApp.springboot.repository;

import com.PlantariumApp.springboot.model.HealthStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HealthStatusRepository extends JpaRepository<HealthStatus, Long> {

    HealthStatus findHealthStatusById(Long id);
}
