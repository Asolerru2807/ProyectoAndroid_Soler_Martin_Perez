package com.example.proyectoandroid_soler_martin_perez;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button miUsuario = (Button) findViewById(R.id.botonUsuario);

        Button tienda = (Button) findViewById(R.id.botonTiendas);

        Button consumo = (Button) findViewById(R.id.botonConsumo);

        Button web = (Button) findViewById(R.id.botonWeb);

        Button sugerencias = (Button) findViewById(R.id.botonSugerencias);

        Button cerrarSesion = (Button) findViewById(R.id.botonCerrarSesion);
    }
}