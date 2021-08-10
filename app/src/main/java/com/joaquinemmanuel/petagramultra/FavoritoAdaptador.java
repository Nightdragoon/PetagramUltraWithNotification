package com.joaquinemmanuel.petagramultra;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FavoritoAdaptador extends RecyclerView.Adapter<FavoritoAdaptador.FavoritoViewHolder> {

    ArrayList<Animal> favorito;
    Activity activity;

    public FavoritoAdaptador(Activity activity, ArrayList<Animal> favorito) {
        this.activity = activity;
        this.favorito = favorito;
    }


    @Override
    public FavoritoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_favorito , parent , false);
        return new FavoritoViewHolder(v);
    }

    @Override
    public void onBindViewHolder( FavoritoAdaptador.FavoritoViewHolder favoritoViewHolderholder, int position) {


        Animal favoritos = favorito.get(position);
        favoritoViewHolderholder.noLikes2.setText(Integer.toString(favoritos.getLikes()));
        favoritoViewHolderholder.PerroNombre2.setText(favoritos.getNombre());
        favoritoViewHolderholder.imgAnimal2.setImageResource(favoritos.getFoto());


    }

    @Override
    public int getItemCount() {
        return favorito.size();
    }

    public class FavoritoViewHolder extends  RecyclerView.ViewHolder{

        private ImageView imgAnimal2;
        private TextView PerroNombre2;
        private TextView noLikes2;





        public FavoritoViewHolder( View itemView) {
            super(itemView);

            imgAnimal2 = itemView.findViewById(R.id.imgAnimal2);
            PerroNombre2 = itemView.findViewById(R.id.cvPerroNombre2);
            noLikes2 = itemView.findViewById(R.id.tvNoLikes2);
        }
    }
}
