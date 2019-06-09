package com.example.mayapass;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
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
 * {@link registro_usuario.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link registro_usuario#newInstance} factory method to
 * create an instance of this fragment.
 */
public class registro_usuario extends Fragment implements Response.Listener<JSONObject>, Response.ErrorListener, View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
EditText te_1,te_2,te_3,te_4;
Button btn,btn1;

    //barra de progreso
    ProgressDialog progreso;

    //importante
    RequestQueue request;
    JsonObjectRequest jsonObjectRequest;
    private OnFragmentInteractionListener mListener;

    public registro_usuario() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment registro_usuario.
     */
    // TODO: Rename and change types and number of parameters
    public static registro_usuario newInstance(String param1, String param2) {
        registro_usuario fragment = new registro_usuario();
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
        View vista = inflater.inflate(R.layout.fragment_registro_usuario, container, false);
        te_1 = vista.findViewById(R.id.c_Nombre);
        te_2 = vista.findViewById(R.id.c_correo);
        te_3 = vista.findViewById(R.id.c_contraseña);
        te_4 = vista.findViewById(R.id.contraseña_repetir);
        btn = vista.findViewById(R.id.btn_registro);
        btn1 = vista.findViewById(R.id.btnlogin);
        request = Volley.newRequestQueue(getContext());

        btn1.setOnClickListener(this);
        btn.setOnClickListener(this);


        return vista;
    }

    //pruebas
    @Override
    public void onErrorResponse(VolleyError error) {
        progreso.hide();
        Toast.makeText(getContext(),"No se pudo registrar"+error.toString(),Toast.LENGTH_SHORT).show();
        Log.i("Error",error.toString());
    }

    @Override
    public void onResponse(JSONObject response) {
        Toast.makeText(getContext(),"se a resgistrado correctamente",Toast.LENGTH_SHORT).show();
        progreso.hide();
    }
    private void cargarWebService() {
        //barra de dialogo
        progreso=new ProgressDialog(getContext());
        progreso.setMessage("cargando....");
        progreso.show();
        //barra de dialogo
        String URL="http://puntosingular.mx/maya/registro.php?nombre="+te_1.getText().toString()+"&correo="+te_2.getText().toString()+"&contraseña="+te_3.getText().toString();



        jsonObjectRequest=new JsonObjectRequest(Request.Method.GET,URL,null,this,this);
        request.add(jsonObjectRequest);
    }
    //pruebas



//pruebas

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

    @Override
    public void onClick(View v) {
        if(v==btn){
            String a1,a2;
            a1=te_3.getText().toString();
            a2=te_4.getText().toString();

            if(a1.equals(a2)){
                cargarWebService();
            }
            else{
                te_4.setError("La contraseña no es igual");
                te_4.setText("");
                te_4.getBackground().setColorFilter(getResources().getColor(R.color.error), PorterDuff.Mode.SRC_ATOP);
                Toast.makeText(getContext(),"No se pudo registrar",Toast.LENGTH_SHORT).show();
            }
        }
        if(v==btn1){
            FragmentTransaction trans = getFragmentManager().beginTransaction();
            trans.replace(R.id.contenedor_principal, new login());
            trans.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
            trans.addToBackStack(null);

            trans.commit();
        }
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
