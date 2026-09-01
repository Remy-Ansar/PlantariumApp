package com.PlantariumApp.springboot.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.Hidden;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;

public class PlantDetailWatering implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_plant_detail_watering", unique = true, nullable = false)
    @Hidden
    private Long id;

    @Column(name = "note")
    private String note;

    @Column(name = "frequency")
    private Integer frequency;

    @Column(name = "quantity", precision = 5, scale = 2)
    private BigDecimal quantity;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @Column(updatable = false)
    @CreationTimestamp
    private String createdAt;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @Column(updatable = true)
    @UpdateTimestamp
    private String updatedAt;
}
