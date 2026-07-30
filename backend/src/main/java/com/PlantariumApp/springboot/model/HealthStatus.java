package com.PlantariumApp.springboot.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.Hidden;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "HealthStatus")
public class HealthStatus implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_health_status", unique = true, nullable = false)
    @Hidden
    private Long id;

    @Column(name = "status", nullable = false, unique = true)
    private String status;

    @Column(name = "recorded_at", nullable = false, updatable = true)
    @JsonFormat(pattern = "dd/MM/yyyy")
    @UpdateTimestamp
    private LocalDateTime recordedAt;

}