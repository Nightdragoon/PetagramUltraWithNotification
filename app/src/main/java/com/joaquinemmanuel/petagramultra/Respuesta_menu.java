package com.joaquinemmanuel.petagramultra;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Respuesta_menu extends AppCompatActivity {

    TextView Nombre;
    Button Boton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_respuesta_menu);
        Nombre = findViewById(R.id.tvRespuestamenu22);
        Boton = findViewById(R.id.etButton);

        Bundle params = getIntent().getExtras();

        String nombre = params.getString("Nombre");

        Nombre.setText(nombre);

        Button();

    }

    public void Button(){
        Boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Respuesta_menu.this , MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}