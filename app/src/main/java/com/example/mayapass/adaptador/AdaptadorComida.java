package com.example.mayapass.adaptador;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mayapass.R;
import com.example.mayapass.clases.ComidaV;

import java.util.ArrayList;


public class AdaptadorComida extends RecyclerView.Adapter<AdaptadorComida.ComidaViewHolder>{

    ArrayList<ComidaV> listaComida;

    public AdaptadorComida(ArrayList<ComidaV> listaComida) {
        this.listaComida=listaComida;
    }

    @Override
    public ComidaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.contenedor_comida,null,false);
        return new ComidaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ComidaViewHolder holder, int position) {
        holder.txtNombre.setText(listaComida.get(position).getNombre());
        holder.txtInformacion.setText(listaComida.get(position).getInfo());
        holder.foto.setImageResource(listaComida.get(position).getImagenId());
    }

    @Override
    public int getItemCount() {
        return listaComida.size();
    }

    public class ComidaViewHolder extends RecyclerView.ViewHolder {
        TextView txtNombre,txtInformacion;
        ImageView foto;

        public ComidaViewHolder(View itemView) {
            super(itemView);
            txtNombre= (TextView) itemView.findViewById(R.id.t_1);
            txtInformacion= (TextView) itemView.findViewById(R.id.t_2);
            foto= (ImageView) itemView.findViewById(R.id.img);
        }
    }
}

