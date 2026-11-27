package com.ada.festival.repository;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

import com.ada.festival.model.Genre;

@Repository
public class GenreRepository {
    private final List<Genre> genres = new ArrayList<>();

    public GenreRepository(){
        genres.add(new Genre(1, "Rock", "guitares électriques, batterie, énergie"));
        genres.add(new Genre(2, "Folk", "guitares acoustiques, chansons qui racontent"));
        genres.add(new Genre(3, "Jazz", "improvisation, cuivres, swing"));
        genres.add(new Genre (4, "Soul", "voix puissantes, héritée du gospel"));
        genres.add(new Genre (5, "Hip-hop", "rythme et paroles, le rap"));
        genres.add(new Genre (6, "Electro", "musique électronique, faite pour danser"));
    }

    public List<Genre> findAll(){ return genres; }
    
    public void delete(Genre genre) {
        genres.remove(genre);
    }
    
    public void create(Genre genre){
        genres.add(genre);
    }
}
