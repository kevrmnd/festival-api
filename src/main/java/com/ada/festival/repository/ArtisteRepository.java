package com.ada.festival.repository;

import java.util.ArrayList;
import java.util.List;

import com.ada.festival.model.Artiste;
import org.springframework.stereotype.Repository;

@Repository
public class ArtisteRepository {
    private final List<Artiste> artistes = new ArrayList<>();
    
    public ArtisteRepository() {
        artistes.add(new Artiste(1, "Les Marées Hautes", "vendredi", "21h", 1, 1));
        artistes.add(new Artiste(2, "Nina Sol", "vendredi", "19h", 2, 1));
        artistes.add(new Artiste(3, "Kryptik", "samedi", "21h", 6, 2));
        artistes.add(new Artiste(4, "DJ Lumen", "samedi", "23h", 6, 2));
        artistes.add(new Artiste(5, "Les Bricoleuses", "dimanche", "18h", 3, 3));
    }    
    
    public List<Artiste> findAll() {
        return artistes;
    }

    public void delete(Artiste artiste) {
        artistes.remove(artiste);
    }
    
    public void create(Artiste artiste){
        artistes.add(artiste);
    }
}
