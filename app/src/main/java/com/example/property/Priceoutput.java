package com.example.property;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class Priceoutput extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_priceoutput);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.mapView);
        mapFragment.getMapAsync(this);
        glob global= (glob) getApplication();
        String price = global.getPrice();
        float i = Float.parseFloat(price);
        String s;
        if(i >9999999) {
            String s1 = String.format("%.2f",i/10000000);
            s = "House Price : " + s1 + " Crore";
        }
        else{
            String s1 = String.valueOf((int) i / 100000);
            s = "House Price : " + s1 + " Lakh";
        }
        TextView priceoutput =findViewById(R.id.pricetext);
        priceoutput.setText(s);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        glob global=(glob) getApplication();
        LatLng area = new LatLng(global.getLat(),global.getLng());
        mMap.addMarker(new MarkerOptions().position(area).title("Area"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(area,13));
    }
}