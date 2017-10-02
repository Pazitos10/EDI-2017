package com.team.maps;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;

public class MainActivity extends AppCompatActivity
        implements GoogleApiClient.ConnectionCallbacks {

    private GoogleApiClient mGoogleApiClient;
    private Location mLastLocation;
    private Button mOpenMapButton;
    private static final int REQUEST_LOCATION_CODE = 1;
    private TextView mUserLocationMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Obtenemos la referencia a los componentes visuales de la app
        mOpenMapButton = (Button) findViewById(R.id.open_map_button);
        mUserLocationMsg = (TextView) findViewById(R.id.user_location_msg);

        //Seteamos un OnClickListener para escuchar el evento de click
        mOpenMapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Creamos un intent para abrir el activity de mapa e invocamos a startActivity()
                //con el intent creado como parametro
                Intent mapsActivityIntent = new Intent(MainActivity.this, MapsActivity.class);
                startActivity(mapsActivityIntent);
            }
        });

        //Creamos un cliente para la API de google utilizando la API de LocationServices
        mGoogleApiClient = new GoogleApiClient
                .Builder(this)
                .addConnectionCallbacks(this)
                .addApi(LocationServices.API)
                .build();
    }

    @Override
    protected void onStart() {
        super.onStart();
        //Conectamos el cliente a la API cuando la app está lista para usarse
        mGoogleApiClient.connect();
    }

    @Override
    protected void onStop() {
        super.onStop();
        //Desconectamos el cliente de la API cuando la app es detenida.
        mGoogleApiClient.disconnect();
    }


    /*
     * Implementamos los métodos callback de la conexión a la API de google.
     * onConnected(): define que hacer si el cliente pudo conectarse con éxito.
     * onConnectionSuspended(): define que hacer si la conexión fue suspendida.
     * (en este caso no nos interesa éste último comportamiento)
    */
    @Override
    public void onConnected(@Nullable Bundle bundle) {
        //Si pudimos conectarnos a la API, podemos solicitar la ubicacion del usuario
        //Si NO tenemos los permisos para pedir ubicacion, debemos solicitarselos al usuario.
        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            //Pedimos permisos en tiempo de ejecucion
            ActivityCompat.requestPermissions(
                    this,
                    new String[]{
                            android.Manifest.permission.ACCESS_FINE_LOCATION,
                            android.Manifest.permission.ACCESS_COARSE_LOCATION
                    },
                    REQUEST_LOCATION_CODE);
        }else { //Ya tenemos los permisos, ahora pedimos la ubicacion.
            pedirYMostrarUbicacion();
        }
    }

    private void pedirYMostrarUbicacion() {
        mLastLocation = LocationServices.FusedLocationApi.getLastLocation(mGoogleApiClient);
        String lat = String.valueOf(mLastLocation.getLatitude());
        String lng = String.valueOf(mLastLocation.getLongitude());
        String msg = String.format(getString(R.string.user_location_msg), lat, lng);
        mUserLocationMsg.setText(msg);
        //Con mLastLocation.getLongitude(), se obtiene la Longitud y
        //con mLastLocation.getLatitude(), se obtiene la Latitud.
    }

    @Override
    public void onConnectionSuspended(int i) {

    }


    /*
    * Este método es invocado de manera asíncrona cuando se solicitan al usuario
    * en tiempo de ejecución los permisos necesarios para llevar a cabo alguna acción.
    * En este caso se trata de la ubicación.
    */
    public void onRequestPermissionResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode){
            case REQUEST_LOCATION_CODE: {
                //Pedimos posicion
                pedirYMostrarUbicacion();
                break;
            }
        }
    }




}
