package com.joaquinemmanuel.petagramultra.Adaptador;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;
import com.joaquinemmanuel.petagramultra.db.DB;
import com.joaquinemmanuel.petagramultra.fragments.Recyclerview_Fragment;
import com.joaquinemmanuel.petagramultra.likes;
import com.joaquinemmanuel.petagramultra.pojo.Animal;
import com.joaquinemmanuel.petagramultra.MainActivity2;
import com.joaquinemmanuel.petagramultra.R;

import java.util.ArrayList;

import static android.widget.Toast.makeText;

public class AnimalAdaptador extends RecyclerView.Adapter<AnimalAdaptador.AnimalViewHolder> {

    ArrayList<Animal> animal;
    Activity activity;
    ImageButton imgButton;
    private String PerroNombre;
    ArrayList<Animal> fAnimal = new ArrayList<Animal>();


    private int PerraFoto;
    private int PerrosLike;




    public AnimalAdaptador (Activity activity , ArrayList<Animal> animal , ImageButton imgButton){
        this.activity = activity;
        this.animal = animal;
        this.imgButton = imgButton;
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
        animalViewHolder.noLikes.setText(Integer.toString(animals.getLikes()));
        animalViewHolder.fotoAnimal.setImageResource(animals.getFoto());
        animalViewHolder.likeButton.setOnClickListener(v -> {
            Snackbar.make(activity , v ,"diste like a " + animals.getNombre() ,  Snackbar.LENGTH_LONG).show();

            int numerosLikes = animals.getLikes();

            likes laiks = new likes(activity);


            laiks.insertarLikesAnimal(animals);

            animalViewHolder.noLikes.setText(Integer.toString(laiks.obtenerLikes(animals)));

            animals.setTieneLike(true);
            Intent intent = new Intent(activity , MainActivity2.class);




            imgButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    intent.putParcelableArrayListExtra("PerraLista", fAnimal);



                    activity.startActivity(intent);
                }
            });

            if(animal.get(position).isTieneLike() == true){
                fAnimal.add(new Animal(animals.getFoto() , animals.getNombre()));

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
        private TextView noLikes;

        public AnimalViewHolder(View itemView) {
            super(itemView);

            fotoAnimal = itemView.findViewById(R.id.imgAnimal);
            nombreAnimal = itemView.findViewById(R.id.cvPerroNombre);
            likeButton = itemView.findViewById(R.id.btnLikeButton);
            noLikes = itemView.findViewById(R.id.tvNoLikes);

        }
    }
}
