package com.example.diagnosticapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class AboutAppActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_app);


        // to change action bar of activity
        getSupportActionBar().setTitle("About App");
    }
}