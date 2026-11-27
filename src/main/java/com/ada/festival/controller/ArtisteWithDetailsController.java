package com.ada.festival.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ada.festival.model.ArtisteDetail;
import com.ada.festival.model.Genre;
import com.ada.festival.model.Scene;
import com.ada.festival.service.ArtisteService;
import com.ada.festival.service.GenreService;
import com.ada.festival.service.SceneService;

@RestController
@RequestMapping("/artistes-with-details") 
public class ArtisteWithDetailsController {
    private final ArtisteService service;
    private final SceneService sceneService;
    private final GenreService genreService;
    
    public ArtisteWithDetailsController(ArtisteService service, SceneService sceneService, GenreService genreService) {
        this.service = service;
        this.sceneService = sceneService;
        this.genreService = genreService;
    }
    
    @GetMapping
    public ResponseEntity<Object> getArtistes(
        @RequestParam(required = false) String nom,
        @RequestParam(required = false) String jour,
        @RequestParam(required = false) String scene,
        @RequestParam(required = false) String genre
    ) {
        List<ArtisteDetail> artistesWithDetails;

        if (nom != null) {
            artistesWithDetails = service.withDetails(service.findByNom(nom));
        } else if (jour != null) {
            artistesWithDetails = service.withDetails(service.findByJour(jour));
        } else if (scene != null) {
            Scene foundScene = sceneService.findOneByNom(scene);    
            if (foundScene == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Map.of("error", "Aucune scene ne correspond à votre recherche"));
            }
            artistesWithDetails = service.withDetails(service.findByScene(foundScene.getId()));
        } else if (genre != null) {
            Genre foundGenre = genreService.findOneByNom(genre);    
            if (foundGenre == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Map.of("error", "Aucune genre ne correspond à votre recherche"));
            }
            artistesWithDetails = service.withDetails(service.findByGenre(foundGenre.getId()));
        } else {
            artistesWithDetails = service.withDetails(service.findAll());
        }

        if (artistesWithDetails.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("error", "Aucun artiste ne correspond à votre recherche"));
        }
        return ResponseEntity.ok(artistesWithDetails);
    }
}