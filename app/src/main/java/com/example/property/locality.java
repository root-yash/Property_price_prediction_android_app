package com.example.property;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;


public class locality extends AppCompatActivity {
    public interface volleycallback {
        void onsuccess(JSONObject result) throws JSONException;

    }
    private void encoding(final volleycallback callback,String locality,String city){

        RequestQueue requestQueue;
        requestQueue= Volley.newRequestQueue(getApplication().getApplicationContext());
        String host = "https://trueway-geocoding.p.rapidapi.com/Geocode?";
        String x_rapidapi_key = "Enter Your own Key";
        String s = locality+","+city;
        String query = null;
        try {
            query = URLEncoder.encode(s, "UtF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        host = host+"rapidapi-key="+x_rapidapi_key+"&address="+ query + "&language=en";
        JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(Request.Method.GET,
                host, null, response -> {
                    try {
                        JSONArray results = response.getJSONArray("results");
                        JSONObject result = results.getJSONObject(0);
                        JSONObject location = result.getJSONObject("location");
                        callback.onsuccess(location);
                    } catch (JSONException e) {
                        Toast.makeText(locality.this,"No Such Locality Exist in "+city,Toast.LENGTH_LONG).show();

                    }

                }, error -> Toast.makeText(locality.this,"No Such Locality Exist in "+city,Toast.LENGTH_LONG).show());

        requestQueue.add(jsonObjectRequest);

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.locality);
        glob global = (glob) getApplication();
        EditText editText= findViewById(R.id.localaddress);
        String city=global.getCity();
        Double latmin=global.getLatmin();
        Double lngmin=global.getLngmin();
        Double latmax=global.getLatmax();
        Double lngmax=global.getLngmax();

        editText.setOnKeyListener((v, keyCode, event) -> {
            if ((event.getAction() == KeyEvent.ACTION_DOWN) &&
                    ((keyCode == KeyEvent.KEYCODE_ENTER) || (keyCode == EditorInfo.IME_NULL))) {
                // Perform action on key press
                String locality = String.valueOf(editText.getText());
                InputMethodManager imm = (InputMethodManager) v.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(v.getWindowToken(), 0);

                encoding(result -> {
                    Double lat = result.getDouble("lat");
                    Double lng = result.getDouble("lng");
                    if (lat > latmin && lat < latmax && lng > lngmin && lng < lngmax) {

                        global.setLng(lng);
                        global.setLat(lat);
                        Intent intent = new Intent(locality.this, gettingdata.class);
                        startActivity(intent);
                        finish();
                    } else {
                        Toast.makeText(locality.this, "No Such Locality Exist in " + city, Toast.LENGTH_LONG).show();
                    }
                }, locality, city);
                return true;
            }
            return false;
        });




    }
}