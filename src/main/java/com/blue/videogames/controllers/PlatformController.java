package com.blue.videogames.controllers;

import com.blue.videogames.models.Platform;
import com.blue.videogames.services.PlatformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path="api/v1/platforms")
public class PlatformController {

    private final PlatformService platformService;

    @Autowired
    public PlatformController(PlatformService platformService) {
        this.platformService = platformService;
    }

    @GetMapping
    public List<Platform> getAllPlatforms() {
        return platformService.getAllPlatforms();
    }

    @PostMapping
    public Platform createPlatform(@RequestBody Platform platform) {
        return platformService.createPlatform(platform);
    }

    @PutMapping("/{id}")
    public Platform updatePlatform(@RequestBody Platform platform, @PathVariable Long id) {
        platform.setId(id);
        return platformService.updatePlatform(platform);
    }

    @DeleteMapping("/{id}")
    public Map<String, String> deletePlatform(@PathVariable Long id) {
        platformService.deletePlatform(id);
        Map<String, String> response = new HashMap<>();
        response.put("response", "Plataforma con id " + id + " borrada correctamente");
        return response;
    }
}
