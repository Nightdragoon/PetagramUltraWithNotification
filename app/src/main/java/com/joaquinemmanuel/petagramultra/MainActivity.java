package com.joaquinemmanuel.petagramultra;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageButton;

import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.joaquinemmanuel.petagramultra.Adaptador.AnimalAdaptador;
import com.joaquinemmanuel.petagramultra.Adaptador.pageAdapter;
import com.joaquinemmanuel.petagramultra.fragments.Recyclerview_Fragment;
import com.joaquinemmanuel.petagramultra.fragments.miMascota_Fragment;
import com.joaquinemmanuel.petagramultra.menu.menu_acercade;
import com.joaquinemmanuel.petagramultra.menu.menu_contactos;
import com.joaquinemmanuel.petagramultra.pojo.Animal;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;





    private TabLayout tabLayout;

    private ViewPager viewPager;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar miActionBar = findViewById(R.id.tbToolbar);
        setSupportActionBar(miActionBar);


        viewPager = findViewById(R.id.viewPager);
        tabLayout = findViewById(R.id.tablayout);
        toolbar = findViewById(R.id.tbappbar);

        setUpViewpager();

        if(toolbar != null) {
            setSupportActionBar(toolbar);
        }













    }

    private void setUpViewpager() {
        viewPager.setAdapter(new pageAdapter(getSupportFragmentManager() , agregarFragment()));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.casa);
        tabLayout.getTabAt(1).setIcon(R.drawable.dragonsito);






    }

    private ArrayList<Fragment> agregarFragment() {
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new Recyclerview_Fragment());
        fragments.add(new miMascota_Fragment());
        return fragments;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones , menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.mContacto:
                Intent intent = new Intent(MainActivity.this, menu_contactos.class );
                startActivity(intent);
                break;

            case R.id.mAcerDe:
                Intent intent2 = new Intent(MainActivity.this , menu_acercade.class);
                startActivity(intent2);
                break;
        }






        return super.onOptionsItemSelected(item);
    }
}





