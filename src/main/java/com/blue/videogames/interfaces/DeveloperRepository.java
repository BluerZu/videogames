package com.blue.videogames.interfaces;

import com.blue.videogames.models.Developer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeveloperRepository extends JpaRepository<Developer, Long> {
}
