package com.example.mayapass.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mayapass.R;
import com.example.mayapass.entidades.Mitos;


import java.util.ArrayList;

public class adaptador_mitos extends RecyclerView.Adapter<adaptador_mitos.MitosHolder> implements View.OnClickListener {

    ArrayList<Mitos> listaMitos;
    private  View.OnClickListener listener;
    public adaptador_mitos(ArrayList<Mitos> listaMitos) {
        this.listaMitos = listaMitos;
    }

    @NonNull
    @Override
    public MitosHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View vista= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.contenedor_2,null,false);
        //on
        vista.setOnClickListener(this);
//on
        return new MitosHolder(vista);
    }

    @Override
    public void onBindViewHolder(@NonNull MitosHolder holder, int position) {
        holder.te_1.setText(listaMitos.get(position).getNombre());
        holder.te_2.setText(listaMitos.get(position).getDescripcion());
        holder.te_3.setText("Mito:");
        holder.te_4.setText("Descripcion:");
        holder.img.setImageResource(listaMitos.get(position).getFoto());
    }
    //on
    @Override
    public int getItemCount() {
        return listaMitos.size();
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
    public class MitosHolder extends RecyclerView.ViewHolder {

        TextView te_1,te_2,te_3,te_4;
        ImageView img;

        public MitosHolder(@NonNull View itemView) {
            super(itemView);
            te_1=itemView.findViewById(R.id.con_1_1);
            te_2=itemView.findViewById(R.id.con_2_2);
            te_3=itemView.findViewById(R.id.texto_1);
            te_4=itemView.findViewById(R.id.texto_2);
            img =itemView.findViewById(R.id.img_2);
        }
    }
}
