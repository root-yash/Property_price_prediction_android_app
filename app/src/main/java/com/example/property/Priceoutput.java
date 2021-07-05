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
}