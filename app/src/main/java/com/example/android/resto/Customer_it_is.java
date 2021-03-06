package com.example.android.resto;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.firebase.auth.FirebaseAuth;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Customer_it_is extends AppCompatActivity {
    String lat = Getlocation.x;
    String lon = Getlocation.y;
    public static Context c;
    Uri uri;


    String url = "https://developers.zomato.com/api/v2.1/geocode?lat=" + lat + "&lon=" + lon;
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);
        ArrayList<Resto_list> food = new ArrayList<Resto_list>();
        Context c = getApplicationContext();
        lv = (ListView) findViewById(R.id.list);
        food = requestWithSomeHttpHeaders();
        //  food.add(new Resto_list("goo", "Ideal Cafe", "LalBagh near pitstop near ocean"));
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                //getRequiredValue();
                Object abc = lv.getItemAtPosition(i);
                if(i==0){

                    double latitude=13.0164;
                    double longitude=74.7894;
                    String label = "Restaurant";
                    String uriBegin = "geo:" + latitude + "," + longitude;
                    String query = latitude + "," + longitude + "(" + label + ")";
                    String encodedQuery = Uri.encode(query);
                    String uriString = uriBegin + "?q=" + encodedQuery + "&z=16";
                    uri = Uri.parse(uriString);
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(uri);
                    if (intent.resolveActivity(getPackageManager()) != null) {
                        startActivity(intent);
                    }
                }
                if(i==1 || i==4){

                    double latitude=12.9897;
                    double longitude=74.8001;
                    String label = "Restaurant";
                    String uriBegin = "geo:" + latitude + "," + longitude;
                    String query = latitude + "," + longitude + "(" + label + ")";
                    String encodedQuery = Uri.encode(query);
                    String uriString = uriBegin + "?q=" + encodedQuery + "&z=16";
                    uri = Uri.parse(uriString);
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(uri);
                    if (intent.resolveActivity(getPackageManager()) != null) {
                        startActivity(intent);
                    }
                }
                if(i==2){
                    double latitude=12.9863;
                    double longitude=74.8009;
                    String label = "Restaurant";
                    String uriBegin = "geo:" + latitude + "," + longitude;
                    String query = latitude + "," + longitude + "(" + label + ")";
                    String encodedQuery = Uri.encode(query);
                    String uriString = uriBegin + "?q=" + encodedQuery + "&z=16";
                    uri = Uri.parse(uriString);
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(uri);
                    if (intent.resolveActivity(getPackageManager()) != null) {
                        startActivity(intent);
                    }

                }
                if(i==3){
                    double latitude=12.9960;
                    double longitude=74.7992;
                    String label = "Restaurant";
                    String uriBegin = "geo:" + latitude + "," + longitude;
                    String query = latitude + "," + longitude + "(" + label + ")";
                    String encodedQuery = Uri.encode(query);
                    String uriString = uriBegin + "?q=" + encodedQuery + "&z=16";
                    uri = Uri.parse(uriString);
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(uri);
                    if (intent.resolveActivity(getPackageManager()) != null) {
                        startActivity(intent);
                    }

                }
                if(i==5){
                    double latitude=12.9882;
                    double longitude=74.8021;
                    String label = "Restaurant";
                    String uriBegin = "geo:" + latitude + "," + longitude;
                    String query = latitude + "," + longitude + "(" + label + ")";
                    String encodedQuery = Uri.encode(query);
                    String uriString = uriBegin + "?q=" + encodedQuery + "&z=16";
                    uri = Uri.parse(uriString);
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(uri);
                    if (intent.resolveActivity(getPackageManager()) != null) {
                        startActivity(intent);
                    }

                }
                if(i==6){
                    double latitude=13.5960;
                    double longitude=73.7992;
                    String label = "Restaurant";
                    String uriBegin = "geo:" + latitude + "," + longitude;
                    String query = latitude + "," + longitude + "(" + label + ")";
                    String encodedQuery = Uri.encode(query);
                    String uriString = uriBegin + "?q=" + encodedQuery + "&z=16";
                    uri = Uri.parse(uriString);
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(uri);
                    if (intent.resolveActivity(getPackageManager()) != null) {
                        startActivity(intent);
                    }

                }
                if(i==7){
                    double latitude=12.9894;
                    double longitude=74.8015;
                    String label = "Restaurant";
                    String uriBegin = "geo:" + latitude + "," + longitude;
                    String query = latitude + "," + longitude + "(" + label + ")";
                    String encodedQuery = Uri.encode(query);
                    String uriString = uriBegin + "?q=" + encodedQuery + "&z=16";
                    uri = Uri.parse(uriString);
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(uri);
                    if (intent.resolveActivity(getPackageManager()) != null) {
                        startActivity(intent);
                    }

                }

                if(i==8){
                    double latitude=12.9894;
                    double longitude=74.8002;
                    String label = "Restaurant";
                    String uriBegin = "geo:" + latitude + "," + longitude;
                    String query = latitude + "," + longitude + "(" + label + ")";
                    String encodedQuery = Uri.encode(query);
                    String uriString = uriBegin + "?q=" + encodedQuery + "&z=16";
                    uri = Uri.parse(uriString);
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(uri);
                    if (intent.resolveActivity(getPackageManager()) != null) {
                        startActivity(intent);
                    }

                }
            }



        });


    }


    public void getRequiredValue(){
        ArrayList<Resto_list> l = requestWithSomeHttpHeaders();
        double latitude = Double.parseDouble(lat);
        double longitude = Double.parseDouble(lon);
        String label = "Restaurant";
        String uriBegin = "geo:" + latitude + "," + longitude;
        String query = latitude + "," + longitude + "(" + label + ")";
        String encodedQuery = Uri.encode(query);
        String uriString = uriBegin + "?q=" + encodedQuery + "&z=16";
        uri = Uri.parse(uriString);
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(uri);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public final ArrayList<Resto_list> requestWithSomeHttpHeaders() {
        RequestQueue queue = Volley.newRequestQueue(this);
        final ArrayList<Resto_list> food = new ArrayList<Resto_list>();
        StringRequest postRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // response
                        //Log.d("Response", response);
                        Log.d("Res", response);
                        try {
                            // food.add(new Resto_list(R.drawable.resto, "Ideal Cafe", "LalBagh near pitstop near ocean"));

                            JSONObject details = new JSONObject(response);
                            //String list=details.getString("popularity");

                            JSONArray near = details.getJSONArray("nearby_restaurants");
                            Log.i("sbsdkjhs", near.toString());
                            for (int j = 0; j < near.length(); j++) {
                                JSONObject name = near.getJSONObject(j);
                                JSONObject restaurant = name.getJSONObject("restaurant");


                                String namee = restaurant.getString("name");
                                JSONObject loc = restaurant.getJSONObject("location");
                                // String image=restaurant.getString("thumb");
                                String add = loc.getString("address");
                                String latt = loc.getString("latitude");
                                String lonn = loc.getString("longitude");


                                String image = restaurant.getString("featured_image");
                                Log.i("help", image);
                                Log.i("sssssssssss", namee);
                                food.add(new Resto_list(image, namee, add, latt, lonn));

                                resto_adapter adapter = new resto_adapter(Customer_it_is.this, food);
                                lv.setAdapter(adapter);

                            }
                            Log.d("list", food.toString());
                        } catch (Exception e) {
                            Log.i("error", e.toString());
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO Auto-generated method stub
                        Log.d("ERROR", "error => " + error.toString());
                    }
                }
        ) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("user-key", "147d3513ebcc72936cf6c025e828c801");

                return params;
            }
        };
        queue.add(postRequest);
        //ListView abc=(ListView) findViewById(R.id.list);


        return food;


    }

    public void inte(View v) {
        resto_adapter resto_adapter = new resto_adapter(Customer_it_is.this, requestWithSomeHttpHeaders());

        String latt = resto_adapter.lat;
        String lon = resto_adapter.lon;
        Log.i("hey", latt);
        Log.i("hyh", lon);
        double latitude = Double.parseDouble(latt);
        double longitude = Double.parseDouble(lon);
        String label = "Restaurant";
        String uriBegin = "geo:" + latitude + "," + longitude;
        String query = latitude + "," + longitude + "(" + label + ")";
        String encodedQuery = Uri.encode(query);
        String uriString = uriBegin + "?q=" + encodedQuery + "&z=16";
        uri = Uri.parse(uriString);
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(uri);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}