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
    String correoEmpresa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gmail_sugerencias);

        correo = findViewById(R.id.emailUser);
        asunto = findViewById(R.id.editTextAsunto);
        mensaje = findViewById(R.id.editTextMensaje);
        correoEmpresa = "miguelmartin2694@gmail.com";

        button = findViewById(R.id.Enviar);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mandarCorreo();
            }
        });

    }
    private void mandarCorreo(){
        Intent email = new Intent(Intent.ACTION_SENDTO);
        email.setData(Uri.parse("mailto: "));
        email.setType("text/plain");
        email.putExtra(Intent.EXTRA_EMAIL, new String[]{correo.getText().toString()} );
        email.putExtra(Intent.EXTRA_SUBJECT, asunto.getText().toString());
        email.putExtra(Intent.EXTRA_TEXT, mensaje.getText().toString());
        startActivity(Intent.createChooser(email, "Send"));

    }

}
