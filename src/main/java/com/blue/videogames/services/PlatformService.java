package com.blue.videogames.services;

import com.blue.videogames.interfaces.PlatformRepository;
import com.blue.videogames.models.Platform;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlatformService {

    @Autowired
    private PlatformRepository platformRepository;

    public List<Platform> getAllPlatforms() {
        return platformRepository.findAll();
    }

    public Platform createPlatform(Platform platform) {
        return platformRepository.save(platform);
    }

    public Platform updatePlatform(Platform platform) {
        // Verifica si la plataforma ya existe
        Platform existingPlatform = platformRepository.findById(platform.getId()).orElse(null);
        if (existingPlatform != null) {
            return platformRepository.save(platform);
        }
        return null; // Manejar este caso según tu lógica de negocio
    }

    public void deletePlatform(Long id) {
        platformRepository.deleteById(id);
    }
}
