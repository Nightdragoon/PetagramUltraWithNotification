package com.joaquinemmanuel.petagramultra.ApiRest;

import com.joaquinemmanuel.petagramultra.Constantes.ConstanteRestApi;
import com.joaquinemmanuel.petagramultra.Modelo.AnimalResponse;
import com.joaquinemmanuel.petagramultra.Modelo.LikeResponse;
import com.joaquinemmanuel.petagramultra.Modelo.TokenResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface IEndPointApi {
    @GET(ConstanteRestApi.KEY_GET_ULTRA)
    Call<AnimalResponse> getRecentMedia( @Query("access_token") String token);


    @FormUrlEncoded()
    @POST(ConstanteRestApi.TOKEN_URL + ConstanteRestApi.IMPORTANT)
    Call<TokenResponse> getToken(@Field("client_id") String client_id , @Field("client_secret") String client_secret ,
                                 @Field("grant_type") String grant_type , @Field("redirect_uri") String redirect_uri,
                                 @Field("code") String code);

    @FormUrlEncoded()
    @POST(ConstanteRestApi.LIKE_SCOPES)
    Call<LikeResponse> setLikes(@Field("id_foto_instagram") String id_foto_instagram ,
                                @Field("id_usuario_instagram") String id_usuario_instagram ,
                                @Field("id_dispositivo") String id_dispostivo);
}
