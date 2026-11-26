package com.ada.festival.controller;

import com.ada.festival.model.Scene;
import com.ada.festival.service.SceneService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/scenes")
public class SceneController {

    private final SceneService service;

    public SceneController(SceneService service) {
        this.service = service;
    }

    @GetMapping
    public List<Scene> getScenes(@RequestParam(required = false) String nom) {
        if (nom != null) {
            return service.findByName(nom);
        }
        return service.findAll();
    }
}