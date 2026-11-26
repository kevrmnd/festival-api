package com.ada.festival.model;

public class Artiste {
    private final String nom;
    private String jour;
    private String heure;

    public Artiste(String nom, String jour, String heure) {
        this.nom = nom;
        this.jour = jour;
        this.heure = heure;
    }

    public String getNom() { return nom; }
    public String getJour() { return jour; }
    public String getHeure() { return heure; }

    public void setJour(String jour) { this.jour = jour; }
    public void setHeure(String heure) { this.heure = heure; }
}