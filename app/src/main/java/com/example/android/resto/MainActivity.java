package com.example.android.resto;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;


import com.firebase.ui.auth.AuthUI;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth mfirebase;
    private FirebaseAuth.AuthStateListener mlistener;
    public static final int RC_SIGN_IN=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mfirebase=FirebaseAuth.getInstance();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (ContextCompat.checkSelfPermission(getApplicationContext(), android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getApplicationContext(), android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION, android.Manifest.permission.ACCESS_COARSE_LOCATION}, 101);

            //task = new TsunamiAsyncTask();
            //task.execute()
        }
        mlistener=new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user=firebaseAuth.getCurrentUser();
                if(user != null){
                    String name=user.getDisplayName();
                    Toast.makeText(MainActivity.this,name,Toast.LENGTH_LONG).show();
                }
                else{
                    startActivityForResult(
                            AuthUI.getInstance()
                                    .createSignInIntentBuilder()
                                    .setIsSmartLockEnabled(false)
                                    .setAvailableProviders(Arrays.asList(
                                            new AuthUI.IdpConfig.EmailBuilder().build(),

                                            new AuthUI.IdpConfig.GoogleBuilder().build()


                                    ))
                                    .build(),
                            RC_SIGN_IN);
                }

            }
        };
    }
    public void owner(View v){
        Intent i=new Intent(this,Owner_it_is.class);
        startActivity(i);
    }
    public void customer(View v){
        Intent i=new Intent(this,Customer_it_is.class);
        startActivity(i);
    }
    public void loc(View v){
        Intent i =new Intent(this,Getlocation.class);
        startActivity(i);
    }
    @Override
    protected void onResume() {
        super.onResume();
        mfirebase.addAuthStateListener(mlistener);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mfirebase.removeAuthStateListener(mlistener);
    }
    public void signout(){
        AuthUI.getInstance().signOut(this);
        return;
    }


}
