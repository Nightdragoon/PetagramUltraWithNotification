package com.joaquinemmanuel.petagramultra.Adaptador;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;
import com.joaquinemmanuel.petagramultra.db.DB;
import com.joaquinemmanuel.petagramultra.fragments.Recyclerview_Fragment;
import com.joaquinemmanuel.petagramultra.likes;
import com.joaquinemmanuel.petagramultra.pojo.Animal;
import com.joaquinemmanuel.petagramultra.MainActivity2;
import com.joaquinemmanuel.petagramultra.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import static android.widget.Toast.makeText;

public class AnimalAdaptador extends RecyclerView.Adapter<AnimalAdaptador.AnimalViewHolder> {

    ArrayList<Animal> animal;
    FragmentActivity activity;
    Context context;
    private String PerroNombre;
    ArrayList<Animal> fAnimal = new ArrayList<Animal>();


    private int PerraFoto;
    private int PerrosLike;




    public AnimalAdaptador (FragmentActivity activity , ArrayList<Animal> animal  , Context context){
        this.context = context;
        this.activity = activity;
        this.animal = animal;
    }

    public String getPerroNombre() {
        return PerroNombre;
    }

    public void setPerroNombre(String perroNombre) {
        PerroNombre = perroNombre;
    }

    public int getPerraFoto() {
        return PerraFoto;
    }

    public void setPerraFoto(int perraFoto) {
        PerraFoto = perraFoto;
    }

    public int getPerrosLike() {
        return PerrosLike;
    }

    public void setPerrosLike(int perrosLike) {
        PerrosLike = perrosLike;
    }

    @NonNull

    @Override
    public AnimalViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota , parent , false);
        return new AnimalViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull  AnimalAdaptador.AnimalViewHolder animalViewHolder, int position) {
        Animal animals = animal.get(position);
        animalViewHolder.nombreAnimal.setText(animals.getNombre());
        Picasso.get().load(animals.getFoto()).into(animalViewHolder.fotoAnimal);
        animalViewHolder.likeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DB db = new DB(context);
                ContentValues contentValues;
                contentValues = db.ponerFavoritos(animals.getNombre() , animals.getFoto());
                db.insertarFavoritos(contentValues);
                makeText(activity, "Animal inserstado en favoritos", Toast.LENGTH_SHORT).show();
                db.close();
                
            }
        });
        















    }

    @Override
    public int getItemCount() {
        return animal.size();
    }

    public static class AnimalViewHolder extends RecyclerView.ViewHolder {

        private ImageView fotoAnimal;
        private TextView nombreAnimal;
        private ImageButton likeButton;

        public AnimalViewHolder(View itemView) {
            super(itemView);
            fotoAnimal = itemView.findViewById(R.id.imgAnimal);
            nombreAnimal = itemView.findViewById(R.id.cvPerroNombre);
            likeButton = itemView.findViewById(R.id.btnLikeButton);
        }
    }
}
