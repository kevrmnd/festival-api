package com.ada.festival.model;

public class Scene {
    private final String nom;
    private final int capacite;
    private final String description;

    public Scene(String nom, int capacite, String description) {
        this.nom = nom;
        this.capacite = capacite;
        this.description = description;
    }

    public String getName() { return nom; }
    public int getCapacite() { return capacite; }
    public String getDescription() { return description; }
}
