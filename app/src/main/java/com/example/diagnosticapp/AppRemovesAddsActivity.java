package com.example.diagnosticapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class AppRemovesAddsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_removes_adds);

        // to change action bar of activity
        getSupportActionBar().setTitle("Removes Adds");
    }
}