package com.joaquinemmanuel.petagramultra.Modelo;

import com.joaquinemmanuel.petagramultra.pojo.Animal;

import java.util.ArrayList;

public class AnimalResponse {
    ArrayList<Animal> animals;

    public ArrayList<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(ArrayList<Animal> animals) {
        this.animals = animals;
    }
}
