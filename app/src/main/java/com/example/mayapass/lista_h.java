package com.example.mayapass;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.mayapass.adapter.adaptadorbd;
import com.example.mayapass.entidades.Historias;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link lista_h.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link lista_h#newInstance} factory method to
 * create an instance of this fragment.
 */
public class lista_h extends Fragment implements Response.Listener<JSONObject>, Response.ErrorListener{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    RecyclerView recyclerHistorias;
    ArrayList<Historias> listaHistorias;

    ProgressDialog progress;

    RequestQueue request;
    JsonObjectRequest jsonObjectRequest;

    public lista_h() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment lista_h.
     */
    // TODO: Rename and change types and number of parameters
    public static lista_h newInstance(String param1, String param2) {
        lista_h fragment = new lista_h();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vista= inflater.inflate(R.layout.fragment_lista_h, container, false);

        listaHistorias=new ArrayList<>();

        recyclerHistorias= vista.findViewById(R.id.listaR);
        recyclerHistorias.setLayoutManager(new LinearLayoutManager(this.getContext()));
        recyclerHistorias.setHasFixedSize(true);

        request= Volley.newRequestQueue(getContext());

        cargarWebService();




        return vista;
    }

    private void cargarWebService() {
        progress=new ProgressDialog(getContext());
        progress.setMessage("Consultando...");
        progress.show();


        String url="http://puntosingular.mx/maya/consultar_lista.php";

        jsonObjectRequest=new JsonObjectRequest(Request.Method.GET,url,null,this,this);
        request.add(jsonObjectRequest);

    }

    //prueba
    @Override
    public void onErrorResponse(VolleyError error) {
        Toast.makeText(getContext(),"No se pudo consultar"+error.toString(),Toast.LENGTH_SHORT).show();
        Log.i("Error",error.toString());
    }

    @Override
    public void onResponse(JSONObject response) {
        Historias historias=null;

        JSONArray json=response.optJSONArray("comunidad");

        try {

            for (int i=0;i<json.length();i++){
                historias=new Historias();
                JSONObject jsonObject=null;
                jsonObject=json.getJSONObject(i);
                historias.setCorreo_h(jsonObject.optString("correo"));
                historias.setNombre_h(jsonObject.optString("nombre_historia"));
                listaHistorias.add(historias);
            }
            progress.hide();
            adaptadorbd adapter=new adaptadorbd(listaHistorias);

            adapter.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getContext(), "Seleccion:"+listaHistorias.get(recyclerHistorias.getChildAdapterPosition(v)).getNombre_h(), Toast.LENGTH_LONG).show();
                }
            });

            recyclerHistorias.setAdapter(adapter);

        } catch (JSONException e) {
            e.printStackTrace();
            Toast.makeText(getContext(), "No se ha podido establecer conexión con el servidor" +
                    " "+response, Toast.LENGTH_LONG).show();
            progress.hide();
        }
    }


    //prueba
    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }



    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
