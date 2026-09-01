package com.PlantariumApp.springboot.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.Hidden;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;

public class PlantDetail implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_species", unique = true, nullable = false)
    @Hidden
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "nickname")
    private String nickname;

    @Column(name = "personal_notes")
    private String personalNotes;

    @Column(name = "image_path")
    private String imagePath;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @Column(updatable = false)
    @CreationTimestamp
    private String createdAt;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @Column(updatable = true)
    @UpdateTimestamp
    private String updatedAt;
}
