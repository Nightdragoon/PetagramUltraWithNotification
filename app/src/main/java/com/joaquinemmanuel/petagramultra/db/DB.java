package com.joaquinemmanuel.petagramultra.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.drawable.Animatable2;

import androidx.annotation.Nullable;

import com.joaquinemmanuel.petagramultra.pojo.Animal;

import java.util.ArrayList;

public class DB extends SQLiteOpenHelper {

    private Context context;

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public DB(@Nullable Context context) {
        super(context, ConstantesBaseDatos.DATABASE_NAME, null, ConstantesBaseDatos.DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String queryCrearTablaAnimales = "CREATE TABLE " + ConstantesBaseDatos.TABLE_ANIMALS + "(" +
                ConstantesBaseDatos.TABLE_ANIMALS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstantesBaseDatos.TABLE_ANIMALS_NOMBRE + " TEXT, "+
                ConstantesBaseDatos.TABLE_ANIMALS_FOTO + " INTEGER" +
                ")";

        String queryCrearTablaAnimalesLikes = "CREATE TABLE " + ConstantesBaseDatos.TABLE_LIKES_ANIMAL + "(" +
                ConstantesBaseDatos.TABLE_LIKES_ANIMAL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstantesBaseDatos.TABLE_LIKES_ANIMALS_ID_Animals + " INTEGER, " +
                ConstantesBaseDatos.TABLE_LIKES_ANIMALS_ID_NUMERO_LIKES + " INTEGER, " +
                "FOREIGN KEY (" + ConstantesBaseDatos.TABLE_LIKES_ANIMALS_ID_Animals + ") " +
                "REFERENCES " + ConstantesBaseDatos.TABLE_ANIMALS + "(" + ConstantesBaseDatos.TABLE_ANIMALS_ID + ")" +
                ")";

        db.execSQL(queryCrearTablaAnimales);
        db.execSQL(queryCrearTablaAnimalesLikes);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + ConstantesBaseDatos.TABLE_ANIMALS);
        db.execSQL("DROP TABLE IF EXISTS " + ConstantesBaseDatos.TABLE_LIKES_ANIMAL);
    }

    public ArrayList<Animal> obtenerTodosLosAnimales(ArrayList<Animal> animals){
        String query = "SELECT * FROM " + ConstantesBaseDatos.TABLE_ANIMALS;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query , null);
        while (registros.moveToNext()){
            Animal animalActual = new Animal();
            animalActual.setId(registros.getInt(0));
            animalActual.setNombre(registros.getString(1));
            animalActual.setFoto(registros.getInt(2));
            animals.add(animalActual);

            String queryLikes = "SELECT COUNT(" + ConstantesBaseDatos.TABLE_LIKES_ANIMALS_ID_NUMERO_LIKES + ")as likes" +
                    " FROM " + ConstantesBaseDatos.TABLE_LIKES_ANIMAL +
                    " WHERE " + ConstantesBaseDatos.TABLE_LIKES_ANIMALS_ID_Animals + "=" + animalActual.getId();
            Cursor registrosLikes = db.rawQuery(queryLikes , null);

            if (registrosLikes.moveToNext()){
                animalActual.setLikes(registrosLikes.getInt(0));
            }else {
                animalActual.setLikes(0);
            }

        }
        db.close();


        return animals;
    }

public void insertarAnimales(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_ANIMALS , null , contentValues);
        db.close();


}
public void insertarLikesAnimal(ContentValues contentValues){

       SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_LIKES_ANIMAL , null , contentValues);
        db.close();
    }


public int obtenerLikesAnimal(Animal animal){

int likes = 0;

String query = "SELECT COUNT(" + ConstantesBaseDatos.TABLE_LIKES_ANIMALS_ID_NUMERO_LIKES + ")" +
        " FROM " + ConstantesBaseDatos.TABLE_LIKES_ANIMAL +
        " WHERE " + ConstantesBaseDatos.TABLE_LIKES_ANIMALS_ID_Animals + "=" + animal.getId();

SQLiteDatabase db = this.getWritableDatabase();
Cursor registro = db.rawQuery(query, null);
if (registro.moveToNext()){
    likes = registro.getInt(0);
}else{
    likes = 0;
}

        db.close();
        return likes;
}
}
