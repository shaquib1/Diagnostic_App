package com.example.diagnosticapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import android.widget.TextView;

public class NetworkActivity extends AppCompatActivity {

    private TextView textView;

    @RequiresApi(api = Build.VERSION_CODES.R)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signal);

        getSupportActionBar().setTitle("Network");


        textView = findViewById(R.id.textView);

        // Get network information
        ConnectivityManager connectivityManager = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = connectivityManager.getActiveNetworkInfo();

        if (activeNetwork != null) {
            // Get network type
            String networkType = activeNetwork.getTypeName();

            // Check if connected
            boolean isConnected = activeNetwork.isConnected();

            // Get IP address
            String ipAddress = getIPAddress();

            // Get gateway
            String gateway = getGateway();

            // Get link speed
            int linkSpeed = getLinkSpeed();



            // Display the information
            textView.setText("Network Type: " + networkType +
                    "\nConnected: " + isConnected +
                    "\nIP Address: " + ipAddress +
                    "\nGateway: " + gateway +
                    "\nLink Speed: " + linkSpeed + " Mbps" );
        } else {
            textView.setText("No active network connection.");
        }
    }

    // Get the IP address of the device
    private String getIPAddress() {
        WifiManager wifiManager = (WifiManager)
                getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        WifiInfo wifiInfo = wifiManager.getConnectionInfo();
        int ipAddress = wifiInfo.getIpAddress();
        return String.format("%d.%d.%d.%d",
                (ipAddress & 0xff), (ipAddress >> 8 & 0xff),
                (ipAddress >> 16 & 0xff), (ipAddress >> 24 & 0xff));
    }

    // Get the gateway address
    private String getGateway() {
        WifiManager wifiManager = (WifiManager)
                getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        WifiInfo wifiInfo = wifiManager.getConnectionInfo();
        int gatewayIP = wifiManager.getDhcpInfo().gateway;
        return String.format("%d.%d.%d.%d",
                (gatewayIP & 0xff), (gatewayIP >> 8 & 0xff),
                (gatewayIP >> 16 & 0xff), (gatewayIP >> 24 & 0xff));
    }

    // Get the link speed in Mbps
    private int getLinkSpeed() {
        WifiManager wifiManager = (WifiManager)
                getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        WifiInfo wifiInfo = wifiManager.getConnectionInfo();
        return wifiInfo.getLinkSpeed();
    }


}

