package com.joaquinemmanuel.petagramultra.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.StrictMode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.joaquinemmanuel.petagramultra.Adaptador.FotoSubidaAdaptador;
import com.joaquinemmanuel.petagramultra.R;
import com.joaquinemmanuel.petagramultra.pojo.Animal;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link miMascota_Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class miMascota_Fragment extends Fragment implements IRecyclerView_View{

    private RecyclerView fotos;
    private ArrayList<Animal> fotosSubidas;
    private String Nombre ;
    private ImageView perra;
    private TextView Nombresito;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public miMascota_Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment miMascota_Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static miMascota_Fragment newInstance(String param1, String param2) {
        miMascota_Fragment fragment = new miMascota_Fragment();
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
        View v = inflater.inflate(R.layout.fragment_mi_mascota_, container, false);

        Nombre = "Cynder";
        perra = v.findViewById(R.id.imgAnimal4);
        perra.setImageResource(R.drawable.cynder_p);

        Nombresito = v.findViewById(R.id.cvPerroNombre4);
        Nombresito.setText("Cynder");

        fotos = v.findViewById(R.id.tcMiFoto);
        fotosSubidas = new ArrayList<Animal>();
        GridLayoutManager glm = new GridLayoutManager(getActivity() , 2);
        fotos.setLayoutManager(glm);

        inicializarDatos();

        inicializarRC();


        // Inflate the layout for this fragment
        return v;
    }

    private void inicializarDatos() {
        fotosSubidas.add(new Animal(R.drawable.cynder_p , "Cynder"));
        fotosSubidas.add(new Animal(R.drawable.cynder_p2 , "Cynder"));
        fotosSubidas.add(new Animal(R.drawable.cynder_p3 , "Cynder"));
        fotosSubidas.add(new Animal(R.drawable.cynder_p4 , "Cynder"));
        fotosSubidas.add(new Animal(R.drawable.cynder_p5 , "Cynder"));





    }

    private void inicializarRC() {
        FotoSubidaAdaptador adaptador = new FotoSubidaAdaptador(getActivity() , fotosSubidas);
        fotos.setAdapter(adaptador);
    }
    public void generarLinearLayout() {

    }

    @Override
    public void inicializarAdaptador() {

    }
}