package com.example.diagnosticapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class BluetoothActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bluetooth);

        // to change action bar of activity
        getSupportActionBar().setTitle("Bluetooth");
    }
}