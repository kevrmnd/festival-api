package com.ada.festival.controller;

import com.ada.festival.dto.GenreRequest;
import com.ada.festival.model.Genre;
import com.ada.festival.service.GenreService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/genres")
public class GenreController {
    private final GenreService service;

    public GenreController(GenreService service){ this.service = service; }

    @GetMapping
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

    @PostMapping
    public ResponseEntity<Genre> create(@RequestBody Genre genre){
        service.create(genre);
        return ResponseEntity.status(HttpStatus.CREATED).body(genre);
    }

    @PutMapping("/{nom}")
    public ResponseEntity<?> modify(
        @PathVariable String nom,
        @RequestBody GenreRequest request
    ){
        Genre genreAModifier = service.findOneByNom(nom);
        if(genreAModifier == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("error", "Genre introuvable"));
        }
        service.modify(genreAModifier, request);
        return ResponseEntity.status(HttpStatus.OK).body(genreAModifier);
    }

    @DeleteMapping("/{nom}")
    public ResponseEntity<?> deleteGenre(
        @PathVariable String nom
    ) {
        Genre genreASupprimer = service.findOneByNom(nom);
        if(genreASupprimer == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("error", "Genre introuvable"));
        }
        service.delete(genreASupprimer);
        return ResponseEntity.noContent().build();
    }
}
