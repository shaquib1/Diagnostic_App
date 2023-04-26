package com.example.diagnosticapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class SensorActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor);


        getSupportActionBar().setTitle("Sensor");


        // Get the SensorManager system service
        SensorManager sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        // Get a list of all available sensors
        List<Sensor> sensorList = sensorManager.getSensorList(Sensor.TYPE_ALL);

        // Display the list of sensors in a TextView
        TextView sensorTextView = findViewById(R.id.sensorTextView);
        for (Sensor sensor : sensorList) {
            sensorTextView.append(sensor.getName() + "\n");
        }
    }
}

