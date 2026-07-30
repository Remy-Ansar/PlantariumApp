package com.PlantariumApp.springboot.repository;

import com.PlantariumApp.springboot.model.Weather;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WeatherRepository extends JpaRepository<Weather, Long> {

    Weather findWeatherById(Long id);

}
