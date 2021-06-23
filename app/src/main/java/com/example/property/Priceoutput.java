package com.example.property;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Priceoutput extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_priceoutput);
        glob global= (glob) getApplication();
        String price = global.getPrice();
        float i = Float.parseFloat(price);
        String s1 = String.valueOf((int) i /100000);
        TextView priceoutput =findViewById(R.id.pricetext);
        String s= "House Price : "+s1+"lacs";
        priceoutput.setText(s);
    }
}