package com.example.diagnosticapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.TextView;


public class BatteryActivity extends AppCompatActivity {

     BroadcastReceiver batteryBroadcast;
     IntentFilter intentFilter;

    TextView level, voltage, health, batteryType, chargingSource, temperature, chargingStatus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battery);

        // to change action bar of activity
        getSupportActionBar().setTitle("Battery Information");


        level=findViewById(R.id.textLevel);
        voltage=findViewById(R.id.textVoltage);
        health=findViewById(R.id.textHealth);
        batteryType=findViewById(R.id.textType);
        chargingSource=findViewById(R.id.textChargingSource);
        temperature=findViewById(R.id.textTemperature);
        chargingStatus=findViewById(R.id.textChargingStatus);


        IntentFilterAndBroadcast();
    }

    private void IntentFilterAndBroadcast() {

        intentFilter= new IntentFilter();
        intentFilter.addAction(Intent.ACTION_BATTERY_CHANGED);
        batteryBroadcast=new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                if(Intent.ACTION_BATTERY_CHANGED.equals(intent.getAction()))
                {
                  level.setText(String.valueOf(intent.getIntExtra("level",0))+"%");

                    float voltTemp= (float) (intent.getIntExtra("voltage",0)*0.001);
                    voltage.setText(voltTemp+ "V");
                }
            }
        };
    }

    @Override
    protected void onStart() {
        super.onStart();
        registerReceiver(batteryBroadcast,intentFilter);
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(batteryBroadcast);
    }
}