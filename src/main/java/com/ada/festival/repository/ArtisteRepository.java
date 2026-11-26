package com.ada.festival.repository;

import java.util.ArrayList;
import java.util.List;

import com.ada.festival.model.Artiste;
import org.springframework.stereotype.Repository;

@Repository
public class ArtisteRepository {
    private final List<Artiste> artistes = new ArrayList<>();
    
    public ArtisteRepository() {
        artistes.add(new Artiste("Les Marées Hautes", "vendredi", "21h"));
        artistes.add(new Artiste("Nina Sol", "vendredi", "19h"));
        artistes.add(new Artiste("Kryptik", "samedi", "21h"));
        artistes.add(new Artiste("DJ Lumen", "samedi", "23h"));
        artistes.add(new Artiste("Les Bricoleuses", "dimanche", "18h"));
    }    
    
    public List<Artiste> findAll() {
        return artistes;
    }

    // public void delete(Hero hero) {
    //     heroes.remove(hero);
    // }
    
    public void create(Artiste artiste){
        artistes.add(artiste);
    }
}
