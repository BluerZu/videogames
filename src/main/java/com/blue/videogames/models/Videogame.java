package com.blue.videogames.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.util.*;

@Data
@Entity
public class Videogame {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private Date releaseDate;
    private double price;
    private int stockQuantity;

    @ManyToOne
    @JoinColumn(name = "genreId")
    @JsonIgnoreProperties("videogames")
    private Genre genre;

    @ManyToOne
    @JoinColumn(name = "platformId")
    @JsonIgnoreProperties("videogames")
    private Platform platform;

    @ManyToOne
    @JoinColumn(name = "developerId")
    @JsonIgnoreProperties("videogames")
    private Developer developer;
}
