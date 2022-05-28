package com.example.alarmingo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import java.util.NavigableMap;

public class WorkoutDeetsReps extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_deets_reps);

        Intent myIntent = getIntent(); // gets the previously created intent

        TextView NameTextView = findViewById(R.id.name_reps);
        TextView RepsTextView = findViewById(R.id.reps);
        Button DoneButton = findViewById(R.id.reps_done_button);

        NameTextView.setText(myIntent.getStringExtra("name"));

        String Reps = "X" + myIntent.getStringExtra("reps");

        RepsTextView.setText(Reps);

        DoneButton.setOnClickListener(view -> {

        });


//        Log.i("2", myIntent.getStringExtra("name"));
//        Log.i("4", myIntent.getStringExtra("reps"));

    }
}