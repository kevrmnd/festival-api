package com.ada.festival.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ada.festival.dto.ArtisteRequest;
import com.ada.festival.model.Artiste;
import com.ada.festival.model.ArtisteDetail;
import com.ada.festival.model.Genre;
import com.ada.festival.model.Scene;
import com.ada.festival.repository.ArtisteRepository;
import com.ada.festival.repository.SceneRepository;
import com.ada.festival.repository.GenreRepository;

@Service
public class ArtisteService {
    private final ArtisteRepository artisteRepository;
    private final SceneRepository sceneRepository;
    private final GenreRepository genreRepository;

    public ArtisteService(ArtisteRepository artisteRepository, SceneRepository sceneRepository, GenreRepository genreRepository) {
        this.artisteRepository = artisteRepository;
        this.sceneRepository = sceneRepository;
        this.genreRepository = genreRepository;
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
    
    public List<Artiste> findByScene(int sceneId) {
        List<Artiste> result = new ArrayList<>();
        for (Artiste artiste : artisteRepository.findAll()) {
            if (artiste.getSceneId() == sceneId) {
                result.add(artiste);
            }
        }
        return result;
    }
    
    public List<Artiste> findByGenre(int genreId) {
        List<Artiste> result = new ArrayList<>();
        for (Artiste artiste : artisteRepository.findAll()) {
            if (artiste.getGenreId() == genreId) {
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

    public List<ArtisteDetail> withDetails(List<Artiste> artistes) {
        List<Scene> scenes = sceneRepository.findAll();
        List<Genre> genres = genreRepository.findAll();

        List<ArtisteDetail> artistsWithDetails = new ArrayList<>();
        for (Artiste artiste : artistes) {
            Scene artisteScene = null;
            for (Scene scene : scenes) {
                if (scene.getId() == artiste.getSceneId()) {
                    artisteScene = scene;
                    break;
                }
            }
            Genre artisteGenre = null;
            for (Genre genre : genres) {
                if (genre.getId() == artiste.getGenreId()) {
                    artisteGenre = genre;
                    break;
                }
            }
            ArtisteDetail artisteDetail = new ArtisteDetail(artiste, artisteGenre, artisteScene);
            artistsWithDetails.add(artisteDetail);
        }
        return artistsWithDetails;
    }

    public void create(Artiste artiste){
        artisteRepository.create(artiste);
    }    
    
    public void delete(Artiste artiste){
        artisteRepository.delete(artiste);
    }    

    public void modify(Artiste artisteAModifier, ArtisteRequest request){
        artisteAModifier.setJour(request.jour());
        artisteAModifier.setHeure(request.heure());
    }
}