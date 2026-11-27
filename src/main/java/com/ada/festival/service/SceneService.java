package com.ada.festival.service;

import com.ada.festival.dto.SceneRequest;
import com.ada.festival.model.Scene;
import com.ada.festival.repository.SceneRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SceneService {
    private final SceneRepository sceneRepository;

    public SceneService(SceneRepository sceneRepository) {
        this.sceneRepository = sceneRepository;
    }

    public List<Scene> findAll() {
        return sceneRepository.findAll();
    }

    public List<Scene> findByNom(String text) {
        List<Scene> result = new ArrayList<>();
        for (Scene scene : sceneRepository.findAll()) {
            if (scene.getNom().toLowerCase().contains(text.toLowerCase())) {
                result.add(scene);
            }
        }
        return result;
    }
    
    public Scene findOneByNom(String text) {
        for (Scene scene : sceneRepository.findAll()) {
            if (scene.getNom().toLowerCase().contains(text.toLowerCase())) {
                return scene;
            }
        }
        return null;
    }
    
    public void create(Scene scene){
        sceneRepository.create(scene);
    }    

    public void modify(Scene sceneAModifier, SceneRequest request){
        sceneAModifier.setCapacite(request.capacite());
        sceneAModifier.setDescription(request.description());
    }

    public void delete(Scene scene){
        sceneRepository.delete(scene);
    }  
}