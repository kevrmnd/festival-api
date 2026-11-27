package com.ada.festival.model;

public class Scene {
    private final String nom;
    private int capacite;
    private String description;

    public Scene(String nom, int capacite, String description) {
        this.nom = nom;
        this.capacite = capacite;
        this.description = description;
    }

    public String getNom() { return nom; }
    public int getCapacite() { return capacite; }
    public String getDescription() { return description; }
    
    public void setCapacite(int capacite){ this.capacite = capacite; }
    public void setDescription(String description){ this.description = description; }
}
