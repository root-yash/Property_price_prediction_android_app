package com.example.property;

import android.util.Log;
import android.widget.Toast;

import com.android.volley.Header;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    private void encoding(){

        RequestQueue requestQueue;
        requestQueue= Volley.newRequestQueue(getApplication().getApplicationContext());
        String host = "http://propertypricepredicterindia.herokuapp.com/";

        JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(Request.Method.POST,host,null,
                response -> Log.d("test", "encoding: "),error ->Log.d("test", "error: ")){

            @Override
            protected Map<String,Integer,Double,Double,Integer,Integer,Integer,Integer,Integer,Integer,Integer,Integer,Integer> getParams(){

            }

        }

        requestQueue.add(jsonObjectRequest);

    }


    @Test
    public void addition_isCorrect() throws Exception {
        encoding();





    }

}


