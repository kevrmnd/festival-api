package com.ada.festival.controller;

import com.ada.festival.dto.SceneRequest;
import com.ada.festival.model.Scene;
import com.ada.festival.service.SceneService;

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
@RequestMapping("/scenes")
public class SceneController {

    private final SceneService service;

    public SceneController(SceneService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<Object> getScenes(@RequestParam(required = false) String nom) {
        List<Scene> scenes;

        if (nom != null) {
            scenes = service.findByNom(nom);
        } else {
            scenes = service.findAll();
        }
        
        if (scenes.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("error", "Aucune scène ne correspond à votre recherche"));
        }
        return ResponseEntity.ok(scenes);
    }

    @PostMapping
    public ResponseEntity<Scene> create(@RequestBody Scene scene){
        service.create(scene);
        return ResponseEntity.status(HttpStatus.CREATED).body(scene);
    }

    @PutMapping("/{nom}")
    public ResponseEntity<?> modify(
        @PathVariable String nom,
        @RequestBody SceneRequest request
    ){
        Scene sceneAModifier = service.findOneByNom(nom);
        if(sceneAModifier == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("error", "Scène introuvable"));
        }
        service.modify(sceneAModifier, request);
        return ResponseEntity.status(HttpStatus.OK).body(sceneAModifier);
    }

    @DeleteMapping("/{nom}")
    public ResponseEntity<?> deleteGenre(
        @PathVariable String nom
    ) {
        Scene sceneASupprimer = service.findOneByNom(nom);
        if(sceneASupprimer == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("error", "Scène introuvable"));
        }
        service.delete(sceneASupprimer);
        return ResponseEntity.noContent().build();
    }
}