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
        Button PauseButton = findViewById(R.id.time_pause_button);
        Button SkipButton = findViewById(R.id.time_skip_button);

        String Name = myIntent.getStringExtra("name");
        NameTextView.setText(Name);

        String Time = myIntent.getStringExtra("reps") + " seconds";

        RepsTextView.setText(Time);

        int Pos = myIntent.getIntExtra("pos", 0);

        SkipButton.setOnClickListener(view -> {
            WorkoutList.callNextExercise(WorkoutList.WList.get(Pos+1),Pos+1,this);
            finish();
        });

        PauseButton.setOnClickListener(view -> {

        });
    }
}