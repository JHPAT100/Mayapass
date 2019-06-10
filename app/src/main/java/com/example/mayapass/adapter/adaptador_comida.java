package com.example.mayapass.adapter;


import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mayapass.R;
import com.example.mayapass.entidades.comida;

import java.util.ArrayList;


public class adaptador_comida extends RecyclerView.Adapter<adaptador_comida.ComidaHolder> implements View.OnClickListener {

    ArrayList<comida>listaComida;
private  View.OnClickListener listener;
    public adaptador_comida(ArrayList<comida> listaComida) {
        this.listaComida = listaComida;
    }

    @NonNull
    @Override
    public ComidaHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View vista= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.contenedor_2,null,false);
        //on
vista.setOnClickListener(this);
//on
        return new ComidaHolder(vista);
    }

    @Override
    public void onBindViewHolder(@NonNull ComidaHolder holder, int position) {
        holder.te_1.setText(listaComida.get(position).getNombre());
        holder.te_2.setText(listaComida.get(position).getDescripcion());
        holder.te_3.setText("Receta:");
        holder.te_4.setText("Descripcion:");
        holder.img.setImageResource(listaComida.get(position).getFoto());
    }
//on
    @Override
    public int getItemCount() {
        return listaComida.size();
    }
public void setOnClickListener(View.OnClickListener listener){
     this.listener=listener;
}
    @Override
    public void onClick(View v) {
       if(listener!=null) {
           listener.onClick(v);
       }
    }
//on
    public class ComidaHolder extends RecyclerView.ViewHolder {

        TextView te_1,te_2,te_3,te_4;
        ImageView img;

        public ComidaHolder(@NonNull View itemView) {
            super(itemView);
            te_1=itemView.findViewById(R.id.con_1_1);
            te_2=itemView.findViewById(R.id.con_2_2);
            te_3=itemView.findViewById(R.id.texto_1);
            te_4=itemView.findViewById(R.id.texto_2);
            img =itemView.findViewById(R.id.img_2);
        }
    }
}