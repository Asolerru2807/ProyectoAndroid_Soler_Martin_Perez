package com.example.proyectoandroid_soler_martin_perez;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class AdapterConsumos extends RecyclerView.Adapter<AdapterConsumos.MyViewHolder> {

    ArrayList<DataConsumos> dataSet;

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textViewDia;
        TextView textViewDatos;
        TextView textViewLlamadas;
        TextView textViewMensajes;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.textViewDia = (TextView) itemView.findViewById(R.id.textViewDia);
            this.textViewDatos = (TextView) itemView.findViewById(R.id.textViewDatos);
            this.textViewLlamadas = (TextView) itemView.findViewById(R.id.textViewLlamadas);
            this.textViewMensajes = (TextView) itemView.findViewById(R.id.textViewMensajes);
        }
    }

    public AdapterConsumos(ArrayList<DataConsumos> data) { this.dataSet = data;}

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cardsconsumo_layout, parent, false);

        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        TextView textViewDia = holder.textViewDia;
        TextView textViewDatos = holder.textViewDatos;
        TextView textViewLlamadas = holder.textViewLlamadas;
        TextView textViewMensajes = holder.textViewMensajes;

        String datosText = (dataSet.get(position).getDatosConsumidos() + " mb" + "\t\t\t" + dataSet.get(position).getCosteDatos() + "€");
        String mensajesText = (dataSet.get(position).getMinutosLlamadas() + " minutos" + "\t\t\t" + dataSet.get(position).getCosteLlamadas() + "€");
        String llamadasText = (dataSet.get(position).getMensajesEnviados() + " mensajes" + "\t\t\t" + dataSet.get(position).getCosteMensajes() + "€");

        textViewDia.setText(dataSet.get(position).getDia());
        textViewDatos.setText(datosText);
        textViewLlamadas.setText(mensajesText);
        textViewMensajes.setText(llamadasText);
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

}
