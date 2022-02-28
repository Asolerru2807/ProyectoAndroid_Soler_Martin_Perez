package com.example.proyectoandroid_soler_martin_perez;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class Buzon_Sugerencias extends AppCompatActivity {
    Button button;
    EditText correo, asunto, mensaje;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gmail_sugerencias);
        //Recoge lo escrito por el usuario
        asunto = findViewById(R.id.editTextAsunto);
        mensaje = findViewById(R.id.editTextMensaje);
        button = findViewById(R.id.Enviar);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mandarCorreo();
            }
        });

    }
    private void mandarCorreo(){
        //Aqui lo que hace es recoger lo que ha escrito el usuario y enviarlo.
        //Este es el email al que se envian los correos.
        String[] TO = {"miguelmartin2694@gmail.com"};
        String[] CC = {""};
        Intent email = new Intent(android.content.Intent.ACTION_SEND);
        String mailId="abc.gmail.com";
        email.setData(Uri.parse("mailto: "));
        email.setType("text/plain");
        email.putExtra(Intent.EXTRA_EMAIL, TO);
        email.putExtra(Intent.EXTRA_SUBJECT, asunto.getText().toString());
        email.putExtra(Intent.EXTRA_TEXT, mensaje.getText().toString());
        //Esta linea lo que hace es que todo lo que vamos a enviar nos dejara elegir la plataforma a la que enviarlo.
        startActivity(email.createChooser(email, "Envio correo"));


    }

}
