package com.example.proyectoandroid_soler_martin_perez;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);

        Button botonMiUsuario = (Button) findViewById(R.id.botonUsuario);

        Button botonTienda = (Button) findViewById(R.id.botonTiendas);

        Button botonConsumo = (Button) findViewById(R.id.botonConsumo);

        Button botonWeb = (Button) findViewById(R.id.botonWeb);

        Button botonSugerencias = (Button) findViewById(R.id.botonSugerencias);

        Button botonCerrarSesion = (Button) findViewById(R.id.botonCerrarSesion);



        botonMiUsuario.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(Menu.this, miPerfil.class);
                startActivity(intent);
            }
        });

        botonConsumo.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(Menu.this, consumos.class);
                startActivity(intent);
            }
        });

        botonWeb.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(Menu.this, pagina_web.class);
                startActivity(intent);
            }
        });



    }
}