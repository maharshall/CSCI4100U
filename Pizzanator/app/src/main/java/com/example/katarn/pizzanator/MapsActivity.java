package com.example.katarn.pizzanator;

/**
 * Alex Marshall
 */

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity {
    private GoogleMap map;
    private double latitude, longitude;
    private String address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        //get latitude, longitude, and address from PizzaDetail
        Intent callingIntent = getIntent();
        latitude = callingIntent.getDoubleExtra("latitude", 0.0);
        longitude = callingIntent.getDoubleExtra("longitude", 0.0);
        address = callingIntent.getStringExtra("address");

        setUpMapIfNeeded();
    }

    @Override
    protected void onResume() {
        super.onResume();
        setUpMapIfNeeded();
    }

    private void setUpMapIfNeeded() {
        if (map == null) {
            map = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map)).getMap();
            if (map != null) {
                showMapLocation();
            }
        }
    }

    private void showMapLocation() {
        //Add location on map with Address text
        LatLng position = new LatLng(latitude, longitude);
        map.addMarker(new MarkerOptions().position(position).title(address));
        map.animateCamera(CameraUpdateFactory.newLatLngZoom(position, 14));

        map.setBuildingsEnabled(true);
        map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        map.getUiSettings().setZoomControlsEnabled(true);
        map.getUiSettings().setZoomGesturesEnabled(true);
    }
}
