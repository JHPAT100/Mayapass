package com.example.mayapass.adaptador;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mayapass.R;
import com.example.mayapass.clases.ComidaV;
import com.example.mayapass.clases.LeyendasV;

import java.util.ArrayList;


public class AdaptadorLeyendas extends RecyclerView.Adapter<AdaptadorLeyendas.LeyendasViewHolder>{

    ArrayList<LeyendasV> listaLeyendas;

    public AdaptadorLeyendas(ArrayList<LeyendasV> listaLeyendas) {
        this.listaLeyendas = listaLeyendas;
    }

    @Override
    public LeyendasViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.contenedor_leyendas,null,false);
        return new LeyendasViewHolder(view);
    }

    @Override
    public void onBindViewHolder(LeyendasViewHolder holder, int position) {
        holder.txtNombre.setText(listaLeyendas.get(position).getNombre());
        holder.txtInformacion.setText(listaLeyendas.get(position).getInfo());
        holder.txtDescripcion.setText(listaLeyendas.get(position).getInfo());
        holder.foto.setImageResource(listaLeyendas.get(position).getImagenId());
    }

    @Override
    public int getItemCount() {
        return listaLeyendas.size();
    }

    public class LeyendasViewHolder extends RecyclerView.ViewHolder {
        TextView txtNombre,txtInformacion, txtDescripcion;
        ImageView foto;

        public LeyendasViewHolder(View itemView) {
            super(itemView);
            txtNombre= (TextView) itemView.findViewById(R.id.t1l);
            txtInformacion= (TextView) itemView.findViewById(R.id.t2l);
            txtDescripcion = (TextView) itemView.findViewById(R.id.t3l);
            foto= (ImageView) itemView.findViewById(R.id.img);
        }
    }
}

