package com.joaquinemmanuel.petagramultra.menu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.joaquinemmanuel.petagramultra.R;
import com.joaquinemmanuel.petagramultra.Respuesta_menu;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class menu_contactos extends AppCompatActivity {

    private Button button;
    Session session;
    String contraseña;
    String correo;
    EditText Nombre;
    EditText Correo;
    EditText Mensaje;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_contactos);
        Toolbar miActionBar = findViewById(R.id.tbToolbar4);
        setSupportActionBar(miActionBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        button = findViewById(R.id.etEnviar);
        Nombre = findViewById(R.id.tbNombre);
        Correo = findViewById(R.id.tbEmail);
        Mensaje = findViewById(R.id.etMensaje);

        contraseña = "KentuckyFrieChiken0";
        correo = "petagramultra@gmail.com";

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
                StrictMode.setThreadPolicy(policy);
                Properties propiedad = new Properties();
                propiedad.put("mail.smtp.host" , "smtp.gmail.com");
                propiedad.put("mail.smtp.socketFactory.port" , "465");
                propiedad.put("mail.smtp.socketFactory.class" , "javax.net.ssl.SSLSocketFactory");
                propiedad.put("mail.smtp.auth" , "true");
                propiedad.put("mail.smtp.port" , "465");

                try {

                    session = javax.mail.Session.getDefaultInstance(propiedad, new Authenticator() {
                        @Override
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication(correo , contraseña);
                        }
                    });

                    if (session != null){
                        Message message = new MimeMessage(session);
                        message.setFrom(new InternetAddress(correo));
                        message.setSubject("hola perro");
                        message.setRecipients(Message.RecipientType.TO , InternetAddress.parse(edittextToString(Correo)));
                        message.setContent(edittextToString(Mensaje) , "text/html; charset=utf-8");
                        Transport.send(message);


                    }

                }catch (Exception e){
                    e.printStackTrace();
                }


                Intent intent = new Intent(menu_contactos.this , Respuesta_menu.class);
                intent.putExtra("Nombre" , edittextToString(Nombre));

                startActivity(intent);
                finish();






            }//fin de onclick liestener
        });

    }//fin de oncreate

    public String edittextToString(EditText param) {

        String dedsec = param.getText().toString();


        return dedsec;
    }
}