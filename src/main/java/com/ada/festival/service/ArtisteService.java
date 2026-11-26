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

    public List<Artiste> findByNom(String text) {
        List<Artiste> result = new ArrayList<>();
        for (Artiste artiste : artisteRepository.findAll()) {
            if (artiste.getNom().toLowerCase().contains(text.toLowerCase())) {
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
    
    public Artiste findOneByNom(String text) {
        for (Artiste artiste : artisteRepository.findAll()) {
            if (artiste.getNom().toLowerCase().contains(text.toLowerCase())) {
                return artiste;
            }
        }
        return null;
    }

    public void create(Artiste artiste){
        artisteRepository.create(artiste);
    }    
    
    public void delete(Artiste artiste){
        artisteRepository.delete(artiste);
    }    

    public void modify(Artiste artisteAModifier, Artiste artiste){
        artisteAModifier.setJour(artiste.getJour());
        artisteAModifier.setHeure(artiste.getHeure());
    }
}