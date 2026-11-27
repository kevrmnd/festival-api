package com.ada.festival.model;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder ({ "id", "nom", "capacite", "description" })
public class Scene {
    private final int id;
    private final String nom;
    private int capacite;
    private String description;

    public Scene(int id, String nom, int capacite, String description) {
        this.id = id;
        this.nom = nom;
        this.capacite = capacite;
        this.description = description;
    }

    public int getId() { return id; }
    public String getNom() { return nom; }
    public int getCapacite() { return capacite; }
    public String getDescription() { return description; }
    
    public void setCapacite(int capacite){ this.capacite = capacite; }
    public void setDescription(String description){ this.description = description; }
}
