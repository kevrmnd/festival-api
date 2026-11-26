package com.ada.festival.repository;

// Un genre a un nom et une description.

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

// Rock	guitares électriques, batterie, énergie
// Folk	guitares acoustiques, chansons qui racontent
// Jazz	improvisation, cuivres, swing
// Soul	voix puissantes, héritée du gospel
// Hip-hop	rythme et paroles, le rap
// Électro	musique électronique, faite pour danser
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
    
}
