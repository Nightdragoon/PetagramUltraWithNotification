package com.joaquinemmanuel.petagramultra;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.joaquinemmanuel.petagramultra.Adaptador.AnimalAdaptador;
import com.joaquinemmanuel.petagramultra.Adaptador.pageAdapter;
import com.joaquinemmanuel.petagramultra.ApiRest.Adapter.RestApiAdapter;
import com.joaquinemmanuel.petagramultra.ApiRest.IEndPointApi;
import com.joaquinemmanuel.petagramultra.ApiRest.MyEndPoint.IMyEndPoint;
import com.joaquinemmanuel.petagramultra.ApiRest.MyEndPoint.MyEndPoint;
import com.joaquinemmanuel.petagramultra.ApiRest.MyEndPoint.UsuarioResponse;
import com.joaquinemmanuel.petagramultra.Constantes.ConstantesObtenerToken;
import com.joaquinemmanuel.petagramultra.Constantes.ConstantesUsuarios;
import com.joaquinemmanuel.petagramultra.Modelo.TokenResponse;
import com.joaquinemmanuel.petagramultra.fragments.Recyclerview_Fragment;
import com.joaquinemmanuel.petagramultra.fragments.miMascota_Fragment;
import com.joaquinemmanuel.petagramultra.menu.menu_acercade;
import com.joaquinemmanuel.petagramultra.menu.menu_contactos;
import com.joaquinemmanuel.petagramultra.pojo.Animal;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ImageButton imgButton;

    private Toolbar toolbar;
    String user;
    Activity activity;
    String autCode;
    String token;
    String user_id;






    private TabLayout tabLayout;

    private ViewPager viewPager;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Bundle parametros = getIntent().getExtras();
        user = parametros.getString("A");
        autCode = parametros.getString("B");

        Toolbar miActionBar = findViewById(R.id.tbToolbar);
        setSupportActionBar(miActionBar);
        Log.d("AUTH_CODE" , autCode);
        RestApiAdapter restApiAdapter = new RestApiAdapter();
        IEndPointApi iEndPointApi = restApiAdapter.obtenerToken();
        Call<TokenResponse> tokenResponseCall = iEndPointApi.getToken(ConstantesObtenerToken.CLIENT_ID , ConstantesObtenerToken.CLIENT_SECRET
        , ConstantesObtenerToken.GRANT_TYPE , ConstantesObtenerToken.REDIRECT_URI , autCode);
        tokenResponseCall.enqueue(new Callback<TokenResponse>() {
            @Override
            public void onResponse(Call<TokenResponse> call, Response<TokenResponse> response) {
                TokenResponse tokenResponse = response.body();
                Log.d("RESPONSE" , String.valueOf(response));
                token = tokenResponse.getAccess_token();
                user_id = tokenResponse.getUser_id();
                Log.d("TOKEN" , token);
                Log.d("USER_ID" , user_id);
                setUpViewpager(user , token , user_id);
            }

            @Override
            public void onFailure(Call<TokenResponse> call, Throwable t) {

            }
        });

        activity = this;


        viewPager = findViewById(R.id.viewPager);
        tabLayout = findViewById(R.id.tablayout);
        toolbar = findViewById(R.id.tbappbar);
        imgButton = findViewById(R.id.imgButton);

        imgButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this , MainActivity2.class);
                startActivity(intent);
                finish();
            }
        });





        if(toolbar != null) {
            setSupportActionBar(toolbar);
        }

    }

    private void setUpViewpager(String user , String token , String user_id) {
        viewPager.setAdapter(new pageAdapter(getSupportFragmentManager() , agregarFragment(user , token , user_id)));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.casa);
        tabLayout.getTabAt(1).setIcon(R.drawable.dragonsito);






    }

    private ArrayList<Fragment> agregarFragment(String user , String token , String user_id) {
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new Recyclerview_Fragment(user , token , user_id));
        fragments.add(new miMascota_Fragment(user , token , user_id));
        return fragments;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones , menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.mContacto:
                Intent intent = new Intent(MainActivity.this, menu_contactos.class);
                startActivity(intent);
                break;

            case R.id.mAcerDe:
                Intent intent2 = new Intent(MainActivity.this, menu_acercade.class);
                startActivity(intent2);
                break;
            case R.id.mCambiarCuenta:
                Intent intent3 = new Intent(MainActivity.this, Datos.class);
                startActivity(intent3);
                finish();
                break;

            case R.id.mRecibirNorificaciones:
                MyEndPoint myEndPoint = new MyEndPoint();
                IMyEndPoint iMyEndPoint = myEndPoint.guardarValor();
                Call<UsuarioResponse> usuarioResponseCall = iMyEndPoint.guardarValor(token, user_id);
                usuarioResponseCall.enqueue(new Callback<UsuarioResponse>() {
                    @Override
                    public void onResponse(Call<UsuarioResponse> call, Response<UsuarioResponse> response) {
                        UsuarioResponse usuarioResponse = response.body();
                        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
                        Log.d("Token", usuarioResponse.getId_dispositivo());
                        builder.setMessage("Token: " + usuarioResponse.getId_dispositivo());

                        AlertDialog alertDialog = builder.create();
                        alertDialog.show();
                        Log.d("User", user);

                    }

                    @Override
                    public void onFailure(Call<UsuarioResponse> call, Throwable t) {
                        Log.e("eRROR LLAMADA", String.valueOf(t));

                    }
                });

        }








        return super.onOptionsItemSelected(item);
    }

    public String getUser(){

        return user;

    }
}





