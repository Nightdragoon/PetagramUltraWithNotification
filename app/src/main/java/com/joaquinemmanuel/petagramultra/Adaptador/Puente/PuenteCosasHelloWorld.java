package com.joaquinemmanuel.petagramultra.Adaptador.Puente;

import android.content.ContentValues;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.joaquinemmanuel.petagramultra.ApiRest.Adapter.RestApiAdapter;
import com.joaquinemmanuel.petagramultra.ApiRest.IEndPointApi;
import com.joaquinemmanuel.petagramultra.Modelo.AnimalResponse;
import com.joaquinemmanuel.petagramultra.fragments.Recyclerview_Fragment;
import com.joaquinemmanuel.petagramultra.fragments.miMascota_Fragment;
import com.joaquinemmanuel.petagramultra.pojo.Animal;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PuenteCosasHelloWorld {
    ArrayList<Animal> animals;
    Context context;
    String access_token;
    Recyclerview_Fragment recyclerview_fragment;
    miMascota_Fragment miMascota_fragment;

    public PuenteCosasHelloWorld(Context context , String access_token , ArrayList<Animal>animals , Recyclerview_Fragment recyclerview_fragment){
        this.recyclerview_fragment = recyclerview_fragment;
        this.animals = animals;
        this.context = context;
        this.access_token = access_token;
        crearLLamada();
    }

    public PuenteCosasHelloWorld(Context context , ArrayList<Animal> animals , miMascota_Fragment miMascota_fragment){
        this.animals = animals;
        this.context = context;
        this.miMascota_fragment = miMascota_fragment;

    }
    public void crearLLamada(){
        RestApiAdapter restApiAdapter = new RestApiAdapter();
        Gson gson  = restApiAdapter.ConstruyeGsonDeserealizadorMediaRecent();
        IEndPointApi iEndPointApi = restApiAdapter.establecerConexion(gson);
        Call<AnimalResponse> animalResponseCall = iEndPointApi.getRecentMedia();
        animalResponseCall.enqueue(new Callback<AnimalResponse>() {
            @Override
            public void onResponse(Call<AnimalResponse> call, Response<AnimalResponse> response) {
                AnimalResponse animalResponse = response.body();
                animals = animalResponse.getAnimals();
                recyclerview_fragment.inicializarAdaptador(animals);
                recyclerview_fragment.generarLinearLayout();
            }

            @Override
            public void onFailure(Call<AnimalResponse> call, Throwable t) {
                Toast.makeText(context, "Algo salio mal", Toast.LENGTH_SHORT).show();
                Log.e("ERROR_LLAMADA" , String.valueOf(t));

            }
        });

    }

    public void crearLlamadaFotoSubida(){
        RestApiAdapter restApiAdapter = new RestApiAdapter();
        Gson gson = restApiAdapter.ConstruyeGsonDeserealizadorMediaRecent();
        IEndPointApi iEndPointApi = restApiAdapter.establecerConexion(gson);
        Call<AnimalResponse> animalResponseCall = iEndPointApi.getRecentMedia();
        animalResponseCall.enqueue(new Callback<AnimalResponse>() {
            @Override
            public void onResponse(Call<AnimalResponse> call, Response<AnimalResponse> response) {
                AnimalResponse animalResponse = response.body();
                animals = animalResponse.getAnimals();
                miMascota_fragment.inicializarRC(animals);
                miMascota_fragment.generarGridLayout();
            }

            @Override
            public void onFailure(Call<AnimalResponse> call, Throwable t) {
                Toast.makeText(context, "Error en conexion", Toast.LENGTH_SHORT).show();
                Log.e("ERROR_CONEXION" , String.valueOf(t));
            }
        });

    }
}
