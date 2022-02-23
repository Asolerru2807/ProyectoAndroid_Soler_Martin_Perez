package com.example.proyectoandroid_soler_martin_perez;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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
    EditText user, password;
    int contador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        user = findViewById(R.id.editTextTextEmailAddress);
        password = findViewById(R.id.editTextTextPassword2);
        Button boton = findViewById(R.id.Login);
        mAuth = com.google.firebase.auth.FirebaseAuth.getInstance();
        mDataBase = FirebaseDatabase.getInstance().getReference();

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Query nombre = mDataBase.orderByChild(String.valueOf(getString(R.string.nombre).equals(user)));
                Query contrasenia = mDataBase.orderByChild(String.valueOf("pass".equals(password)));
                //AbrirMenu();
                nombre.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        contador = 0;
                        for (DataSnapshot dataSnapshot: snapshot.getChildren()){
                            contador ++;
                            if (contador == 1){
                                contrasenia.addListenerForSingleValueEvent(new ValueEventListener() {
                                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                                        contador = 0;
                                        for (DataSnapshot dataSnapshot: snapshot.getChildren()){
                                            contador ++;
                                            if (contador==1){
                                                AbrirMenu();
                                            }
                                    }
                                }

                                    @Override
                                    public void onCancelled(@NonNull DatabaseError error) {

                                    }
                                });
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
        Intent intent = new Intent(this, Menu.class);
        startActivity(intent);
    }

}

