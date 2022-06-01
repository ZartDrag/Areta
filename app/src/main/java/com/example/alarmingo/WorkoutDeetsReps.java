package com.example.alarmingo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import java.util.NavigableMap;

public class WorkoutDeetsReps extends AppCompatActivity {
    Intent myIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_deets_reps);

        myIntent = getIntent(); // gets the previously created intent

        TextView NameTextView = findViewById(R.id.name_reps);
        TextView RepsTextView = findViewById(R.id.reps);
        Button DoneButton = findViewById(R.id.reps_done_button);

        String Name = myIntent.getStringExtra("name");
        NameTextView.setText(Name);

        String Reps = myIntent.getStringExtra("reps");
        String upReps = "X" + Reps;
        RepsTextView.setText(upReps);

        int Pos = myIntent.getIntExtra("pos", 0);

        DoneButton.setOnClickListener(view -> {
            WorkoutList.callNextExercise(WorkoutList.WList.get(Pos+1),Pos+1,this);  //Figure out how to pass the next workout!!!!
            finish();
        });


//        Log.i("2", myIntent.getStringExtra("name"));
//        Log.i("4", myIntent.getStringExtra("reps"));

    }
}