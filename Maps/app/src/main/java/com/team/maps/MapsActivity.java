package com.team.maps;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtiene el componente SupportMapFragment y notifica cuando el mapa esta listo para usar.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this); //Obtiene el mapa de manera asincrónica puesto que funciona con internet
    }


    /**
     * Permite manipular el mapa una vez que está listo para ser utilizado.
     * Aquí podremos añadir markers, líneas o mover la camara para centrar el mapa en otra posicion.
     * En este caso, se agregó un marker en la sede Aulas de la UNPSJB de Trelew, Chubut, Argentina.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Agregamos el marcador y movemos la cámara
        LatLng sedeAulasTw = new LatLng(-43.249804, -65.308364);
        mMap.addMarker(new MarkerOptions()
                .position(sedeAulasTw)
                .title(getString(R.string.marker_msg)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sedeAulasTw));
    }
}
