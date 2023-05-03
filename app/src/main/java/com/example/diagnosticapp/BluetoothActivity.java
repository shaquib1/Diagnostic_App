package com.example.diagnosticapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Set;

public class BluetoothActivity extends AppCompatActivity {


    private static final int REQUEST_ENABLE_BT = 0;
    private static final int REQUEST_DISCOVER_BT = 1;

    private TextView mStatusBleTv, mPairedTv;
    ImageView mBlueIV;
    Button mOnBtn, mOffBtn, mDiscoverBtn, mPairedBtn;
    BluetoothAdapter bluetoothAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bluetooth);

        // to change action bar of activity
        getSupportActionBar().setTitle("Bluetooth");

        mStatusBleTv = findViewById(R.id.statusBluetoothTv);
        mPairedTv = findViewById(R.id.pairTv);
        mBlueIV = findViewById(R.id.bluetoothIv);
        mOnBtn = findViewById(R.id.onButn);
        mOffBtn = findViewById(R.id.offButn);
        mDiscoverBtn = findViewById(R.id.discoverableBtn);
        mPairedBtn = findViewById(R.id.PairedBtn);

        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

        if (bluetoothAdapter == null) {
            mStatusBleTv.setText("Bluetooth is not available");
        } else {
            mStatusBleTv.setText("Bluetooth is  available");


            if (bluetoothAdapter.isEnabled()) {
                mBlueIV.setImageResource(R.drawable.bluetooth_on);
            } else {
                mBlueIV.setImageResource(R.drawable.bluetooth_off);

            }


           mOnBtn.setOnClickListener(new View.OnClickListener() {
               @SuppressLint("MissingPermission")
               @Override
               public void onClick(View v) {
                  if (bluetoothAdapter.isEnabled()){
                      showToast("Turning on Bluetooth..");
                      Intent intent=new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                      startActivityForResult(intent,REQUEST_ENABLE_BT);
                  }else {
                      showToast("Bluetooth is already on");
                  }
               }
           });

           mDiscoverBtn.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                 if (!bluetoothAdapter.isDiscovering()) {
                     showToast("Making Your Device Discoverable");
                     Intent intent=new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
                     startActivityForResult(intent,REQUEST_DISCOVER_BT);
                 }
               }
           });


           mOffBtn.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   if (bluetoothAdapter.isEnabled()){
                       bluetoothAdapter.disable();
                       showToast("Turning Bluetooth off");
                       mBlueIV.setImageResource(R.drawable.bluetooth_off);
                   }else {
                       showToast("Bluetooth is already off");
                   }
               }
           });

          mPairedBtn.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  if (bluetoothAdapter.isEnabled()){
                      mPairedBtn.setText("Paired Device");
                      Set<BluetoothDevice> devices=bluetoothAdapter.getBondedDevices();

                      for (BluetoothDevice device :devices){
                          mPairedBtn.append("\n Device : " + device.getName() + ", " + device);

                      }
                  } else {
                      showToast("Turn on bluetooth to get paired devices");
                  }
              }
          });
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        switch (requestCode) {
            case REQUEST_ENABLE_BT:
                if (resultCode == RESULT_OK) {
                    mBlueIV.setImageResource(R.drawable.bluetooth_on);
                    showToast("Bluetooth is On");
                } else {
                    showToast("Bluetooth is Off");

                }
                break;
        }
        super.onActivityResult(requestCode, resultCode, data);

    }

    private void showToast(String msg) {
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
    }
}

