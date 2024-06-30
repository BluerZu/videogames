package com.blue.videogames.controllers;

import com.blue.videogames.models.Developer;
import com.blue.videogames.services.DeveloperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path="api/v1/developers")
public class DeveloperController {

    private final DeveloperService developerService;

    @Autowired
    public DeveloperController(DeveloperService developerService) {
        this.developerService = developerService;
    }

    @GetMapping
    public List<Developer> getAllDevelopers() {
        return developerService.getAllDevelopers();
    }

    @PostMapping
    public Developer createDeveloper(@RequestBody Developer developer) {
        return developerService.createDeveloper(developer);
    }

    @PutMapping("/{id}")
    public Developer updateDeveloper(@RequestBody Developer developer, @PathVariable Long id) {
        developer.setId(id);
        return developerService.updateDeveloper(developer);
    }

    @DeleteMapping("/{id}")
    public Map<String, String> deleteDeveloper(@PathVariable Long id) {
        developerService.deleteDeveloper(id);
        Map<String, String> response = new HashMap<>();
        response.put("response", "Desarrollador con id " + id + " borrado correctamente");
        return response;
    }
}
