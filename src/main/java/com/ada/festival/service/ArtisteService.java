package com.ada.festival.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ada.festival.model.Artiste;
import com.ada.festival.repository.ArtisteRepository;

@Service
public class ArtisteService {
    private final ArtisteRepository artisteRepository;

    public ArtisteService(ArtisteRepository artisteRepository) {
        this.artisteRepository = artisteRepository;
    }

    public List<Artiste> findAll() {
        return artisteRepository.findAll();
    }

    public List<Artiste> findByName(String text) {
        List<Artiste> result = new ArrayList<>();
        for (Artiste artiste : artisteRepository.findAll()) {
            if (artiste.getName().toLowerCase().contains(text.toLowerCase())) {
                result.add(artiste);
            }
        }
        return result;
    }

    public List<Artiste> findByJour(String text) {
        List<Artiste> result = new ArrayList<>();
        for (Artiste artiste : artisteRepository.findAll()) {
            if (artiste.getJour().toLowerCase().contains(text.toLowerCase())) {
                result.add(artiste);
            }
        }
        return result;
    }
}