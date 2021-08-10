package com.joaquinemmanuel.petagramultra;

public class Animal {
private String nombre;
private int likes ;
private int foto;

    public Animal(Animal animal) {
    }


    public boolean isTieneLike() {
        return tieneLike;
    }

    public void setTieneLike(boolean tieneLike) {
        this.tieneLike = tieneLike;
    }

    private boolean tieneLike;

public Animal (int foto , String nombre ){
    this.foto = foto;
    this.nombre = nombre;
}

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }
}
