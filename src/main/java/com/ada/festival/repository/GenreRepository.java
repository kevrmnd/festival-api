package com.ada.festival.repository;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

import com.ada.festival.model.Genre;

@Repository
public class GenreRepository {
    private final List<Genre> genres = new ArrayList<>();

    public GenreRepository(){
        genres.add(new Genre("Rock", "guitares électriques, batterie, énergie"));
        genres.add(new Genre("Folk", "guitares acoustiques, chansons qui racontent"));
        genres.add(new Genre("Jazz", "improvisation, cuivres, swing"));
        genres.add(new Genre ("Soul", "voix puissantes, héritée du gospel"));
        genres.add(new Genre ("Hip-hop", "rythme et paroles, le rap"));
        genres.add(new Genre ("Electro", "musique électronique, faite pour danser"));
    }

    public List<Genre> findAll(){ return genres; }
    
    public void delete(Genre genre) {
        genres.remove(genre);
    }
    
    public void create(Genre genre){
        genres.add(genre);
    }
}
