package com.ada.festival.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder ({ "id", "nom", "jour", "heure" })
public class Artiste {
    private final int id;
    private final String nom;
    private String jour;
    private String heure;
    @JsonIgnore
    private int genreId;
    @JsonIgnore
    private int sceneId;

    public Artiste(int id, String nom, String jour, String heure, int genreId, int sceneId) {
        this.id = id;
        this.nom = nom;
        this.jour = jour;
        this.heure = heure;
        this.genreId = genreId;
        this.sceneId = sceneId;
    }

    public int getId() { return id; }
    public String getNom() { return nom; }
    public String getJour() { return jour; }
    public String getHeure() { return heure; }
    public int getGenreId() { return genreId; }
    public int getSceneId() { return sceneId; }

    public void setJour(String jour) { this.jour = jour; }
    public void setHeure(String heure) { this.heure = heure; }
}