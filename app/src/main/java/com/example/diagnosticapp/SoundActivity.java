package com.example.diagnosticapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.widget.SeekBar;

public class SoundActivity extends AppCompatActivity {

    private SeekBar ringVolumeSeekBar,
            musicVolumeSeekBar,
            alarmVolumeSeekBar,
            notificationVolumeSeekBar;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sound);

        getSupportActionBar().setTitle("Sound");

        ringVolumeSeekBar = findViewById(R.id.ring_volume_seekbar);
        musicVolumeSeekBar = findViewById(R.id.music_volume_seekbar);
        alarmVolumeSeekBar = findViewById(R.id.alarm_volume_seekbar);
        notificationVolumeSeekBar = findViewById(R.id.notification_volume_seekbar);

        AudioManager audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

        int maxRingVolume = audioManager.getStreamMaxVolume(AudioManager.STREAM_RING);
        int currentRingVolume = audioManager.getStreamVolume(AudioManager.STREAM_RING);
        ringVolumeSeekBar.setMax(maxRingVolume);
        ringVolumeSeekBar.setProgress(currentRingVolume);

        int maxMusicVolume = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        int currentMusicVolume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
        musicVolumeSeekBar.setMax(maxMusicVolume);
        musicVolumeSeekBar.setProgress(currentMusicVolume);

        int maxAlarmVolume = audioManager.getStreamMaxVolume(AudioManager.STREAM_ALARM);
        int currentAlarmVolume = audioManager.getStreamVolume(AudioManager.STREAM_ALARM);
        alarmVolumeSeekBar.setMax(maxAlarmVolume);
        alarmVolumeSeekBar.setProgress(currentAlarmVolume);

        int maxNotificationVolume = audioManager.getStreamMaxVolume(AudioManager.STREAM_NOTIFICATION);
        int currentNotificationVolume = audioManager.getStreamVolume(AudioManager.STREAM_NOTIFICATION);
        notificationVolumeSeekBar.setMax(maxNotificationVolume);
        notificationVolumeSeekBar.setProgress(currentNotificationVolume);

        ringVolumeSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                audioManager.setStreamVolume(AudioManager.STREAM_RING, progress, 0);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        musicVolumeSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, progress, 0);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        alarmVolumeSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                audioManager.setStreamVolume(AudioManager.STREAM_ALARM, progress, 0);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        notificationVolumeSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                audioManager.setStreamVolume(AudioManager.STREAM_NOTIFICATION, progress, 0);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
    }
}