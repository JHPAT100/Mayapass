package com.example.mayapass.adaptador;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mayapass.R;
import com.example.mayapass.clases.ComidaV;
import com.example.mayapass.clases.MitosV;

import java.util.ArrayList;


public class AdaptadorMitos extends RecyclerView.Adapter<AdaptadorMitos.MitosViewHolder>{

    ArrayList<MitosV> listaMitos;

    public AdaptadorMitos(ArrayList<MitosV> listaMitos) {
        this.listaMitos = listaMitos;
    }

    @Override
    public MitosViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.contenedor_mitos,null,false);
        return new MitosViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MitosViewHolder holder, int position) {
        holder.txtNombre.setText(listaMitos.get(position).getNombre());
        holder.txtInformacion.setText(listaMitos.get(position).getInfo());
        holder.txtDescripcion.setText(listaMitos.get(position).getInfo());
        holder.foto.setImageResource(listaMitos.get(position).getImagenId());
    }

    @Override
    public int getItemCount() {
        return listaMitos.size();
    }

    public class MitosViewHolder extends RecyclerView.ViewHolder {
        TextView txtNombre,txtInformacion, txtDescripcion;
        ImageView foto;

        public MitosViewHolder(View itemView) {
            super(itemView);
            txtNombre= (TextView) itemView.findViewById(R.id.t1m);
            txtInformacion= (TextView) itemView.findViewById(R.id.t2m);
            txtDescripcion = (TextView) itemView.findViewById(R.id.t3m);
            foto= (ImageView) itemView.findViewById(R.id.img);
        }
    }
}
