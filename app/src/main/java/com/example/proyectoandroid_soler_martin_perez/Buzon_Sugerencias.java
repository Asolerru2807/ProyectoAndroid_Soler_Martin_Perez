package com.example.proyectoandroid_soler_martin_perez;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class Buzon_Sugerencias extends AppCompatActivity {
    Button button;
    EditText correo, asunto, mensaje, nombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gmail_sugerencias);

        correo = findViewById(R.id.emailUser);
        asunto = findViewById(R.id.editTextAsunto);
        mensaje = findViewById(R.id.editTextMensaje);
        nombre = findViewById(R.id.editTextTextPersonName);
        button = findViewById(R.id.Enviar);



    }

}
