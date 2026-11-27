package com.ada.festival.service;

import com.ada.festival.dto.GenreRequest;
import com.ada.festival.model.Artiste;
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

    public List<Genre> findByNom(String text){
        List<Genre> result = new ArrayList<>();
        for (Genre genre : genreRepository.findAll()){
            if (genre.getNom().toLowerCase().contains(text.toLowerCase())){
                result.add(genre);
            }
        }
        return result;
    }
    
    public Genre findOneByNom(String text) {
        for (Genre genre : genreRepository.findAll()) {
            if (genre.getNom().toLowerCase().contains(text.toLowerCase())) {
                return genre;
            }
        }
        return null;
    }
        
    public void create(Genre genre){
        genreRepository.create(genre);
    }

    public void modify(Genre genreAModifier, GenreRequest request){
        genreAModifier.setDescription(request.description());
    }

    public void delete(Genre genre){
        genreRepository.delete(genre);
    }
}

