package com.joaquinemmanuel.petagramultra.Adaptador;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;
import com.joaquinemmanuel.petagramultra.R;
import com.joaquinemmanuel.petagramultra.db.DB;
import com.joaquinemmanuel.petagramultra.pojo.Animal;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import static android.widget.Toast.makeText;

public class FotoSubidaAdaptador extends RecyclerView.Adapter<FotoSubidaAdaptador.FotoSubidaViewHolder> {
    Context context;

    ArrayList<Animal> FotoSubida;

    public FotoSubidaAdaptador(Context context , ArrayList<Animal> FotoSubida){
        this.context = context;
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
        Picasso.get().load(fotosubida.getFoto()).into(fotoSubidaViewHolder.AnimalFoto);
        fotoSubidaViewHolder.NombreAnimal.setText(fotosubida.getNombre());
        fotoSubidaViewHolder.like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DB db = new DB(context);
                ContentValues contentValues;
                contentValues = db.ponerFavoritos(fotosubida.getNombre() , fotosubida.getFoto());
                db.insertarFavoritos(contentValues);
                makeText(context, "Animal inserstado en favoritos", Toast.LENGTH_SHORT).show();
                db.close();
            }
        });

    }

    @Override
    public int getItemCount() {
        return FotoSubida.size();
    }

    public class FotoSubidaViewHolder extends RecyclerView.ViewHolder {


        public ImageView AnimalFoto;
         public TextView NombreAnimal;
         public ImageButton like;




        public FotoSubidaViewHolder( View itemView) {
            super(itemView);

            AnimalFoto = itemView.findViewById(R.id.imgAnimal3);
            NombreAnimal = itemView.findViewById(R.id.cvPerroNombre3);
            like = itemView.findViewById(R.id.btnLikeButton3);

        }
    }
}
