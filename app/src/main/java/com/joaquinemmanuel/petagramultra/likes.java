package com.joaquinemmanuel.petagramultra;

import android.content.ContentValues;
import android.content.Context;

import com.joaquinemmanuel.petagramultra.db.ConstantesBaseDatos;
import com.joaquinemmanuel.petagramultra.db.DB;
import com.joaquinemmanuel.petagramultra.pojo.Animal;

public class likes {

    private static final int LIKE = 1;
    Context context;

    public likes(Context context){
        this.context = context;
    }

    public void insertarLikesAnimal(Animal animal){
        DB db = new DB(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_ANIMALS_ID_Animals , animal.getId());
        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_ANIMALS_ID_NUMERO_LIKES,LIKE);
        db.insertarLikesAnimal(contentValues);
    }

    public int obtenerLikes(Animal animal){
        DB db = new DB(context);
        db.obtenerLikesAnimal(animal);

        return db.obtenerLikesAnimal(animal);
    }


}
