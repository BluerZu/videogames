package com.blue.videogames.controllers;

import com.blue.videogames.models.Genre;
import com.blue.videogames.services.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path="api/v1/genres")
public class GenreController {

    private final GenreService genreService;

    @Autowired
    public GenreController(GenreService genreService) {
        this.genreService = genreService;
    }

    @GetMapping
    public List<Genre> getAllGenres() {
        return genreService.getAllGenres();
    }

    @PostMapping
    public Genre createGenre(@RequestBody Genre genre) {
        return genreService.createGenre(genre);
    }

    @PutMapping("/{id}")
    public Genre updateGenre(@RequestBody Genre genre, @PathVariable Long id) {
        genre.setId(id);
        return genreService.updateGenre(genre);
    }

    @DeleteMapping("/{id}")
    public Map<String, String> deleteGenre(@PathVariable Long id) {
        genreService.deleteGenre(id);
        Map<String, String> response = new HashMap<>();
        response.put("response", "Género con id " + id + " borrado correctamente");
        return response;
    }
}
