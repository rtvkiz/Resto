package com.example.android.resto;

/**
 * Created by Ritvik Arya on 31-03-2018.
 */

public class Resto_list {
    private String image;
    private String name;
    private String address;
    private String lonn;
    private String latt;

    public Resto_list(String img,String name,String add,String lat,String lon){
        this.image=img;
        this.name=name;
        this.address=add;
        this.lonn=lon;
        this.latt=lat;
    }
    public String getimage(){
        return this.image;
    }
    public String getname(){
        return this.name;

    }
    public String getadd(){
        return  this.address;
    }
    public String getlog(){
        return this.lonn;
    }
    public String getlatt(){return  this.latt;}
}
