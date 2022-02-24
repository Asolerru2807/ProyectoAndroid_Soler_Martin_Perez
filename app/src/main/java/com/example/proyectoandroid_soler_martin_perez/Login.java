package com.example.proyectoandroid_soler_martin_perez;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class Login extends AppCompatActivity {
    FirebaseAuth mAuth;
    DatabaseReference mDataBase;
    SharedPreferences datos;
    EditText user, password;
    String usuario, pass;
    String [] nombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button boton = findViewById(R.id.Login);
        mAuth = com.google.firebase.auth.FirebaseAuth.getInstance();
        mDataBase = FirebaseDatabase.getInstance().getReference();
        datos = getSharedPreferences("datos", Context.MODE_PRIVATE);
        if((datos.contains("usuario")&&(datos.contains("password")))) {
            cargarDatos();
        }
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                user = findViewById(R.id.editTextTextEmailAddress);
                password = findViewById(R.id.editTextTextPassword2);
                usuario = user.getText().toString();
                pass = password.getText().toString();
                nombre= usuario.split("@");


                mDataBase.child("Users").child("Clientes").child(nombre[0]).addValueEventListener(new ValueEventListener() {
                        @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if (snapshot.exists()) {


                            String nombredb = snapshot.child("correo").getValue().toString();
                            String passwroddb = snapshot.child("pass").getValue().toString();

                            if (nombredb.equals(usuario)) {
                                if (passwroddb.equals(pass)){
                                    datos = getSharedPreferences("datos", Context.MODE_PRIVATE);
                                    SharedPreferences.Editor editor = datos.edit();
                                    editor.putString("usuario",usuario);
                                    editor.putString("password", pass);
                                    editor.commit();
                                    AbrirMenu();
                                }
                            }
                        }
                        }
                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

                mDataBase.child("Users").child("Admins").child(nombre[0]).addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if (snapshot.exists()) {


                            String nombredb = snapshot.child("correo").getValue().toString();
                            String passwroddb = snapshot.child("pass").getValue().toString();

                            if (nombredb.equals(usuario)) {
                                if (passwroddb.equals(pass)){
                                    datos = getSharedPreferences("datos", Context.MODE_PRIVATE);
                                    SharedPreferences.Editor editor = datos.edit();
                                    editor.putString("usuario",usuario);
                                    editor.putString("password", pass);
                                    editor.commit();
                                    AbrirAdmin();
                                }
                            }
                        }
                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });
    }


    public void AbrirMenu(){
        Intent intent = new Intent(Login.this, Menu.class);
        startActivity(intent);
    }

    public void AbrirAdmin(){
        Intent intent = new Intent(Login.this, newUserMenu.class);
        startActivity(intent);
    }

    public void cargarDatos() {

         datos = getSharedPreferences("datos", Context.MODE_PRIVATE);

            usuario = datos.getString("usuario", "");
            pass = datos.getString("password", "");
            nombre= usuario.split("@");

            mDataBase.child("Users").child("Clientes").child(nombre[0]).addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    if (snapshot.exists()) {


                        String nombredb = snapshot.child("correo").getValue().toString();
                        String passwroddb = snapshot.child("pass").getValue().toString();

                        if (nombredb.equals(usuario)) {
                            if (passwroddb.equals(pass)){
                                AbrirMenu();
                            }
                        }
                    }
                }
                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });

        }
    }


