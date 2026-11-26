package com.ada.festival.model;

public class Genre {
    private final String nom;
    private final String description;

    public Genre(String genre, String description){
        this.nom = genre;
        this.description = description;
    }

    public String getNom(){ return nom; }
    public String getDescription(){ return description; }
}
