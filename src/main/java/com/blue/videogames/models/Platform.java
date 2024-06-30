package com.blue.videogames.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Data
@Entity
public class Platform {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Date releaseDate;
    private String type;

    @OneToMany(mappedBy = "platform", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("platform")
    private List<Videogame> videogames = new ArrayList<>();
}
