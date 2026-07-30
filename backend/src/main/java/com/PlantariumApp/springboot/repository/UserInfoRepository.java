package com.PlantariumApp.springboot.repository;

import com.PlantariumApp.springboot.model.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserInfoRepository extends JpaRepository<UserInfo, Long> {

    UserInfo findUserInfoById(Long id);

    @Query("SELECT c FROM UserInfo c WHERE LOWER(TRIM(c.firstName)) = LOWER(TRIM(:firstName))")
    UserInfo findUserInfoByFirstName(String firstName);

    @Query("SELECT c FROM UserInfo c WHERE LOWER(TRIM(c.lastName)) = LOWER(TRIM(:lastName))")
    UserInfo findUserInfoByLastName(String lastName);


}
