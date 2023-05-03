package com.example.diagnosticapp;


import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.StatFs;

import android.util.DisplayMetrics;
import android.widget.TextView;

import java.io.File;
import java.text.DecimalFormat;

public class Mobile_infoActivity extends AppCompatActivity {

    private TextView tvDeviceName, tvDeviceModel, tvAndroidVersion, tvScreenSize, tvScreenResolution, tvBatteryLevel, tvCpuInfo, tvRamInfo, tvStorageInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mobile_info);

        // to change action bar of activity
        getSupportActionBar().setTitle("Mobile Information");

        tvDeviceName = findViewById(R.id.tv_device_name);
        tvDeviceModel = findViewById(R.id.tv_device_model);
        tvAndroidVersion = findViewById(R.id.tv_android_version);
        tvScreenSize = findViewById(R.id.tv_screen_size);
        tvScreenResolution = findViewById(R.id.tv_screen_resolution);
        tvBatteryLevel = findViewById(R.id.tv_battery_level);
        tvCpuInfo = findViewById(R.id.tv_cpu_info);
        tvRamInfo = findViewById(R.id.tv_ram_info);
        tvStorageInfo = findViewById(R.id.tv_storage_info);

        // Get device name and model
        String deviceName = Build.MANUFACTURER + " " + Build.MODEL;
        tvDeviceName.setText("Device Name: " + deviceName);

        String deviceModel = Build.DEVICE;
        tvDeviceModel.setText("Device Model: " + deviceModel);

        // Get Android version
        String androidVersion = Build.VERSION.RELEASE;
        tvAndroidVersion.setText("Android Version: " + androidVersion);

        // Get screen size and resolution
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        float density = getResources().getDisplayMetrics().density;
        int screenWidth = metrics.widthPixels;
        int screenHeight = metrics.heightPixels;
        tvScreenSize.setText("Screen Size: " + screenWidth / density + " x " + screenHeight / density + " inches");
        tvScreenResolution.setText("Screen Resolution: " + screenWidth + " x " + screenHeight);

        // Get battery level
        Intent batteryIntent = registerReceiver(null, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
        int level = batteryIntent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
        int scale = batteryIntent.getIntExtra(BatteryManager.EXTRA_SCALE, -1);
        float batteryPct = level / (float) scale * 100;
        tvBatteryLevel.setText("Battery Level: " + new DecimalFormat("##.#").format(batteryPct) + "%");

        // Get CPU info
        String cpuInfo = Build.HARDWARE + ", " + Build.BOARD + ", " + Build.CPU_ABI;
        tvCpuInfo.setText("CPU Info: " + cpuInfo);

        // Get RAM info
        long totalMemory = Runtime.getRuntime().totalMemory() / (1024 * 1024);
        long freeMemory = Runtime.getRuntime().freeMemory() / (1024 * 1024);
        long usedMemory = totalMemory - freeMemory;
        tvRamInfo.setText("RAM Info: " + usedMemory + " MB used out of " + totalMemory + " MB total");

        // Get storage info
        String externalStorageState = Environment.getExternalStorageState();
        if (externalStorageState.equals(Environment.MEDIA_MOUNTED)) {
            File path = Environment.getExternalStorageDirectory();
            StatFs stat = new StatFs(path.getPath());
            long blockSize = stat.getBlockSizeLong();
            long totalBlocks = stat.getBlockCountLong();
 }
}
}
