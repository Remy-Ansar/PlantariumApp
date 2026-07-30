package com.PlantariumApp.springboot.repository;


import com.PlantariumApp.springboot.model.Categories;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriesRepository extends JpaRepository<Categories, Long> {

    Categories findCategoriesById(Long id);
}
