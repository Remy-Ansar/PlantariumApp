package com.PlantariumApp.springboot.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.Hidden;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "User_info")
public class UserInfo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user_info", unique = true, nullable = false)
    @Hidden
    private Long id;

    @Column(nullable = true, name = "firstName")
    private String firstName;

    @Column(nullable = true, name = "lastName")
    private String lastName;

    @Column(nullable = true, name = "profile_image_path")
    private String profileImagePath;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @Column(updatable = false)
    @CreationTimestamp
    private String createdAt;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @Column(updatable = true)
    @UpdateTimestamp
    private String updatedAt;

    @OneToOne
    @JoinColumn(name = "userInfo", referencedColumnName = "id_user", nullable = false, unique = true)
    private User user_id;
}
