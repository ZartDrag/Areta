package com.example.alarmingo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class WorkoutCompleteScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_complete_screen);

        Button WorkoutCompleteButton = findViewById(R.id.workout_complete_button);
        WorkoutCompleteButton.setOnClickListener(view -> finish());
    }
}