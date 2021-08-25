package com.joaquinemmanuel.petagramultra;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;

import com.joaquinemmanuel.petagramultra.Adaptador.FavoritoAdaptador;
import com.joaquinemmanuel.petagramultra.pojo.Animal;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {
    private ArrayList<Animal> favorito;
    private ArrayList<Animal> prelist;
    private RecyclerView listafavorito;
    private ImageView PerraFoto;
    private TextView PerroNombre;
    private TextView PerrosLikes;
    Activity activity;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar miActionBar2 = findViewById(R.id.tbToolbar2);
        setSupportActionBar(miActionBar2);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        favorito = new ArrayList<Animal>();



        Bundle parametros = getIntent().getExtras();
        String perroNombre = parametros.getString("PerroNombre");
        int perraFoto = parametros.getInt("PerraFoto");
        int perrosLikes = parametros.getInt("PerrosLikes");
        prelist = parametros.getParcelableArrayList("PerraLista");

        listafavorito = findViewById(R.id.rcFavoritos);
        LinearLayoutManager glm = new LinearLayoutManager(this);
        glm.setOrientation(RecyclerView.VERTICAL);
        listafavorito.setLayoutManager(glm);




        for (Animal animal : prelist) {
            favorito.add(animal);
        }



        inicializarListaAnimales();


    }
    public void inicializarListaAnimales(){
        FavoritoAdaptador adaptador = new FavoritoAdaptador(MainActivity2.this , favorito);
        listafavorito.setAdapter(adaptador);

}


}