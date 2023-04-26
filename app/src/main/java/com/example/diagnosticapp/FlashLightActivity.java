package com.example.diagnosticapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FlashLightActivity extends AppCompatActivity {



    private CameraManager cameraManager;
    private String cameraId;
    private Button onButton, offButton;

    public FlashLightActivity() {
    }


    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flash_light);

        // to change action bar of activity
        getSupportActionBar().setTitle("FlashLight");


        // Initialize CameraManager and cameraId
        cameraManager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);
        try {
            cameraId = cameraManager.getCameraIdList()[0];
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }

        // Initialize on and off buttons
        onButton = findViewById(R.id.on_button);
        offButton = findViewById(R.id.off_button);

        // Set on button click listener
        onButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    cameraManager.setTorchMode(cameraId, true);
                } catch (CameraAccessException e) {
                    e.printStackTrace();
                }
            }
        });

        // Set off button click listener
        offButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    cameraManager.setTorchMode(cameraId, false);
                } catch (CameraAccessException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}

