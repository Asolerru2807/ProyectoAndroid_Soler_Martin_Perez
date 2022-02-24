package com.example.proyectoandroid_soler_martin_perez;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class consumos extends AppCompatActivity {

    private static RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private static RecyclerView recyclerView;
    private static ArrayList<DataConsumos> data;
    static View.OnClickListener myOnClickListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consumos);

        creacionDatos();



    }

    public void creacionDatos(){
        /*
         * Orden de introduccion de los datos:
         * double datosConsumidos, double costeDatos, double costeLlamadas, double costeMensajes,
         * int minutosLlamadas, int mensajesEnviados, String correo, String dia
         */
        data.add(new DataConsumos(90.5, 0, 0.5, 0.25,30, 1, "benjamin@gmail.com","24/02"));
        data.add(new DataConsumos(200, 0, 0, 0,0, 0, "benjamin@gmail.com","23/02"));
        data.add(new DataConsumos(150.3, 0, 0, 0,0, 0, "benjamin@gmail.com","22/02"));
        data.add(new DataConsumos(103.2, 0, 0.8, 0.43,35, 2, "benjamin@gmail.com","21/02"));
        data.add(new DataConsumos(300, 0, 0, 0,0, 0, "benjamin@gmail.com","20/02"));

        data.add(new DataConsumos(23.4, 0, 0, 0,0, 0, "olalla@gmail.com","24/02"));
        data.add(new DataConsumos(21.3, 0, 0, 0,0, 0, "olalla@gmail.com","23/02"));
        data.add(new DataConsumos(50.8, 0, 1.34, 0.23,79, 1, "olalla@gmail.com","22/02"));
        data.add(new DataConsumos(18.9, 0, 2.15, 0.23,121, 1, "olalla@gmail.com","21/02"));
        data.add(new DataConsumos(30.3, 0, 0, 0,0, 0, "olalla@gmail.com","20/02"));

        data.add(new DataConsumos(540.3, 0, 0.80, 0.45,63, 2, "aaron@gmail.com","24/02"));
        data.add(new DataConsumos(320.4, 0, 1.32, 0,81, 0, "aaron@gmail.com","23/02"));
        data.add(new DataConsumos(400.3, 0, 2.45, 0.3,132, 1, "aaron@gmail.com","22/02"));
        data.add(new DataConsumos(120.9, 0, 1.20, 0,73, 0, "aaron@gmail.com","21/02"));
        data.add(new DataConsumos(243.7, 0, 0, 0,0, 0, "aaron@gmail.com","20/02"));

        data.add(new DataConsumos(12.3, 0, 0.8, 0,45, 0, "jorge@gmail.com","24/02"));
        data.add(new DataConsumos(20.2, 0, 0.34, 0,23, 0, "jorge@gmail.com","23/02"));
        data.add(new DataConsumos(16.5, 0, 4.23, 0,340, 0, "jorge@gmail.com","22/02"));
        data.add(new DataConsumos(89.3, 0, 0.32, 0.43,20, 2, "jorge@gmail.com","21/02"));
        data.add(new DataConsumos(43.2, 0, 0, 0,0, 0, "jorge@gmail.com","20/02"));

        data.add(new DataConsumos(18.5, 0, 0, 0.46,0, 2, "julian_usr@gmail.com","24/02"));
        data.add(new DataConsumos(80.43, 0, 0.23, 0.23,23, 1, "julian_usr@gmail.com","23/02"));
        data.add(new DataConsumos(90.5, 0, 0.56, 0,52, 0, "julian_usr@gmail.com","22/02"));
        data.add(new DataConsumos(95.3, 0, 0, 0,0, 0, "julian_usr@gmail.com","21/02"));
        data.add(new DataConsumos(40.4, 0, 0, 0,0, 0, "julian_usr@gmail.com","20/02"));
    }

}