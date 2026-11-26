package com.ada.festival.controller;

import com.ada.festival.model.Genre;
import com.ada.festival.service.GenreService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GenreController {
    private final GenreService service;

    public GenreController(GenreService service){ this.service = service; }

    @GetMapping("/genres")
    public List<Genre> getGenres(
            @RequestParam(required = false) String nom
    ) {
        if (nom != null) return service.findByName(nom);
        return service.findAll();
    }
}
