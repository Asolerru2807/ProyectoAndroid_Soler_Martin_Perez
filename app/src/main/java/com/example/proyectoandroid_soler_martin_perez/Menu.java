package com.example.proyectoandroid_soler_martin_perez;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;


public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);




        FloatingActionButton fab = findViewById(R.id.fab);

        NavigationView navigation = (NavigationView) findViewById(R.id.navigation);




        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Menu.this, Buzon_Sugerencias.class);
                startActivity(intent);;
            }
        });

        navigation.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener(){

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int id = menuItem.getItemId();
                if(id == R.id.item1){
                    Intent newIntent = new Intent(Menu.this, pagina_web.class);
                    startActivity(newIntent);
                }
                else if(id == R.id.item2){
                    Intent newIntent = new Intent(Menu.this, Mapa.class);
                    startActivity(newIntent);
                }

                else if(id == R.id.item2){
                    Intent newIntent = new Intent(Menu.this, Mapa.class);
                    startActivity(newIntent);
                }

                else if(id == R.id.item3){
                    Intent newIntent = new Intent(Menu.this, consumos.class);
                    startActivity(newIntent);
                }

                else if(id == R.id.item4){
                    Intent newIntent = new Intent(Menu.this, Buzon_Sugerencias.class);
                    startActivity(newIntent);
                }

                else if(id == R.id.item2){
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