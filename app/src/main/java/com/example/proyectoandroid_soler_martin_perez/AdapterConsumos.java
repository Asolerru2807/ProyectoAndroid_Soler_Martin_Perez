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

    private ArrayList<DataConsumos> dataSet;

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textViewDia;
        TextView textViewCoste;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.textViewDia = (TextView) itemView.findViewById(R.id.textViewDia);
            this.textViewCoste = (TextView) itemView.findViewById(R.id.textViewCoste);
        }
    }

    public AdapterConsumos(ArrayList<DataConsumos> data) { this.dataSet = data;}

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cardsconsumo_layout, parent, false);

        view.setOnClickListener(consumos.myOnClickListener);

        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

}
