package com.ada.festival.model;

public class Genre {
    private final String nom;
    private String description;

    public Genre(String nom, String description){
        this.nom = nom;
        this.description = description;
    }

    public String getNom(){ return nom; }
    public String getDescription(){ return description; }

    public void setDescription(String description){ this.description = description; }
}
