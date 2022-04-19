package com.joaquinemmanuel.petagramultra.ApiRest.MyEndPoint;

public class UsuarioResponse {
    private String id_dispositivo;

    public UsuarioResponse(String dispositivoId){
        this.id_dispositivo = dispositivoId;
    }

    public UsuarioResponse(){

    }

    public String getId_dispositivo() {
        return id_dispositivo;
    }

    public void setId_dispositivo(String id_dispositivo) {
        this.id_dispositivo = id_dispositivo;
    }
}
