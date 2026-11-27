package com.ada.festival.model;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder ({ "id", "nom", "description" })
public class Genre {
    private final int id;
    private final String nom;
    private String description;

    public Genre(int id, String nom, String description){
        this.id = id;
        this.nom = nom;
        this.description = description;
    }

    public int getId(){ return id; }
    public String getNom(){ return nom; }
    public String getDescription(){ return description; }

    public void setDescription(String description){ this.description = description; }
}
