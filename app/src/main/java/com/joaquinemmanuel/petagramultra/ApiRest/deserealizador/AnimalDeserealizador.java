package com.joaquinemmanuel.petagramultra.ApiRest.deserealizador;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.joaquinemmanuel.petagramultra.ApiRest.JsonKeys;
import com.joaquinemmanuel.petagramultra.Modelo.AnimalResponse;
import com.joaquinemmanuel.petagramultra.pojo.Animal;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class AnimalDeserealizador implements JsonDeserializer<AnimalResponse> {

    @Override
    public AnimalResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Gson gson = new Gson();
        AnimalResponse animalResponse = gson.fromJson(json , AnimalResponse.class);
        JsonArray contactoResponseData = json.getAsJsonObject().getAsJsonArray(JsonKeys.MEDIA_RESPONSE_ARRAY);
        animalResponse.setAnimals(deserealizarContactosDeJson(contactoResponseData));
        return animalResponse;
    }
    public ArrayList<Animal> deserealizarContactosDeJson(JsonArray contactoResponseData){
        ArrayList<Animal> animals = new ArrayList<>();
        for (int i = 0; i < contactoResponseData.size() ; i++){
            JsonObject contactoResponseDataObject = contactoResponseData.get(i).getAsJsonObject();
            String id = contactoResponseDataObject.get(JsonKeys.USER_ID).getAsString();
            String nombre = contactoResponseDataObject.get(JsonKeys.FULL_NAME).getAsString();
            String urlFoto = contactoResponseDataObject.get(JsonKeys.MEDIA_URL).getAsString();

            Animal animalActual = new Animal();

            animalActual.setId(id);
            animalActual.setNombre(nombre);
            animalActual.setFoto(urlFoto);

            animals.add(animalActual);

        }

        return animals;


    }
}
