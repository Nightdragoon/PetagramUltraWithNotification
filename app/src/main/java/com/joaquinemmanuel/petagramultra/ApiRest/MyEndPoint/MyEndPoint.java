package com.joaquinemmanuel.petagramultra.ApiRest.MyEndPoint;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MyEndPoint{
    public IMyEndPoint guardarValor() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ConstantesMyApi.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(IMyEndPoint.class);
    }
}
