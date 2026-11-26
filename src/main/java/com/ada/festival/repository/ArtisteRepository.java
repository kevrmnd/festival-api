package com.ada.festival.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

// Un artiste a un nom, un jour, une heure de passage, une scène et une liste de genres.

// Les Marées Hautes jouent le vendredi à 21h, sur la Grande Scène : du rock et du folk. 
// Nina Sol joue le vendredi à 19h, sur la Scène du Port : du jazz et de la soul. 
// Kryptik joue le samedi à 21h, sur la Grande Scène : du hip-hop et de l'électro. 
// DJ Lumen joue le samedi à 23h, sous le Chapiteau : de l'électro. 
// Les Bricoleuses jouent le dimanche à 18h, sur la Scène du Port : du folk.

@Repository
public class ArtisteRepository {
    private final List<Artiste> artistes = new ArrayList<>();
    
    public ArtisteRepository() {
        artistes.add(new Artiste("Les Marées Hautes", "vendredi à 21h"));
        artistes.add(new Artiste("Nina Sol", "vendredi à 19h"));
        artistes.add(new Artiste("Kryptik", "samedi à 21h"));
        artistes.add(new Artiste("DJ Lumen", "samedi à 23h"));
        artistes.add(new Artiste("Les Bricoleuses", "dimanche à 18h"));
    }    
    
    public List<Artiste> findAll() {
        return artistes;
    }

    // public void delete(Hero hero) {
    //     heroes.remove(hero);
    // }
    
    // public void create(Hero hero){
    //     heroes.add(hero);
    // }
}
