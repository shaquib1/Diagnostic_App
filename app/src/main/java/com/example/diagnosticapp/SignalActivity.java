package com.example.diagnosticapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import android.widget.TextView;

public class SignalActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.P)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signal);

        getSupportActionBar().setTitle("Signal");


        TelephonyManager telephonyManager = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        SignalStrength signalStrength = telephonyManager.getSignalStrength();
        int signalStrengthValue = ((SignalStrength) signalStrength).getLevel();

        TextView signalStrengthTextView = findViewById(R.id.signal_strength_text_view);
        signalStrengthTextView.setText("Signal Strength: " + signalStrengthValue);
    }
}