package com.example.android.resto;

import android.content.Context;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
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
    String lat=Getlocation.x;
    String lon=Getlocation.y;
    public static Context c;


    String url = "https://developers.zomato.com/api/v2.1/geocode?lat="+lat+"&lon="+lon;
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);
        ArrayList<Resto_list> food = new ArrayList<Resto_list>();
        Context c=getApplicationContext();
        lv = (ListView) findViewById(R.id.list);
        food=requestWithSomeHttpHeaders();
     //  food.add(new Resto_list("goo", "Ideal Cafe", "LalBagh near pitstop near ocean"));



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
                        Log.d("Res",response);
                        try {
                           // food.add(new Resto_list(R.drawable.resto, "Ideal Cafe", "LalBagh near pitstop near ocean"));

                            JSONObject details = new JSONObject(response);
                            //String list=details.getString("popularity");

                            JSONArray near=details.getJSONArray("nearby_restaurants");
                            Log.i("sbsdkjhs", near.toString());
                            for(int j=0;j<near.length();j++) {
                                JSONObject name = near.getJSONObject(j);
                                JSONObject restaurant = name.getJSONObject("restaurant");


                                String namee = restaurant.getString("name");
                                JSONObject loc=restaurant.getJSONObject("location");
                               // String image=restaurant.getString("thumb");
                                String add=loc.getString("address");
                                String latt=loc.getString("latitude");
                                 String lonn=loc.getString("longitude");


                                String image=restaurant.getString("featured_image");
                                Log.i("help",image);
                                Log.i("sssssssssss", namee);
                                food.add(new Resto_list(image, namee,add,latt,lonn));

                                resto_adapter adapter = new resto_adapter(Customer_it_is.this, food);
                                lv.setAdapter(adapter);
                            }
                            Log.d("list", food.toString());
                        }
                        catch(Exception e){
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
}