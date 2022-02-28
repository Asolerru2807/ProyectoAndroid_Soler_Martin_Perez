package com.example.proyectoandroid_soler_martin_perez;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;


public class Menu extends AppCompatActivity {

    SharedPreferences datos;
    String [] nombre;
    String usuario;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);

        /*
        * Aqui busco los textos para para luego modificarlos y que se asignen con el usuario que ha entrado en la aplicacion
        * */
        TextView saludo = (TextView) findViewById(R.id.Titulo);
        TextView info = (TextView) findViewById(R.id.informacion);

        /*
        * Aquí busco el fab
        * */
        FloatingActionButton fab = findViewById(R.id.fab);

        /*
         * Aquí busco el menu
         * */
        NavigationView navigation = (NavigationView) findViewById(R.id.navigation);

        /*
        * Aquí busco si hay datos guardados en las preferencias para que salga por pantalla el nombre y el correo
        *
        *
        * */
        datos = getSharedPreferences("datos", Context.MODE_PRIVATE);
        usuario = datos.getString("usuario", "");
        if((datos.contains("usuario")&&(datos.contains("password")))) {
            nombre= usuario.split("@");
            saludo.setText("Bienvenido: "+nombre[0]);

            info.setText("Información de cuenta\n\nNombre: "+nombre[0]+"\n\nCorreo Electronico: "+usuario);
        }

        /*
        * Asigno un escuchador al fab para que cuando se pulse sobre inicie la actividad del buzon de sugerencias
        * */
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Menu.this, Buzon_Sugerencias.class);
                startActivity(intent);;
            }
        });

        /*
        * Asigno un escuchador al menu para que en cada boton que se pulse inicie la actividad correspondiente
        * */
        navigation.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener(){

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int id = menuItem.getItemId();
                if(id == R.id.item1){
                    Intent newIntent = new Intent(Menu.this, pagina_web.class);
                    startActivity(newIntent);
                }
                else if(id == R.id.item2){

                    Intent intent = new Intent(Menu.this, Mapa.class);
                    startActivity(intent);
                }

                else if(id == R.id.item3){
                    Intent newIntent = new Intent(Menu.this, consumos.class);
                    startActivity(newIntent);
                }

                else if(id == R.id.item4){
                    Intent newIntent = new Intent(Menu.this, Buzon_Sugerencias.class);
                    startActivity(newIntent);
                }

                else if(id == R.id.item5){
                    SharedPreferences.Editor editor = getSharedPreferences("datos", MODE_PRIVATE).edit();
                    editor.clear().apply();
                    Intent newIntent = new Intent(Menu.this, Login.class);
                    startActivity(newIntent);
                }
                return true;
            }
        });



    }
}