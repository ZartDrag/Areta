package com.example.alarmingo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        Button AlarmButton = findViewById(R.id.GotoAlarm);
        AlarmButton.setOnClickListener(v -> {
            Intent myintent = new Intent(HomeScreen.this, AlarmList.class);
            startActivity(myintent);
        });

        Button WorkoutButton = findViewById(R.id.GotoWorkout);
        WorkoutButton.setOnClickListener(v->{
            Intent myintent = new Intent(HomeScreen.this, WorkoutHome.class);
            startActivity(myintent);
        });

        Button PomodoroButton = findViewById(R.id.GotoPomo);
        PomodoroButton.setOnClickListener(v -> {
            Intent myintent = new Intent(HomeScreen.this, PomodoroActivity.class);
            myintent.putExtra("time", 1500);
            myintent.putExtra("break", false);
            startActivity(myintent);
        });
    }
}