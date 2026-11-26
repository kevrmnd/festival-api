package com.ada.festival.repository;

// Une scène a un nom, une capacité et une description.

// Grande Scène : 8 000 places, en plein air, face au port.
// Chapiteau : 2 000 places, sous toile, pour les soirées tardives.
// Scène du Port : 600 places, au bord de l'eau, pour les concerts intimistes.
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class SceneRepository {
    private final List<Scene> scenes = new ArrayList<>();

    public SceneRepository() {
        scenes.add(new Scene("La Grande Scène : 8 000, en plein air,face au port."));
        scenes.add(new Scene("La Scène du Port : 600, au bord de l'eau, pour les concerts intimistes."));
        scenes.add(new Scene("La Grande Scène : 8 000, en plein air,face au port du hip-hop et de l'électro."));
        scenes.add(new Scene("Le Chapiteau : 2 000, sous toile, pour les soirées tardives."));
        scenes.add(new Scene("La Scène du Port : 600, au bord de l'eau, pour les concerts intimistes."));
    }

    public List<Scene> findAll() {return scenes;}
