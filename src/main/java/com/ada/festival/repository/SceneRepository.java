package com.ada.festival.repository;

import java.util.ArrayList;
import java.util.List;

import com.ada.festival.model.Scene;
import org.springframework.stereotype.Repository;

@Repository
public class SceneRepository {
    private final List<Scene> scenes = new ArrayList<>();

    public SceneRepository() {
        scenes.add(new Scene(1, "La Grande Scène", 8000, "en plein air, face au port."));
        scenes.add(new Scene(2, "Le Chapiteau", 2000, "sous toile, pour les soirées tardives."));
        scenes.add(new Scene(3, "La Scène du Port", 600, "au bord de l'eau, pour les concerts intimistes."));
    }

    public List<Scene> findAll() {
        return scenes;
    }
        
    public void delete(Scene scene) {
        scenes.remove(scene);
    }

    public void create(Scene scene){
        scenes.add(scene);
    }
}
