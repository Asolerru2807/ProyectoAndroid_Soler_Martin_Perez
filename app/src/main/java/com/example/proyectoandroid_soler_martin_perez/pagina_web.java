package com.example.proyectoandroid_soler_martin_perez;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class pagina_web extends AppCompatActivity {

    WebView miVisorWeb;
    String url = "https://www.e-itaca.es/index.php/avisos";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pagina_web);
        miVisorWeb = (WebView) findViewById(R.id.pagina);
        //Abre la pagina de la url en la aplicacion sin llevarte al navegador.
        final WebSettings ajustesVisorWeb = miVisorWeb.getSettings();
        ajustesVisorWeb.setJavaScriptEnabled(true);
        miVisorWeb.loadUrl(url);

    }
}
