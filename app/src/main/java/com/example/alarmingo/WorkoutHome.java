package com.example.alarmingo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class WorkoutHome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_home);

        Button Mon = findViewById(R.id.MonButt);
        Button Tue = findViewById(R.id.TueButt);
        Button Wed = findViewById(R.id.WedButt);
        Button Thu = findViewById(R.id.ThuButt);
        Button Fri = findViewById(R.id.FriButt);
        Button Sat = findViewById(R.id.SatButt);
        Button Sun = findViewById(R.id.SunButt);
        Button Str = findViewById(R.id.StrButt);

        Intent myIntent = new Intent(this, WorkoutList.class);

        Mon.setOnClickListener(v -> {
            myIntent.putExtra("day","MONDAY");
            startActivity(myIntent);
        });

        Tue.setOnClickListener(v -> {
            myIntent.putExtra("day","TUESDAY");
            startActivity(myIntent);
        });

        Wed.setOnClickListener(v -> {
            myIntent.putExtra("day","WEDNESDAY");
            startActivity(myIntent);
        });

        Thu.setOnClickListener(v -> {
            myIntent.putExtra("day","THURSDAY");
            startActivity(myIntent);
        });

        Fri.setOnClickListener(v -> {
            myIntent.putExtra("day","FRIDAY");
            startActivity(myIntent);
        });

        Sat.setOnClickListener(v -> {
            myIntent.putExtra("day","SATURDAY");
            startActivity(myIntent);
        });

        Sun.setOnClickListener(v -> {
            myIntent.putExtra("day","SUNDAY");
            startActivity(myIntent);
        });

        Str.setOnClickListener(v -> {
            myIntent.putExtra("day","STRETCHES");
            startActivity(myIntent);
        });
    }
}