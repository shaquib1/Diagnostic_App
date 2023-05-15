package com.example.diagnosticapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;

import java.io.IOException;
import java.io.RandomAccessFile;

public class CpuActivity extends AppCompatActivity {

    private TextView cpuInfoTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cpu);

        getSupportActionBar().setTitle("CPU");

        cpuInfoTextView = findViewById(R.id.cpu_info_text_view);

        // Get CPU information
        String cpuInfo = "Processor: " + Build.PRODUCT + "\n";
        cpuInfo += "CPU Architecture: " + System.getProperty("os.arch") + "\n";
        cpuInfo += "CPU Type: " + Build.CPU_ABI + "\n";
        cpuInfo += "Cores: " + Runtime.getRuntime().availableProcessors() + "\n";
        cpuInfo += "Running CPU: " + Build.HARDWARE + "\n";
        cpuInfo += "CPU Frequency: " + getCpuFrequency() + " MHz";

        cpuInfoTextView.setText(cpuInfo);
    }

    private String getCpuFrequency() {
        String cpuFrequency = "";
        try {
            RandomAccessFile reader = new RandomAccessFile("/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq", "r");
            String line = reader.readLine();
            cpuFrequency = String.valueOf(Integer.parseInt(line) / 1000);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return cpuFrequency;
    }
}

