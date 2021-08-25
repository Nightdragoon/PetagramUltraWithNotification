package com.joaquinemmanuel.petagramultra.Adaptador;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;
import com.joaquinemmanuel.petagramultra.R;
import com.joaquinemmanuel.petagramultra.pojo.Animal;

import java.util.ArrayList;

public class FotoSubidaAdaptador extends RecyclerView.Adapter<FotoSubidaAdaptador.FotoSubidaViewHolder> {
    Activity activity;

    ArrayList<Animal> FotoSubida;

    public FotoSubidaAdaptador(Activity activity , ArrayList<Animal> FotoSubida){
        this.activity = activity;
        this.FotoSubida = FotoSubida;
    }
    @NonNull
    @Override
    public FotoSubidaAdaptador.FotoSubidaViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_fotos_subidas , parent , false);
        return new FotoSubidaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull  FotoSubidaAdaptador.FotoSubidaViewHolder fotoSubidaViewHolder, int position) {
        Animal fotosubida = FotoSubida.get(position);
        fotoSubidaViewHolder.AnimalFoto.setImageResource(fotosubida.getFoto());
        fotoSubidaViewHolder.NombreAnimal.setText(fotosubida.getNombre());
        fotoSubidaViewHolder.noLikes.setText(Integer.toString(fotosubida.getLikes()));
        fotoSubidaViewHolder.Like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(activity , v , "disle like a;" + fotosubida.getNombre() , Snackbar.LENGTH_SHORT).show();
                int numeroslikes = fotosubida.getLikes();

                fotosubida.setLikes(++numeroslikes);

                fotoSubidaViewHolder.noLikes.setText(Integer.toString(fotosubida.getLikes()));

            }
        });

    }

    @Override
    public int getItemCount() {
        return FotoSubida.size();
    }

    public class FotoSubidaViewHolder extends RecyclerView.ViewHolder {


        private ImageView AnimalFoto;
        private TextView NombreAnimal;
        private ImageButton Like;
        private TextView noLikes;




        public FotoSubidaViewHolder( View itemView) {
            super(itemView);

            AnimalFoto = itemView.findViewById(R.id.imgAnimal3);
            NombreAnimal = itemView.findViewById(R.id.cvPerroNombre3);
            Like = itemView.findViewById(R.id.btnLikeButton3);
            noLikes = itemView.findViewById(R.id.tvNoLikes3);
        }
    }
}
