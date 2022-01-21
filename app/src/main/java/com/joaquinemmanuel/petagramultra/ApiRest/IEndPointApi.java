package com.joaquinemmanuel.petagramultra.ApiRest;

import com.joaquinemmanuel.petagramultra.Constantes.ConstanteRestApi;
import com.joaquinemmanuel.petagramultra.Modelo.AnimalResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface IEndPointApi {
    @GET(ConstanteRestApi.KEY_GET_ULTRA)
    Call<AnimalResponse> getRecentMedia();
}
