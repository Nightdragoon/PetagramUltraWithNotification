package com.joaquinemmanuel.petagramultra.fragments;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.joaquinemmanuel.petagramultra.Adaptador.AnimalAdaptador;
import com.joaquinemmanuel.petagramultra.Adaptador.Puente.PuenteCosasHelloWorld;
import com.joaquinemmanuel.petagramultra.Adaptador.Puente.PuenteCosasHelloWorld;
import com.joaquinemmanuel.petagramultra.Constantes.ConstantesUsuarios;
import com.joaquinemmanuel.petagramultra.MainActivity;
import com.joaquinemmanuel.petagramultra.R;
import com.joaquinemmanuel.petagramultra.db.DB;
import com.joaquinemmanuel.petagramultra.pojo.Animal;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Recyclerview_Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Recyclerview_Fragment extends Fragment implements IRecyclerView_View {

    private static final int LIKE = 1;
    private RecyclerView listaAnimales;
    private ArrayList<Animal> animal;
    String user;
    String token;
    String user_id;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Recyclerview_Fragment(String user , String token ,String user_id) {
        this.user = user;
        this.token = token;
        this.user_id = user_id;
        // Required empty public constructor
    }

    public Recyclerview_Fragment(){

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

        animal = new ArrayList<Animal>();
        listaAnimales = v.findViewById(R.id.rvMascota);

        PuenteCosasHelloWorld puenteCosas = new PuenteCosasHelloWorld(getContext() , user , animal , this , token);
        Log.e("Cosas" , String.valueOf(animal));
        inicializarAdaptador(animal);
        generarLinearLayout();


        //inicializarDB();



        // Inflate the layout for this fragment
        return v;
    }
    /*public void inicializarAnimales(){
        animal.add(new Animal(R.drawable.chimuelo , getResources().getString(R.string.Chimuelo)));
        animal.add(new Animal(R.drawable.spyro , getResources().getString(R.string.Spyro)));
        animal.add(new Animal(R.drawable.cynder_p , getResources().getString(R.string.Cynder)));
        animal.add(new Animal(R.drawable.dragoncito , getResources().getString(R.string.Dragoncito)));
        animal.add(new Animal(R.drawable.kali , getResources().getString(R.string.Kali)));*/





    /*public void inicializarDB(){
        DB db = new DB(getContext());
       animal = db.obtenerTodosLosAnimales(animal);
        insertarAnimales(db);


    }

    public void insertarAnimales(DB db){
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_ANIMALS_NOMBRE ,getResources().getString(R.string.Chimuelo));
        contentValues.put(ConstantesBaseDatos.TABLE_ANIMALS_FOTO ,R.drawable.chimuelo);
        db.insertarAnimales(contentValues);
        contentValues.put(ConstantesBaseDatos.TABLE_ANIMALS_NOMBRE ,getResources().getString(R.string.Spyro));
        contentValues.put(ConstantesBaseDatos.TABLE_ANIMALS_FOTO ,R.drawable.spyro);
        db.insertarAnimales(contentValues);
        contentValues.put(ConstantesBaseDatos.TABLE_ANIMALS_NOMBRE ,getResources().getString(R.string.Cynder));
        contentValues.put(ConstantesBaseDatos.TABLE_ANIMALS_FOTO ,R.drawable.cynder_p);
        db.insertarAnimales(contentValues);
        contentValues.put(ConstantesBaseDatos.TABLE_ANIMALS_NOMBRE ,getResources().getString(R.string.Dragoncito));
        contentValues.put(ConstantesBaseDatos.TABLE_ANIMALS_FOTO ,R.drawable.dragoncito);
        db.insertarAnimales(contentValues);
        contentValues.put(ConstantesBaseDatos.TABLE_ANIMALS_NOMBRE ,getResources().getString(R.string.Kali));
        contentValues.put(ConstantesBaseDatos.TABLE_ANIMALS_FOTO ,R.drawable.kali);
        db.insertarAnimales(contentValues);
    }*/


    @Override
    public void generarLinearLayout() {
        LinearLayoutManager glm = new LinearLayoutManager(this.getContext());
        glm.setOrientation(RecyclerView.VERTICAL);
        listaAnimales.setLayoutManager(glm);

    }

    @Override
    public void inicializarAdaptador(ArrayList<Animal> animal) {
        AnimalAdaptador adaptador = new AnimalAdaptador(getActivity(), animal , getContext() , user_id);
        listaAnimales.setAdapter(adaptador);

    }
}