package com.blue.videogames.interfaces;

import com.blue.videogames.models.Videogame;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideogameRepository extends JpaRepository<Videogame, Long> {
}
