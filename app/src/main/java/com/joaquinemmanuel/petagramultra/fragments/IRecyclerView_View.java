package com.joaquinemmanuel.petagramultra.fragments;

import android.content.Context;

import com.joaquinemmanuel.petagramultra.pojo.Animal;

import java.util.ArrayList;

public interface IRecyclerView_View {
    public void generarLinearLayout();
    public void inicializarAdaptador(ArrayList<Animal> animal);


}
