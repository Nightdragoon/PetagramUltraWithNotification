package com.joaquinemmanuel.petagramultra.ApiRest.MyEndPoint;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface IMyEndPoint {
    @FormUrlEncoded
    @POST(ConstantesMyApi.FINAL_URL)
    Call<UsuarioResponse> guardarValor(@Field("id_dispositivo") String id_dispositivo , @Field("id_usuario_instagram") String id_usuario_instagram);
}
