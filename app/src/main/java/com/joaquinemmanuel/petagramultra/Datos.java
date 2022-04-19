package com.joaquinemmanuel.petagramultra;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.joaquinemmanuel.petagramultra.db.DB;
import com.joaquinemmanuel.petagramultra.pojo.Usuario;

import java.util.ArrayList;

public class Datos extends AppCompatActivity {

    EditText edtEncontrarUsuario;
    ImageView imgEncontradoOno;
    TextView tvEncontradoOno;
    Button btnContinuar;
    ArrayList<Usuario> usuarios;
    String resultado;
    Context context;
    String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos);
        context = this;
        edtEncontrarUsuario = findViewById(R.id.edtEncontrarUsuario);
        imgEncontradoOno = findViewById(R.id.imgEncontradoOno);
        tvEncontradoOno = findViewById(R.id.tvEncontradoOno);
        btnContinuar = findViewById(R.id.btnContinuar);
        usuarios = new ArrayList<>();
        makeButton(btnContinuar , edtEncontrarUsuario , imgEncontradoOno  , tvEncontradoOno);
    }

    public void getUsers(String possibleUser, ImageView imgEncontradoOno , TextView textView) {
        DB db = new DB(Datos.this);
        db.iniciarUsuarios();
        db.verUsuarios(usuarios);
        for (Usuario i : usuarios) {
            if (possibleUser.equals(i.getNombre())) {
                String nombreComprobado = i.getNombre();
                imgEncontradoOno.setImageResource(R.drawable.si);
                resultado = i.getNombre();
                textView.setText(nombreComprobado);
                Intent intent = new Intent(Datos.this , WebViewActivity.class);
                intent.putExtra("A" ,resultado);
                startActivity(intent);

            }else{
                String usuarioInexistente = "Usuario no encontrado";
                imgEncontradoOno.setImageResource(R.drawable.no);
                resultado = usuarioInexistente;
                textView.setText(usuarioInexistente);
                Log.e("Resultado" , i.getNombre() + " no es igual a " + possibleUser );
            }


        }
    }

    public void makeButton(Button button , EditText possibleUser, ImageView imgEncontradoOno , TextView textView){
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = possibleUser.getText().toString();


                getUsers(nombre , imgEncontradoOno , textView);
            }
        });

    }


}