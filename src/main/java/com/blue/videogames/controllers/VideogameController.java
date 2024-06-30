package com.blue.videogames.controllers;

import com.blue.videogames.models.Videogame;
import com.blue.videogames.services.VideogameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path="api/v1/videogames")
public class VideogameController {

    private final VideogameService videogameService;

    @Autowired
    public VideogameController(VideogameService videogameService) {
        this.videogameService = videogameService;
    }
    @GetMapping
    public List<Videogame> getVideogames(){
        return videogameService.getAllVideogames();
    }
    @PostMapping
    public Videogame createVideogame(@RequestBody Videogame videogame){
        return videogameService.createVideogame(videogame);
    }
    @PutMapping("/{id}")
    public Videogame updateVideogame(@RequestBody Videogame videogame, @PathVariable Long id){
        videogame.setId(id);
        return videogameService.createVideogame(videogame);
    }
    @DeleteMapping("/{id}")
    public Map<String, String> deleteVideogame(@PathVariable Long id) {
        videogameService.deleteVideogame(id);
        Map<String, String> response = new HashMap<>();
        response.put("response", "Videojuego con id " + id + " borrado correctamente");
        return response;
    }
}
