package com.example.mayapass.adapter;


import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mayapass.R;
import com.example.mayapass.entidades.Historias;


import java.util.List;

public class adaptadorbd extends RecyclerView.Adapter<adaptadorbd.HistoriasHolder>{

    List<Historias> listaHistorias;
    public adaptadorbd(List<Historias> listaHistorias) {
        this.listaHistorias = listaHistorias;
    }



    @NonNull
    @Override
    public HistoriasHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View vista= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.contenedor,viewGroup,false);
        RecyclerView.LayoutParams layoutParams=new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        vista.setLayoutParams(layoutParams);
        return new HistoriasHolder(vista);
    }

    @Override
    public void onBindViewHolder(HistoriasHolder holder, int position) {
        holder.te_1.setText(listaHistorias.get(position).getNombre_h().toString());
        holder.te_2.setText(listaHistorias.get(position).getCorreo_h().toString());

    }

    @Override
    public int getItemCount() {
        return listaHistorias.size();
    }

    public class HistoriasHolder extends RecyclerView.ViewHolder{

        TextView te_1,te_2;

        public HistoriasHolder(View itemView) {
            super(itemView);
            te_1= (TextView) itemView.findViewById(R.id.con_1);
            te_2= (TextView) itemView.findViewById(R.id.con_2);


        }
    }
}