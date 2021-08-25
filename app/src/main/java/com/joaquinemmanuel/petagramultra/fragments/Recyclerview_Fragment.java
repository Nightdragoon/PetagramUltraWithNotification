package com.joaquinemmanuel.petagramultra.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.joaquinemmanuel.petagramultra.Adaptador.AnimalAdaptador;
import com.joaquinemmanuel.petagramultra.MainActivity;
import com.joaquinemmanuel.petagramultra.R;
import com.joaquinemmanuel.petagramultra.pojo.Animal;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Recyclerview_Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Recyclerview_Fragment extends Fragment {

    private RecyclerView listaAnimales;
    private ArrayList<Animal> animal;
    private ImageButton imgButton;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Recyclerview_Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Recyclerview_Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Recyclerview_Fragment newInstance(String param1, String param2) {
        Recyclerview_Fragment fragment = new Recyclerview_Fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_recyclerview_, container, false);

        imgButton = v.findViewById(R.id.imgButton);
        animal = new ArrayList<Animal>();
        listaAnimales = v.findViewById(R.id.rvMascota);
        LinearLayoutManager glm = new LinearLayoutManager(getActivity());
        glm.setOrientation(RecyclerView.VERTICAL);


        listaAnimales.setLayoutManager(glm);

        inicializarAnimales();
        inicializarListaAnimales();

        // Inflate the layout for this fragment
        return v;
    }
    public void inicializarAnimales(){
        animal.add(new Animal(R.drawable.chimuelo , getResources().getString(R.string.Chimuelo)));
        animal.add(new Animal(R.drawable.spyro , getResources().getString(R.string.Spyro)));
        animal.add(new Animal(R.drawable.cynder_p , getResources().getString(R.string.Cynder)));
        animal.add(new Animal(R.drawable.dragoncito , getResources().getString(R.string.Dragoncito)));
        animal.add(new Animal(R.drawable.kali , getResources().getString(R.string.Kali)));



    }
    public void inicializarListaAnimales(){
        AnimalAdaptador adaptador = new AnimalAdaptador(getActivity() , animal ,imgButton);
        listaAnimales.setAdapter(adaptador);



    }
}