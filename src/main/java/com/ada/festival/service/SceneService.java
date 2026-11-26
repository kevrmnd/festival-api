package com.ada.festival.service;

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

    public List<Scene> findByName(String text) {
        List<Scene> result = new ArrayList<>();
        for (Scene scene : sceneRepository.findAll()) {
            if (scene.getName().toLowerCase().contains(text.toLowerCase())) {
                result.add(scene);
            }
        }
        return result;
    }
}