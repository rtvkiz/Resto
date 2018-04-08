package com.example.android.resto;

import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.StrictMode;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;


import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by Ritvik Arya on 31-03-2018.
 */

public class resto_adapter extends ArrayAdapter<Resto_list> {
    View listItemView;
    Uri uri;
    String lon;
    String lat;

    public resto_adapter(Context context, ArrayList<Resto_list> food) {
        super(context, 0, food);

    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view
          listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.activity_customer_it_is, parent, false);
        }
        Resto_list food1 = getItem(position);
        TextView name = (TextView) listItemView.findViewById(R.id.name);
        name.setText(food1.getname());
        ImageView img = (ImageView) listItemView.findViewById(R.id.image);
        if(food1.getname()=="Red Rock") {

            img.setImageResource(R.drawable.redrock);
        }
        if(food1.getname().equals("Sadanand")) {

            img.setImageResource(R.drawable.sad);
        }
        if(food1.getname().equals("Chef's Restaurant")) {

            img.setImageResource(R.drawable.chef);
        }
        if(food1.getname().equals("Sun-City Fine Dine")) {

            img.setImageResource(R.drawable.sun);
        }
        if(food1.getname().equals("Hotel Sadanand")) {

            img.setImageResource(R.drawable.sad);
        }
        if(food1.getname().equals("Tikka Hut")) {

            img.setImageResource(R.drawable.tikka);
        }
        if(food1.getname().equals("Bourn Bon")) {

            img.setImageResource(R.drawable.sun);
        }
        if(food1.getname().equals("Ruchitha Panjabi Dhaba")) {
            img.setImageResource(R.drawable.sun);
        }
        if(food1.getname().equals("City Lunch Home")) {

            img.setImageResource(R.drawable.sun);
        }

        lon=food1.getlog();
        lat=food1.getlatt();





        //mIcon_val = BitmapFactory.decodeStream(food1.getimage().openConnection() .getInputStream());
       // img.setImageResource(food1.getimage());
        String url=food1.getimage();




        TextView add = (TextView) listItemView.findViewById(R.id.address);
        add.setText(food1.getadd());

        return listItemView;
    }





}


