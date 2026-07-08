package com.PlantariumApp.springboot.repository;

import com.PlantariumApp.springboot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    User findUserById(Long id);

    User findUserByEmail(String email);

    List<User> findAll(Long id);

}
