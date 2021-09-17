package com.joaquinemmanuel.petagramultra.pojo;

import android.os.Parcel;
import android.os.Parcelable;

public class Animal implements Parcelable {
private String nombre;
private int likes ;
private int foto;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int id;

    public Animal(Animal animal) {
        this.nombre = nombre;
        this.foto = foto;
        this.likes = likes;
    }


    protected Animal(Parcel in) {
        nombre = in.readString();
        likes = in.readInt();
        foto = in.readInt();
        tieneLike = in.readByte() != 0;
    }

    public static final Creator<Animal> CREATOR = new Creator<Animal>() {
        @Override
        public Animal createFromParcel(Parcel in) {
            return new Animal(in);
        }

        @Override
        public Animal[] newArray(int size) {
            return new Animal[size];
        }
    };

    public Animal() {

    }

    public boolean isTieneLike() {
        return tieneLike;
    }

    public void setTieneLike(boolean tieneLike) {
        this.tieneLike = tieneLike;
    }

    private boolean tieneLike = false;

public Animal (int foto , String nombre , int likes ){
    this.foto = foto;
    this.nombre = nombre;
    this.likes = likes;

}
    public Animal (int foto , String nombre){
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nombre);
        dest.writeInt(likes);
        dest.writeInt(foto);
        dest.writeByte((byte) (tieneLike ? 1 : 0));
    }
}
