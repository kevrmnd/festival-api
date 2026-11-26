package com.ada.festival.model;

public class Scene {
    private final String name;
    private final int capacite;
    private final String description;

    public Scene(String name, int capacite, String description) {
        this.name = name;
        this.capacite = capacite;
        this.description = description;
    }

    public String getName() { return name; }
    public int getCapacite() { return capacite; }
    public String getDescription() { return description; }
}
