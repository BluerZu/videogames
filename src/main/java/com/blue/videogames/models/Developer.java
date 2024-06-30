package com.blue.videogames.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class Developer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String headquarters;
    private Date foundedYear;


    @OneToMany(mappedBy = "developer", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("developer")
    private List<Videogame> videogames = new ArrayList<>();
}
