package com.blue.videogames.services;

import com.blue.videogames.interfaces.GenreRepository;
import com.blue.videogames.models.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreService {

    @Autowired
    private GenreRepository genreRepository;

    public List<Genre> getAllGenres() {
        return genreRepository.findAll();
    }

    public Genre createGenre(Genre genre) {
        return genreRepository.save(genre);
    }

    public Genre updateGenre(Genre genre) {
        // Verifica si el género ya existe
        Genre existingGenre = genreRepository.findById(genre.getId()).orElse(null);
        if (existingGenre != null) {
            return genreRepository.save(genre);
        }
        return null; // Manejar este caso según tu lógica de negocio
    }

    public void deleteGenre(Long id) {
        genreRepository.deleteById(id);
    }
}
