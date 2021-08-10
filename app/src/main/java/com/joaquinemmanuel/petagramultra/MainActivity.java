package com.joaquinemmanuel.petagramultra;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.widget.Toolbar;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView listaAnimales;
    private ArrayList<Animal> animal;


    private ImageButton imgButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar miActionBar = findViewById(R.id.tbToolbar);
        setSupportActionBar(miActionBar);

        imgButton = findViewById(R.id.imgButton);





        animal = new ArrayList<Animal>();
        listaAnimales = findViewById(R.id.rvMascota);
        LinearLayoutManager glm = new LinearLayoutManager(this);
        glm.setOrientation(RecyclerView.VERTICAL);


        listaAnimales.setLayoutManager(glm);

        inicializarAnimales();
        inicializarListaAnimales();





    }

    public void inicializarAnimales(){
        animal.add(new Animal(R.drawable.chimuelo , getResources().getString(R.string.Chimuelo)));
        animal.add(new Animal(R.drawable.spyro , getResources().getString(R.string.Spyro)));
        animal.add(new Animal(R.drawable.kali , getResources().getString(R.string.Spyro)));

    }
    public void inicializarListaAnimales(){
        AnimalAdaptador adaptador = new AnimalAdaptador(MainActivity.this , animal , imgButton);
        listaAnimales.setAdapter(adaptador);



    }



    }





