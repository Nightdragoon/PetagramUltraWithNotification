package com.joaquinemmanuel.petagramultra.ApiRest.Adapter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import com.joaquinemmanuel.petagramultra.ApiRest.IEndPointApi;
import com.joaquinemmanuel.petagramultra.ApiRest.deserealizador.AnimalDeserealizador;
import com.joaquinemmanuel.petagramultra.Constantes.ConstanteRestApi;
import com.joaquinemmanuel.petagramultra.Modelo.AnimalResponse;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestApiAdapter {
    public IEndPointApi establecerConexion(Gson gson) throws IllegalArgumentException{
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ConstanteRestApi.ROOTURL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        return retrofit.create(IEndPointApi.class);
    }

    public Gson ConstruyeGsonDeserealizadorMediaRecent(){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(AnimalResponse.class , new AnimalDeserealizador());
        return gsonBuilder.create();

    }

}
