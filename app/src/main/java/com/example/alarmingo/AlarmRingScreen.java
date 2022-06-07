package com.example.alarmingo;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class AlarmRingScreen extends AppCompatActivity {
    static final int ALARM_REQ_CODE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alarm_ring_screen);

        int snoozeDuration = 300000; //in milliseconds

        Button SnoozeButton = findViewById(R.id.SnoozeButton);

        SnoozeButton.setOnClickListener(v -> {
            AlarmList.stop_alarm_tone();

            AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
            Intent intent = new Intent(AlarmRingScreen.this, Puzzle1.class);
            @SuppressLint("UnspecifiedImmutableFlag") PendingIntent pendingIntent = PendingIntent.getBroadcast(AlarmRingScreen.this, ALARM_REQ_CODE, intent, PendingIntent.FLAG_UPDATE_CURRENT);
            alarmManager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP, snoozeDuration, pendingIntent );

            String message = "Alarm snoozed for " + snoozeDuration/60000 + " minutes"; //FIX THIS!!
            Toast.makeText(AlarmRingScreen.this, message, Toast.LENGTH_LONG).show();

            finish();
        });


        Button DismissButton = findViewById(R.id.DismissButton);
        DismissButton.setOnClickListener(v -> {
            AlarmList.stop_alarm_tone();

            int max = 2, min = 1;
            int val = (int) (Math.random() * (max - min + 1) + min);

            Intent myintent;

            switch(val){
                case 1:
                    myintent = new Intent(AlarmRingScreen.this, Puzzle1.class);
                    break;

                case 2:
                    myintent = new Intent(AlarmRingScreen.this, Puzzle2.class);
                    break;

                default:
                    myintent=null;
            }

            startActivity(myintent);
            finish();
        });
    }
}