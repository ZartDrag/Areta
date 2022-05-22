package com.example.alarmingo;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;

import java.time.LocalDate;

public class WorkoutHome extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.O)
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

        String WeekDay = LocalDate.now().getDayOfWeek().name();

        switch(WeekDay){
            case "MONDAY":
                Mon.setTextColor(Color.parseColor("#0CFF00"));
                break;

            case "TUESDAY":
                Tue.setTextColor(Color.parseColor("#0CFF00"));
                break;

            case "WEDNESDAY":
                Wed.setTextColor(Color.parseColor("#0CFF00"));
                break;

            case "THURSDAY":
                Thu.setTextColor(Color.parseColor("#0CFF00"));
                break;

            case "FRIDAY":
                Fri.setTextColor(Color.parseColor("#0CFF00"));
                break;

            case "SATURDAY":
                Sat.setTextColor(Color.parseColor("#0CFF00"));
                break;

            case "SUNDAY":
                Sun.setTextColor(Color.parseColor("#0CFF00"));
                break;

            case "STRETCHES" :
                Str.setTextColor(Color.parseColor("#0CFF00"));
                break;
            default:
                return;
        }

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