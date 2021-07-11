package com.example.property;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class gettingdata extends AppCompatActivity  {

    public Integer torf(String yon){
        if (yon.equals("Yes"))
                return 1;
        else
            return 0;
    }

    public interface accmodel{
        void onsuccess(String results)throws JSONException;
    }
    private void model(accmodel callback, String city, Integer area , Double lat , Double lng, Integer bed, Integer bath , Integer balcony , Integer resa ,Integer park , Integer furn , Integer lift, Integer land ,Integer flat){
        JSONObject inp = new JSONObject();
        String auth=getResources().getString(R.string.mlapi);
        try {
            inp.put("Auth",auth);
            inp.put("City",city);
            inp.put("area",area);
            inp.put("latitude",lat);
            inp.put("longitude",lng);
            inp.put("bedroom",bed);
            inp.put("bathroom",bath);
            inp.put("balcony",balcony);
            inp.put("resaleornew",resa);
            inp.put("parking",park);
            inp.put("furnished_status",furn);
            inp.put("lift",lift);
            inp.put("landmark",land);
            inp.put("flatorIndividual",flat);
        }catch (Exception e){
            e.printStackTrace();
        }

        RequestQueue requestQueue;
        requestQueue= Volley.newRequestQueue(getApplication().getApplicationContext());
        String host = "https://propertypricepredicterindia.herokuapp.com/";

        JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(host, inp, response -> {
            try {
                String result = response.getString("price");
                String s = result.replaceAll("[\\[\\](){}]","");
                callback.onsuccess(s);

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }, error -> {

        });

        requestQueue.add(jsonObjectRequest);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.input);
        EditText areas =  findViewById(R.id.areatxt);
        EditText bedrooms =  findViewById(R.id.bedroom);
        EditText bathrooms =  findViewById(R.id.bathroom);
        EditText balconys =  findViewById(R.id.balcony);
        Spinner parkings = findViewById(R.id.parking);
        Spinner lifts = findViewById(R.id.lift);
        Spinner resales=findViewById(R.id.neworsell);
        Spinner landmarks=findViewById(R.id.nearl);
        Spinner fstats=findViewById(R.id.furnstat);
        Spinner flatorb=findViewById(R.id.htype);
        Button submit=findViewById(R.id.submit);

        String[] yesorno = getResources().getStringArray(R.array.yesorno);
        String[] furnstats = getResources().getStringArray(R.array.furstatus);
        String[] typeop = getResources().getStringArray(R.array.proptype);

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, yesorno);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ArrayAdapter adapter2 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, furnstats);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ArrayAdapter adapter3 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, typeop);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        parkings.setAdapter(adapter);
        lifts.setAdapter(adapter);
        resales.setAdapter(adapter);
        landmarks.setAdapter(adapter);
        fstats.setAdapter(adapter2);
        flatorb.setAdapter(adapter3);


        areas.setOnKeyListener((v, keyCode, event) -> {
            if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)){

                InputMethodManager imm = (InputMethodManager)v.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                return true;

            }
            return false;
        });
        bedrooms.setOnKeyListener((v, keyCode, event) -> {
            if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)){

                InputMethodManager imm = (InputMethodManager)v.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                return true;

            }
            return false;
        });
        bathrooms.setOnKeyListener((v, keyCode, event) -> {
            if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)){

                InputMethodManager imm = (InputMethodManager)v.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                return true;

            }
            return false;
        });
        balconys.setOnKeyListener((v, keyCode, event) -> {
            if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)){

                InputMethodManager imm = (InputMethodManager)v.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                return true;

            }
            return false;
        });

        submit.setOnClickListener(v -> {
            try {
                glob global =(glob) getApplication();
                Double lat = global.getLat();
                Double lng = global.getLng();
                int area= Integer.parseInt(String.valueOf(areas.getText()));
                int bedroom= Integer.parseInt(String.valueOf(bedrooms.getText()));
                int bathroom= Integer.parseInt(String.valueOf(bathrooms.getText()));
                int balcony= Integer.parseInt(String.valueOf(balconys.getText()));
                Integer parking= torf(parkings.getSelectedItem().toString());
                Integer lift = torf(lifts.getSelectedItem().toString());
                Integer resale = torf(resales.getSelectedItem().toString());
                Integer landmark = torf(landmarks.getSelectedItem().toString());

                String temp = fstats.getSelectedItem().toString();
                int fstatus;
                if(temp.equals("Non-Furnished"))
                    fstatus=0;
                else if(temp.equals("Semi-Furnished"))
                     fstatus=1;
                else
                     fstatus=2;

                temp= flatorb.getSelectedItem().toString();
                int flatorbuilding;
                if(temp.equals("Flat"))
                    flatorbuilding=0;
                else
                    flatorbuilding=1;
                if(area<20000&&bedroom<11&&bathroom<11&&balcony<11){

                    model(results -> {

                        global.setPrice(results);
                        Intent intent = new Intent(gettingdata.this,Priceoutput.class);
                        startActivity(intent);
                        finish();

                    },global.getCity(),area,lat,lng,bedroom,bathroom,balcony,resale,parking,fstatus,lift,landmark,flatorbuilding);
                }
                else {
                    Toast.makeText(gettingdata.this,"Wrong Input Try Again",Toast.LENGTH_LONG).show();
                }
            }
            catch (Exception e)
            {
                Toast.makeText(gettingdata.this,"Wrong Input Try Again",Toast.LENGTH_LONG).show();
            }
        });


    }

}