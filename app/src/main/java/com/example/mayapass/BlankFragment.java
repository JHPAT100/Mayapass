package com.example.mayapass;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class BlankFragment extends SupportMapFragment implements OnMapReadyCallback {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = super.onCreateView(inflater, container, savedInstanceState);

        getMapAsync(this);

        return rootView;

    }

    @Override
    public void onMapReady(GoogleMap map) {
        ubicaciones(map);
    }

    public interface OnFragmentInteractionListener {
    }

public void ubicaciones (GoogleMap map){
        //Identificacion de datos
    // Posicionar el mapa en una localización y con un nivel de zoom
    LatLng latLng1 = new LatLng(21.0961031,-89.6015955);
    LatLng latLng2 = new LatLng(18.4197808,-88.8104414);
    LatLng latLng3 = new LatLng(20.5330549,-89.6762548);
    LatLng latLng4 = new LatLng(18.0383002,-89.6826467);
    LatLng latLng5 = new LatLng(14.8460772,-89.1681294);
    LatLng latLng6 = new LatLng(20.8922935,-88.1381227);
    LatLng latLng7 = new LatLng(17.452457,-92.3658271);
    LatLng latLng8 = new LatLng(20.2150812,-87.4316555);
    LatLng latLng9 = new LatLng(20.490332,-87.7340866);
    LatLng latLng10 = new LatLng(17.2239372,-89.6333744);
    LatLng latLng11 = new LatLng(20.3587888,-89.7881702);
    LatLng latLng12 = new LatLng(20.6842849,-88.5699713);
    // Un zoom mayor que 13 hace que el emulador falle, pero un valor deseado para
    // callejero es 17 aprox.
    float zoom = 6;
    map.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng4, zoom));

    // Colocar un marcador en la misma posición
    map.addMarker(new MarkerOptions().position(latLng1).title("Dzibilchaltún"));
    map.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.drawable.i_9)).anchor(0.0f,1.0f).position(latLng2).title("Kohunlich"));
    map.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.drawable.i_9)).anchor(0.0f,1.0f).position(latLng3).title("Yaxhá"));
    map.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.drawable.i_9)).anchor(0.0f,1.0f).position(latLng4).title("Calakmul"));
    map.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.drawable.i_9)).anchor(0.0f,1.0f).position(latLng5).title("Copán"));
    map.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.drawable.i_9)).anchor(0.0f,1.0f).position(latLng6).title("Ek’ Balam"));
    map.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.drawable.i_9)).anchor(0.0f,1.0f).position(latLng7).title("Palenque"));
    map.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.drawable.i_9)).anchor(0.0f,1.0f).position(latLng8).title("Tulum"));
    map.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.drawable.i_9)).anchor(0.0f,1.0f).position(latLng9).title("Cobá"));
    map.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.drawable.i_9)).anchor(0.0f,1.0f).position(latLng10).title("Tikal"));
    map.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.drawable.i_9)).anchor(0.0f,1.0f).position(latLng11).title("Uxmal"));
    map.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.drawable.i_9)).anchor(0.0f,1.0f).position(latLng12).title("Chichén Itzá"));



    // Más opciones para el marcador en:
    // https://developers.google.com/maps/documentation/android/marker

    // Otras configuraciones pueden realizarse a través de UiSettings
    // UiSettings settings = getMap().getUiSettings();
    //datos de prueba
}

}