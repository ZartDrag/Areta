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
            Intent myintent = new Intent(HomeScreen.this, WorkoutList.class);
            startActivity(myintent);
        });
    }
}