package com.ada.festival.service;

import com.ada.festival.model.Genre;
import com.ada.festival.repository.GenreRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GenreService {
    private final GenreRepository genreRepository;

    public GenreService(GenreRepository genreRepository){
        this.genreRepository = genreRepository;
    }

    public List<Genre> findAll(){ return genreRepository.findAll();}

    public List<Genre> findByName(String text){
        List<Genre> result = new ArrayList<>();
        for (Genre genre : genreRepository.findAll()){
            if (genre.getName().toLowerCase().contains(text.toLowerCase())){
                result.add(genre);
            }
        }
        return result;
    }
}

