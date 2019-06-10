package com.example.mayapass;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.PorterDuff;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link registro_h.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link registro_h#newInstance} factory method to
 * create an instance of this fragment.
 */
public class registro_h extends Fragment implements View.OnClickListener, Response.Listener<JSONObject>, Response.ErrorListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    EditText te_1,te_2;
    Button btn_1,btn_2;
String t_1,t_2;
    //barra de progreso
    ProgressDialog progreso;

    //importante
    RequestQueue request;
    JsonObjectRequest jsonObjectRequest;
    //
    private OnFragmentInteractionListener mListener;

    public registro_h() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment registro_h.
     */
    // TODO: Rename and change types and number of parameters
    public static registro_h newInstance(String param1, String param2) {
        registro_h fragment = new registro_h();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MainActivity.bf.setVisibility(View.GONE);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View vista=inflater.inflate(R.layout.fragment_registro_h, container, false);
        te_1=vista.findViewById(R.id.nombre_t);
        te_2=vista.findViewById(R.id.historia_t);
        btn_1=vista.findViewById(R.id.bu_1);
        btn_2=vista.findViewById(R.id.bu_2);
        t_1=te_1.getText().toString();
        t_2=te_2.getText().toString();
        btn_1.setOnClickListener(this);
        btn_2.setOnClickListener(this);
        request= Volley.newRequestQueue(getContext());
        return vista;

    }
    //prueba
    @Override
    public void onClick(View v) {
if(v==btn_1){
    if (t_1.equals(te_1.getText().toString()) && t_2.equals(te_2.getText().toString()) ){
        te_1.setError("Campos Obligatorios");
        te_2.setError("Campos Obligatorios");

        te_1.getBackground().setColorFilter(getResources().getColor(R.color.error), PorterDuff.Mode.SRC_ATOP);
        te_2.getBackground().setColorFilter(getResources().getColor(R.color.error), PorterDuff.Mode.SRC_ATOP);
        Toast.makeText(getContext(),"Error campos obligatorios",Toast.LENGTH_SHORT).show();
    }
    else if (t_1.equals(te_1.getText().toString())){
        te_1.setError("Campos Obligatorios");
        te_1.getBackground().setColorFilter(getResources().getColor(R.color.error), PorterDuff.Mode.SRC_ATOP);
        Toast.makeText(getContext(),"Error campos obligatorios",Toast.LENGTH_SHORT).show();
    }else if (t_2.equals(te_2.getText().toString()) ){
        te_2.setError("Campos Obligatorios");

        te_2.getBackground().setColorFilter(getResources().getColor(R.color.error), PorterDuff.Mode.SRC_ATOP);
        Toast.makeText(getContext(),"Error campos obligatorios",Toast.LENGTH_SHORT).show();
    }else{
        cargarWebService();
    }
}if(v==btn_2){
            FragmentTransaction trans = getFragmentManager().beginTransaction();
            trans.replace(R.id.contenedor_principal, new lista_h());
            trans.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
            trans.addToBackStack(null);

            trans.commit();
        }
    }

    private void cargarWebService() {
        //barra de dialogo
        progreso=new ProgressDialog(getContext());
        progreso.setMessage("cargando....");
        progreso.show();
        //barra de dialogo
        String URL="http://puntosingular.mx/maya/registro_f.php?correo="+login.c_user+"&nombre="+te_1.getText().toString()+"&historia="+te_2.getText().toString();



        jsonObjectRequest=new JsonObjectRequest(Request.Method.GET,URL,null,this,this);
        request.add(jsonObjectRequest);
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        progreso.hide();
        Toast.makeText(getContext(),"No se pudo registrar"+error.toString(),Toast.LENGTH_SHORT).show();
        Log.i("Error",error.toString());
    }

    @Override
    public void onResponse(JSONObject response) {
        FragmentTransaction trans = getFragmentManager().beginTransaction();
        trans.replace(R.id.contenedor_principal, new lista_h());
        trans.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        trans.addToBackStack(null);

        trans.commit();
        Toast.makeText(getContext(),"se a resgistrado correctamente",Toast.LENGTH_SHORT).show();
        progreso.hide();
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
