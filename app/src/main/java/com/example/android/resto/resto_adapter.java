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
        final String lon=food1.getlog();
        String lat=food1.getlatt();
        double latitude = Double.parseDouble(lat);
        double longitude = Double.parseDouble(lon);
        String label = "Restaurant";
        String uriBegin = "geo:" + latitude + "," + longitude;
        String query = latitude + "," + longitude + "(" + label + ")";
        String encodedQuery = Uri.encode(query);
        String uriString = uriBegin + "?q=" + encodedQuery + "&z=16";
        uri = Uri.parse(uriString);


        try{
        Glide.with(getContext()).load(food1.getimage()).into(img);}
        catch(Exception e){
            Log.i("ggg",e.toString());
        }
        //mIcon_val = BitmapFactory.decodeStream(food1.getimage().openConnection() .getInputStream());
       // img.setImageResource(food1.getimage());
        String url=food1.getimage();




        TextView add = (TextView) listItemView.findViewById(R.id.address);
        add.setText(food1.getadd());

        return listItemView;
    }





}


