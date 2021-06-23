package com.example.property;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
public class MainActivity extends AppCompatActivity {


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.city);
        ImageButton delhi = findViewById(R.id.delhi);
        ImageButton mumbai = findViewById(R.id.mumbai);
        ImageButton bangalore = findViewById(R.id.bangalore);
        ImageButton chennai = findViewById(R.id.chennai);
        ImageButton kolkata = findViewById(R.id.kolkata);
        ImageButton hyderabad = findViewById(R.id.hyderabad);
        delhi.setOnClickListener(v -> {
            glob global= (glob) getApplication();
            String city ="Delhi";
            Double latmin=28.1;
            Double latmax=29.1;
            Double lngmin=76.7;
            Double lngmax=77.7;
            global.setCity(city);
            global.setLatmin(latmin);
            global.setLatmax(latmax);
            global.setLngmax(lngmax);
            global.setLngmin(lngmin);
            Intent intent = new Intent(MainActivity.this,locality.class);
            startActivity(intent);

        });
        mumbai.setOnClickListener(v -> {
            glob global= (glob) getApplication();
            String city ="Mumbai";
            Double latmin=18.8;
            Double latmax=19.5;
            Double lngmin=72.75;
            Double lngmax=74.0;
            global.setCity(city);
            global.setLatmin(latmin);
            global.setLatmax(latmax);
            global.setLngmax(lngmax);
            global.setLngmin(lngmin);
            Intent intent = new Intent(MainActivity.this,locality.class);
            startActivity(intent);

        });
        bangalore.setOnClickListener(v -> {
            glob global= (glob) getApplication();
            String city ="Bangalore";
            Double latmin=12.7;
            Double latmax=13.3;
            Double lngmin=77.4;
            Double lngmax=77.9;
            global.setCity(city);
            global.setLatmin(latmin);
            global.setLatmax(latmax);
            global.setLngmax(lngmax);
            global.setLngmin(lngmin);
            Intent intent = new Intent(MainActivity.this,locality.class);
            startActivity(intent);

        });
        chennai.setOnClickListener(v -> {
            glob global= (glob) getApplication();
            String city ="Chennai";
            Double latmin=12.8;
            Double latmax=13.26;
            Double lngmin=80.0;
            Double lngmax=80.34;
            global.setCity(city);
            global.setLatmin(latmin);
            global.setLatmax(latmax);
            global.setLngmax(lngmax);
            global.setLngmin(lngmin);
            Intent intent = new Intent(MainActivity.this,locality.class);
            startActivity(intent);

        });
        kolkata.setOnClickListener(v -> {
            glob global= (glob) getApplication();
            String city ="Kolkata";
            Double latmin=22.1;
            Double latmax=23.2;
            Double lngmin=88.0;
            Double lngmax=88.6;
            global.setCity(city);
            global.setLatmin(latmin);
            global.setLatmax(latmax);
            global.setLngmax(lngmax);
            global.setLngmin(lngmin);
            Intent intent = new Intent(MainActivity.this,locality.class);
            startActivity(intent);

        });
        hyderabad.setOnClickListener(v -> {
            glob global= (glob) getApplication();
            String city ="Chennai";
            Double latmin=17.14;
            Double latmax=17.67;
            Double lngmin=78.0;
            Double lngmax=78.73;
            global.setCity(city);
            global.setLatmin(latmin);
            global.setLatmax(latmax);
            global.setLngmax(lngmax);
            global.setLngmin(lngmin);
            Intent intent = new Intent(MainActivity.this,locality.class);
            startActivity(intent);

        });
    }
}