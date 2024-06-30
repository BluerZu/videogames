package com.blue.videogames.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;


@Data
@Entity
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;

    @OneToMany(mappedBy = "genre", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("genre")
    private List<Videogame> videogames = new ArrayList<>();
}
