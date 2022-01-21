package com.joaquinemmanuel.petagramultra;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;

import com.joaquinemmanuel.petagramultra.Adaptador.FavoritoAdaptador;
import com.joaquinemmanuel.petagramultra.db.DB;
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
        listafavorito = findViewById(R.id.rcFavoritos);
        setSupportActionBar(miActionBar2);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        getFav();
        inicializarListaAnimales();
        linerLayoutManager();


    }
    public void inicializarListaAnimales() {
        FavoritoAdaptador adaptador = new FavoritoAdaptador(MainActivity2.this, favorito);
        listafavorito.setAdapter(adaptador);
    }

    public void getFav(){
        DB db = new DB(MainActivity2.this);
        favorito = db.obtenerFavoritos();

    }

    public void linerLayoutManager(){
        LinearLayoutManager glm = new LinearLayoutManager(MainActivity2.this);
        glm.setOrientation(RecyclerView.VERTICAL);
        listafavorito.setLayoutManager(glm);

    }


}


