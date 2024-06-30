package com.blue.videogames.interfaces;

import com.blue.videogames.models.Platform;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlatformRepository extends JpaRepository<Platform, Long> {
}
