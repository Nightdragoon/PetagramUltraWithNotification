package com.joaquinemmanuel.petagramultra.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.joaquinemmanuel.petagramultra.Constantes.ConstantesBaseDatos;
import com.joaquinemmanuel.petagramultra.Constantes.ConstantesUsuarios;
import com.joaquinemmanuel.petagramultra.pojo.Animal;
import com.joaquinemmanuel.petagramultra.pojo.Usuario;

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

        String queryCrearTablaUsuarios = "CREATE TABLE " + ConstantesBaseDatos.TABLE_USUARIOS + "(" +
                ConstantesBaseDatos.TABLE_USUARIOS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstantesBaseDatos.TABLE_USUARIOS_NOMBRE + " TEXT, " +
                ConstantesBaseDatos.TABLE_USUARIOS_ACCESS_TOKES  + " TEXT" + ")";

        String queryCrearTablaFavoritos ="CREATE TABLE " + ConstantesBaseDatos.TABLE_FAVORITOS + "(" +
                ConstantesBaseDatos.TABLE_FAVORITOS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstantesBaseDatos.TABLE_FAVORITOS_NOMBRE + " TEXT, " +
                ConstantesBaseDatos.TABLE_FAVORITOS_FOTO + " TEXT" + ")";

        db.execSQL(queryCrearTablaAnimales);
        db.execSQL(queryCrearTablaAnimalesLikes);
        db.execSQL(queryCrearTablaUsuarios);
        db.execSQL(queryCrearTablaFavoritos);
    }

    public ContentValues  ponerFavoritos(String nombre , String foto){
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_FAVORITOS_NOMBRE , nombre );
        contentValues.put(ConstantesBaseDatos.TABLE_FAVORITOS_FOTO , foto);
        return contentValues;
    }

    public void insertarFavoritos(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_FAVORITOS , null , contentValues);
        db.close();
    }

    public ArrayList<Animal> obtenerFavoritos (){
        String query = "SELECT * FROM " + ConstantesBaseDatos.TABLE_FAVORITOS;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query , null);
        ArrayList<Animal> favoritos = new ArrayList<>();
        while (registros.moveToNext()){
            Animal animalFavoritoActual = new Animal();
            animalFavoritoActual.setNombre(registros.getString(1));
            animalFavoritoActual.setId(Integer.toString(registros.getInt(0)));
            animalFavoritoActual.setFoto(registros.getString(2));

            favoritos.add(animalFavoritoActual);
        }

        return favoritos;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + ConstantesBaseDatos.TABLE_FAVORITOS);
        db.execSQL("DROP TABLE IF EXISTS " + ConstantesBaseDatos.TABLE_USUARIOS);
        db.execSQL("DROP TABLE IF EXISTS " + ConstantesBaseDatos.TABLE_ANIMALS);
    }

    public ArrayList<Usuario> verUsuarios(ArrayList<Usuario> usuarios){
        String query = "SELECT * FROM " + ConstantesBaseDatos.TABLE_USUARIOS;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query , null);
        while (registros.moveToNext()){
            Usuario usuarioActual = new Usuario();
            usuarioActual.setId(registros.getInt(0));
            usuarioActual.setNombre(registros.getString(1));
            usuarioActual.setAccess_token(registros.getString(2));
            usuarios.add(usuarioActual);

        }
        return usuarios;
    }

    public void iniciarUsuarios(){
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_USUARIOS_NOMBRE , ConstantesUsuarios.NOMBRE);
        contentValues.put(ConstantesBaseDatos.TABLE_USUARIOS_ACCESS_TOKES , ConstantesUsuarios.ACCESS_TOKEN);
        ponerUsuarios(contentValues);

    }
    public void ponerUsuarios (ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_USUARIOS , null , contentValues);
        db.close();

    }

    public ArrayList<Animal> obtenerTodosLosAnimales(ArrayList<Animal> animals){
        /*String query = "SELECT * FROM " + ConstantesBaseDatos.TABLE_ANIMALS;
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

        }*/
        //db.close();


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
