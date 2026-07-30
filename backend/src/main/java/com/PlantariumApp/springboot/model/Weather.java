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
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "Weather", uniqueConstraints = {
        @UniqueConstraint(columnNames = "condition_name")
})
public class Weather implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_weather", unique = true, nullable = false)
    @Hidden
    private Long id;

    @Column(name = "condition_name", length = 100)
    private String conditionName;

    @Column(name = "condition_description", length = 255)
    private String conditionDescription;

    /*
     * SQL: temperature DECIMAL(5,2)
     * Java: BigDecimal is preferred for DECIMAL to avoid floating point rounding.
     * Use JPA @Column precision and scale to match the SQL definition.
     */
    @Column(name = "temperature", precision = 5, scale = 2)
    private BigDecimal temperature;

    @Column(name = "humidity")
    private Integer humidity;

    @Column(name = "wind_speed", precision = 5, scale = 2)
    private BigDecimal windSpeed;

    @Column(name = "city", length = 100)
    private String city;

    @Column(name = "recorded_at", nullable = false, updatable = true)
    @JsonFormat(pattern = "dd/MM/yyyy")
    @UpdateTimestamp
    private LocalDateTime recordedAt;
}