package com.ada.festival.model;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder ({ "id", "nom", "jour", "heure", "genre", "scene" })
public class ArtisteDetail {
    private final int id;
    private final String nom;
    private String jour;
    private String heure;
    private final Genre genre;
    private final Scene scene;

    public ArtisteDetail(Artiste artiste, Genre genre, Scene scene) {
        this.id = artiste.getId();
        this.nom = artiste.getNom();
        this.jour = artiste.getJour();
        this.heure = artiste.getHeure();
        this.genre = genre;
        this.scene = scene;
    }

    public int getId() { return id; }
    public String getNom() { return nom; }
    public String getJour() { return jour; }
    public String getHeure() { return heure; }
    public Genre getGenre() { return genre; }
    public Scene getScene() { return scene; }
}
