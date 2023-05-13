package com.example.diagnosticapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Actionbar background color
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.teal_700)));

        // declear 12 button to go another activiy by click on imageView usnig internt and onclick()

        ImageView mainButton = (ImageView) findViewById(R.id.security);
        mainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecurityActivity.class);
                startActivity(intent);
            }
        });

        ImageView Camerabutton = (ImageView) findViewById(R.id.camera);
        Camerabutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CameraActivity.class);
                startActivity(intent);
            }
        });

        ImageView mainButton2 = (ImageView) findViewById(R.id.bluetooth);
        mainButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, BluetoothActivity.class);
                startActivity(intent);
            }
        });

        ImageView mainButton3 = (ImageView) findViewById(R.id.mobile_info);
        mainButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Mobile_infoActivity.class);
                startActivity(intent);
            }
        });

        ImageView mainButton4 = (ImageView) findViewById(R.id.wifi);
        mainButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, WifiActivity.class);
                startActivity(intent);
            }
        });

        ImageView mainButton5 = (ImageView) findViewById(R.id.signal);
        mainButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SignalActivity.class);
                startActivity(intent);
            }
        });

        ImageView mainButton6 = (ImageView) findViewById(R.id.battery);
        mainButton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, BatteryActivity.class);
                startActivity(intent);
            }
        });

        ImageView mainButton7 = (ImageView) findViewById(R.id.flashlight);
        mainButton7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FlashLightActivity.class);
                startActivity(intent);
            }
        });

        ImageView mainButton8 = (ImageView) findViewById(R.id.sound);
        mainButton8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SoundActivity.class);
                startActivity(intent);
            }
        });
        ImageView mainButton9 = (ImageView) findViewById(R.id.sensor);
        mainButton9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SensorActivity.class);
                startActivity(intent);
            }
        });
        ImageView mainButton10 = (ImageView) findViewById(R.id.notification);
        mainButton10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, NotificationActivity.class);
                startActivity(intent);
            }
        });
        ImageView mainButton11 = (ImageView) findViewById(R.id.cpu);
        mainButton11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CpuActivity.class);
                startActivity(intent);
            }
        });


        // to open camera using try catch block
        Camerabutton = (ImageView) findViewById(R.id.camera);
        Camerabutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });


    }

    // Add menu and search icon in navvar of app (or you can say in toolbar )

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.home_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            //open AppSettingActivity
            case R.id.setting:
                startActivity(new Intent(MainActivity.this, AppSettingActivity.class));
                break;

            //open AppShareActiviy
            case R.id.share:
                startActivity(new Intent(MainActivity.this, AppShareActivity.class));
                break;

            //open AppRemovesActiviy
            case R.id.removeAds:
                startActivity(new Intent(MainActivity.this, AppRemovesAddsActivity.class));
                break;

            //open AppContactsActiviy
            case R.id.contacts:
                startActivity(new Intent(MainActivity.this, AppContactsActivity.class));
                break;

            // open AboutAppActiviy
            case R.id.aboutApp:
                startActivity(new Intent(MainActivity.this, AboutAppActivity.class));
                break;


        }
        return super.onOptionsItemSelected(item);
    }
}



