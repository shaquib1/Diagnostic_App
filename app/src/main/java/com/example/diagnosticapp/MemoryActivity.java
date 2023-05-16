package com.example.diagnosticapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.widget.TextView;

import java.io.File;

public class MemoryActivity extends AppCompatActivity {

    private TextView memoryInfoTextView;
    private TextView systemStorageTextView;
    private TextView internalStorageTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_security);

        getSupportActionBar().setTitle("Memory Information");

        memoryInfoTextView = findViewById(R.id.memoryInfoTextView);
        systemStorageTextView = findViewById(R.id.systemStorageTextView);
        internalStorageTextView = findViewById(R.id.internalStorageTextView);

        // Get memory information
        String memoryInfo = getMemoryInfo();

        // Get system storage information
        String systemStorageInfo = getSystemStorageInfo();

        // Get internal storage information
        String internalStorageInfo = getInternalStorageInfo();

        // Display memory information
        memoryInfoTextView.setText(memoryInfo);

        // Display system storage information
        systemStorageTextView.setText(systemStorageInfo);

        // Display internal storage information
        internalStorageTextView.setText(internalStorageInfo);
    }

    private String getMemoryInfo() {
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ActivityManager activityManager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        if (activityManager != null) {
            activityManager.getMemoryInfo(memoryInfo);

            long totalMemory = memoryInfo.totalMem;
            long availableMemory = memoryInfo.availMem;
            boolean isLowMemory = memoryInfo.lowMemory;

            return "Total Memory: " + formatSize(totalMemory) + "\n"
                    + "Available Memory: " + formatSize(availableMemory) + "\n"
                    + "Low Memory: " + isLowMemory;
        }
        return "";
    }

    private String getSystemStorageInfo() {
        File root = Environment.getRootDirectory();
        long totalSpace = root.getTotalSpace();
        long freeSpace = root.getFreeSpace();

        return "Total System Storage: " + formatSize(totalSpace) + "\n" +
                "Free System Storage: " + formatSize(freeSpace);
    }

    private String getInternalStorageInfo() {
        File internalStorageDir = getFilesDir();
        long totalSpace = internalStorageDir.getTotalSpace();
        long freeSpace = internalStorageDir.getFreeSpace();

        return "Total Internal Storage: " + formatSize(totalSpace) + "\n" +
                "Free Internal Storage: " + formatSize(freeSpace);
    }

    private String formatSize(long size) {
        if (size <= 0) {
            return "0";
        }
        final String[] units = new String[]{"B", "KB", "MB", "GB", "TB"};
        int digitGroups = (int) (Math.log10(size) / Math.log10(1024));
        return String.format("%.1f %s", size / Math.pow(1024, digitGroups), units[digitGroups]);
    }
}