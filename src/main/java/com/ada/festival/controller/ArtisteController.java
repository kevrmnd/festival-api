package com.ada.festival.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
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
    
    @GetMapping("/artists")
    public List<Artiste> getArtistes(
        @RequestParam(required = false) String nom
        // @RequestParam(required = false) String role
    ) {
        // if (name != null && role != null) return service.findByNameAndRole(name, role);
        if (nom != null) return service.findByName(nom);
        // if (role != null) return service.findByRole(role);
        return service.findAll();
    }
}