package com.blue.videogames.services;

import com.blue.videogames.interfaces.VideogameRepository;
import com.blue.videogames.models.Videogame;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideogameService {

    @Autowired
    private VideogameRepository videogameRepository;

    public List<Videogame> getAllVideogames(){
        return videogameRepository.findAll();
    }
    public Videogame createVideogame(Videogame videogame){
        return videogameRepository.save(videogame);
    }
    public Videogame updateVideogame(Videogame videogame){
        return videogameRepository.save(videogame);
    }
    public void deleteVideogame(Long id){
        videogameRepository.deleteById(id);
    }
}
