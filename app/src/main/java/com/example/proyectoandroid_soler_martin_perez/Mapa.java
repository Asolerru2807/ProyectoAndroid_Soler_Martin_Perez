package com.example.proyectoandroid_soler_martin_perez;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;

import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Mapa extends FragmentActivity implements OnMapReadyCallback {

    private double Latitud, Longitud;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapa);
        // Obtenemos el mapa de forma asíncrona (notificará cuando esté listo)
        SupportMapFragment mapFragment = (SupportMapFragment)
                getSupportFragmentManager().findFragmentById(R.id.mapa);
        mapFragment.getMapAsync(this);

        LocationManager locManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        Location myLocation = locManager.getLastKnownLocation(LocationManager.PASSIVE_PROVIDER);
        Latitud = myLocation.getLatitude();
        Longitud = myLocation.getLongitude();

    }

    @Override
    public void onMapReady(GoogleMap mapa) {
        //Permisos requeridos
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        //Botones predefinidos
        mapa.setMyLocationEnabled(true);
        UiSettings uiSettings = mapa.getUiSettings();
        uiSettings.setZoomControlsEnabled(true);

        //Muestra de ubicacion actual
        LatLng ubicacionActual = new LatLng(Latitud, Longitud);
        mapa.animateCamera(CameraUpdateFactory.newLatLngZoom(ubicacionActual, 13.0f));

        int markerNumber = (int)(Math.random() * 6);

        for (int i = 0; i < markerNumber; i++){
            LatLng posicionAleatoria = getRandomLocation(ubicacionActual, 2000);
            mapa.addMarker(new MarkerOptions()
                            .position(posicionAleatoria)
                            .title("Marcador aleatorio" + i)
                            .icon(BitmapDescriptorFactory.fromResource(R.raw.icono_tienda)));
        }
    }

    public LatLng getRandomLocation(LatLng myLocation, int radius) {
        double x0 = myLocation.latitude;
        double y0 = myLocation.longitude;

        Random random = new Random();

        double radiusInDegrees = radius / 111000f;
        double u = random.nextDouble();
        double v = random.nextDouble();
        double w = radiusInDegrees * Math.sqrt(u);
        double t = 2 * Math.PI * v;
        double x = w * Math.cos(t);
        double y = w * Math.sin(t);

        double new_x = x / Math.cos(y0);
        double foundLatitude = new_x + x0;
        double foundLongitude = y + y0;

        LatLng randomLatLng = new LatLng(foundLatitude, foundLongitude);
        return randomLatLng;
    }
}