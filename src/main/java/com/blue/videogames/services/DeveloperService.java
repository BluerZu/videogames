package com.blue.videogames.services;

import com.blue.videogames.interfaces.DeveloperRepository;
import com.blue.videogames.models.Developer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeveloperService {

    @Autowired
    private DeveloperRepository developerRepository;

    public List<Developer> getAllDevelopers() {
        return developerRepository.findAll();
    }

    public Developer createDeveloper(Developer developer) {
        return developerRepository.save(developer);
    }

    public Developer updateDeveloper(Developer developer) {
        // Verifica si el desarrollador ya existe
        Developer existingDeveloper = developerRepository.findById(developer.getId()).orElse(null);
        if (existingDeveloper != null) {
            return developerRepository.save(developer);
        }
        return null; // Manejar este caso según tu lógica de negocio
    }

    public void deleteDeveloper(Long id) {
        developerRepository.deleteById(id);
    }
}
