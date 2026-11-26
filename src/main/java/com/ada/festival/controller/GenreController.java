package com.ada.festival.controller;

import com.ada.festival.model.Genre;
import com.ada.festival.service.GenreService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class GenreController {
    private final GenreService service;

    public GenreController(GenreService service){ this.service = service; }

    @GetMapping("/genres")
    public ResponseEntity<Object> getGenres(
            @RequestParam(required = false) String nom
    ) {
        List<Genre> genres;

        if (nom != null) {
            genres = service.findByNom(nom);
        } else {
            genres = service.findAll();
        }
        
        if (genres.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("error", "Aucun genre ne correspond à votre recherche"));
        }
        return ResponseEntity.ok(genres);
    }
}
