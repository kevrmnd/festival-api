package com.ada.festival.model;

public class ArtisteDetail {
    private final Artiste artiste;
    private final Genre genre;
    private final Scene scene;

    public ArtisteDetail(Artiste artiste, Genre genre, Scene scene) {
        this.artiste = artiste;
        this.genre = genre;
        this.scene = scene;
    }

    public Artiste getArtiste() { return artiste; }
    public Genre getGenre() { return genre; }
    public Scene getScene() { return scene; }
}
