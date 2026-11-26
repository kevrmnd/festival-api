package com.ada.festival.controller;

import com.ada.festival.model.Genre;
import com.ada.festival.model.Scene;
import com.ada.festival.service.SceneService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
}