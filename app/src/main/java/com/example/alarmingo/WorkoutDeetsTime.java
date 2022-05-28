package com.example.alarmingo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class WorkoutDeetsTime extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_deets_time);

        Intent myIntent = getIntent(); // gets the previously created intent

        TextView NameTextView = findViewById(R.id.name_time);
        TextView RepsTextView = findViewById(R.id.time);
        Button DoneButton = findViewById(R.id.time_done_button);

        NameTextView.setText(myIntent.getStringExtra("name"));

        String Time = myIntent.getStringExtra("reps") + "seconds";

        RepsTextView.setText(Time);

        DoneButton.setOnClickListener(view -> {

        });
    }
}