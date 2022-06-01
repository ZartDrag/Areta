package com.example.alarmingo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class WorkoutRest extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_rest);

        Button DoneButton = findViewById(R.id.rest_done_button);

        DoneButton.setOnClickListener(view ->finish());
    }
}