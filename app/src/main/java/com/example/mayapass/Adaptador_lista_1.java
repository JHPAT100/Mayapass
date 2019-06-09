package com.example.mayapass;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class Adaptador_lista_1 extends BaseAdapter {
    private static LayoutInflater inflater = null;
    Context contexto;
    String[][] comidas;
    int[] imgComida;

    public Adaptador_lista_1(Context conexto, String[][] comidas, int[] imgComida) {
        this.contexto = conexto;
        this.comidas = comidas;
        this.imgComida = imgComida;
        inflater = (LayoutInflater) conexto.getSystemService(conexto.LAYOUT_INFLATER_SERVICE);

    }


    @Override
    public View getView(int i, View convertView, ViewGroup parent) {

        final View vista = inflater.inflate(R.layout.contenedor, null);
        ImageView Foto=(ImageView)vista.findViewById(R.id.img);
        TextView comida =(TextView) vista.findViewById(R.id.t_1);
        TextView contenido =(TextView) vista.findViewById(R.id.t_2);

        comida.setText("Nombre: "+comidas[i][0]);
        contenido.setText("Descripción: "+comidas[i][1]);
        Foto.setImageResource(imgComida[i]);


        return vista;
    }

    @Override
    public int getCount() {
        return imgComida.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

}
