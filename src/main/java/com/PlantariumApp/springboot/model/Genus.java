package com.PlantariumApp.springboot.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.Hidden;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "Genus", uniqueConstraints = {
        @UniqueConstraint(columnNames = "name")
})
public class Genus implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_genus", unique = true, nullable = false)
    @Hidden
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "genus", cascade = CascadeType.ALL, orphanRemoval = false)
    private List<Plants> plants = new ArrayList<>();
}