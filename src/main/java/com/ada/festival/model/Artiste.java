package com.ada.festival.model;

public class Artiste {
    private final String name;
    private final String jour;
    private final String heure;

    public Artiste(String name, String jour, String heure) {
        this.name = name;
        this.jour = jour;
        this.heure = heure;
    }

    public String getName() { return name; }
    public String getJour() { return jour; }
    public String getHeure() { return heure; }
}