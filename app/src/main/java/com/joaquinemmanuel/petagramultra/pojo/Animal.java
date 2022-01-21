package com.joaquinemmanuel.petagramultra.pojo;

import android.os.Parcel;
import android.os.Parcelable;

public class Animal implements Parcelable  {
private String nombre;
private String foto;
private String id;

public Animal(){
    this.nombre = nombre;
    this.foto = foto;
    this.id = id;
}


    public Animal(Parcel in) {
        nombre = in.readString();
        foto = in.readString();
        id = in.readString();
    }


    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nombre);
        dest.writeString(foto);
        dest.writeString(id);
    }

    @Override
    public int describeContents() {
        return 0;
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
