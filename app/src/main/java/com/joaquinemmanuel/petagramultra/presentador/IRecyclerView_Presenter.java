package com.joaquinemmanuel.petagramultra.presentador;

import com.joaquinemmanuel.petagramultra.db.DB;
import com.joaquinemmanuel.petagramultra.pojo.Animal;

import java.util.ArrayList;

public interface IRecyclerView_Presenter {

    public void insertarAnimales(DB db);

    public void inicializarDB(ArrayList<Animal> animal);
}
