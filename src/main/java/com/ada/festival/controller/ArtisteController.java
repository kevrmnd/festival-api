package com.ada.festival.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ada.festival.model.Artiste;
import com.ada.festival.service.ArtisteService;

@RestController 
public class ArtisteController {
    private final ArtisteService service;
    
    public ArtisteController(ArtisteService service) {
        this.service = service;
    }
    
    @GetMapping("/artistes")
    public ResponseEntity<Object> getArtistes(
        @RequestParam(required = false) String nom,
        @RequestParam(required = false) String jour,
        @RequestParam(required = false) String genre
    ) {
        List<Artiste> artistes;

        if (nom != null) {
            artistes = service.findByNom(nom);
        } else if (jour != null) {
            artistes = service.findByJour(jour);
        } else {
            artistes = service.findAll();
        }

        if (artistes.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("error", "Aucun artiste ne correspond à votre recherche"));
        }
        return ResponseEntity.ok(artistes);
    }

    @PostMapping("/artistes")
    public ResponseEntity<Artiste> create(@RequestBody Artiste artiste){
        service.create(artiste);
        return ResponseEntity.status(HttpStatus.CREATED).body(artiste);
    }

    @PutMapping("/artistes/{nom}")
    public ResponseEntity<?> modify(
        @PathVariable String nom,
        @RequestBody Artiste artiste
    ){
        Artiste artisteAModifier = service.findOneByNom(nom);
        if(artisteAModifier == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("error", "Artiste introuvable"));
        }
        service.modify(artisteAModifier, artiste);
        return ResponseEntity.status(HttpStatus.OK).body(artiste);
    }

    @DeleteMapping("/artistes/{nom}")
    public ResponseEntity<?> deleteArtiste(
        @PathVariable String nom
    ) {
        Artiste artisteASupprimer = service.findOneByNom(nom);
        if(artisteASupprimer == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("error", "Artiste introuvable"));
        }
        service.delete(artisteASupprimer);
        return ResponseEntity.noContent().build();
    }
}