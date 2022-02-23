package com.example.proyectoandroid_soler_martin_perez;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;

public class consumos extends AppCompatActivity {

    CardView cvDatos;
    CardView cvLlamadas;
    CardView cvMensajes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consumos);

        cvDatos = (CardView) findViewById(R.id.cardViewDatos);
        cvLlamadas = (CardView) findViewById(R.id.cardViewLlamadas);
        cvMensajes = (CardView) findViewById(R.id.cardViewMensajes);
    }
}