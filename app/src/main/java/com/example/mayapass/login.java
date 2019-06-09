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
import com.example.mayapass.entidades.Usuario;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link login.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link login#newInstance} factory method to
 * create an instance of this fragment.
 */
public class login extends Fragment implements Response.Listener<JSONObject>, Response.ErrorListener, View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
EditText te_1,te_2;
Button btn,btn1;
ProgressDialog progreso;
    String com;
RequestQueue request;
JsonObjectRequest jsonObjectRequest;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public login() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment login.
     */
    // TODO: Rename and change types and number of parameters
    public static login newInstance(String param1, String param2) {
        login fragment = new login();
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
            MainActivity.bf.setVisibility(View.GONE);
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        MainActivity.bf.setVisibility(View.GONE);
      View vista =inflater.inflate(R.layout.fragment_login, container, false);
        te_1=vista.findViewById(R.id.email);
        te_2=vista.findViewById(R.id.password);
        btn=vista.findViewById(R.id.btn_login);
btn1=vista.findViewById(R.id.btn_1);
        request= Volley.newRequestQueue(getContext());
        com=te_1.getText().toString();
        btn1.setOnClickListener(this);
        btn.setOnClickListener(this);


        return vista;
    }

    private void cargarWebService() {
        //barra de dialogo
        progreso=new ProgressDialog(getContext());
        progreso.setMessage("Consultando...");
        progreso.show();
        //barra de dialogo

        String URL="http://puntosingular.mx/maya/consultar.php?correo="+te_1.getText().toString()+"&contraseña="+te_2.getText().toString();
        jsonObjectRequest=new JsonObjectRequest(Request.Method.GET,URL,null,this,this);
        request.add(jsonObjectRequest);
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Toast.makeText(getContext(),"No se pudo consultar"+error.toString(),Toast.LENGTH_SHORT).show();
        Log.i("Error",error.toString());
    }

    @Override
    public void onResponse(JSONObject response) {
        progreso.hide();
        Usuario user=new Usuario();
        JSONArray json= response.optJSONArray("usuario");
        JSONObject jsonObject=null;

        try {
            jsonObject=json.getJSONObject(0);

            user.setNombre(jsonObject.optString("nombre"));
            user.setCorreo(jsonObject.optString("correo"));
            user.setContraseña(jsonObject.optString("contraseña"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        com=te_1.getText().toString();
        if (com.equals(user.getCorreo())){
            te_1.setText("");
            te_2.setText("");
            FragmentTransaction trans = getFragmentManager().beginTransaction();
            trans.replace(R.id.contenedor_principal, new lista_h());
            trans.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
            trans.addToBackStack(null);

            trans.commit();
        }else{
            te_1.setError("Datos incorrectos");
            te_2.setError("Datos incorrectos");
            te_1.setText("");
            te_2.setText("");
            te_1.getBackground().setColorFilter(getResources().getColor(R.color.error), PorterDuff.Mode.SRC_ATOP);
            te_2.getBackground().setColorFilter(getResources().getColor(R.color.error), PorterDuff.Mode.SRC_ATOP);
            Toast.makeText(getContext(),"No se pudo ingresar",Toast.LENGTH_SHORT).show();
        }

    }

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
            cargarWebService();
        }
        if(v==btn1){
            FragmentTransaction trans = getFragmentManager().beginTransaction();
            trans.replace(R.id.contenedor_principal, new registro_usuario());
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
