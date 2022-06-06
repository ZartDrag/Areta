package com.example.alarmingo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

public class WorkoutDeetsTime extends AppCompatActivity {

    CountDownTimer timer;
    boolean timerRunning;
    long timeLeft;
    TextView NameTextView, RepsTextView;
    Button PauseButton, SkipButton;
    int Pos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_deets_time);

        Intent myIntent = getIntent(); // gets the previously created intent

        NameTextView = findViewById(R.id.name_time);
        RepsTextView = findViewById(R.id.time);
        PauseButton = findViewById(R.id.time_pause_button);
        SkipButton = findViewById(R.id.time_skip_button);

        String Name = myIntent.getStringExtra("name");
        NameTextView.setText(Name);

        String Time = myIntent.getStringExtra("reps") + " seconds";

        RepsTextView.setText(Time);
        Pos = myIntent.getIntExtra("pos", 0);

        SkipButton.setOnClickListener(view -> {
            WorkoutList.callNextExercise(WorkoutList.WList.get(Pos+1),Pos+1,this);
            finish();
        });

        PauseButton.setOnClickListener(view -> {
            if(timerRunning) {
                stopTimer();
                PauseButton.setText(R.string.resume);
            } else {
                StartTimer();
                PauseButton.setText(R.string.pause);
            }
        });

        new Handler().postDelayed(this::StartTimer, 1000);
    }

    void StartTimer(){
        final CharSequence val = RepsTextView.getText();
        String num = val.toString().substring(0,2);
        timeLeft = Long.parseLong(num)* 1000;

        timer = new CountDownTimer(timeLeft, 1000) {
            @Override
            public void onTick(long l) {
                timeLeft = l;
                updateTimer();
            }

            @Override
            public void onFinish() {
                WorkoutList.callNextExercise(WorkoutList.WList.get(Pos+1),Pos+1,WorkoutDeetsTime.this);
                finish();
            }
        }.start();
        timerRunning=true;
    }

    void updateTimer(){
        int time = (int) timeLeft/1000;
        String T = time + " seconds";

        RepsTextView.setText(T);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    void stopTimer(){
        timer.cancel();
        timerRunning=false;
    }
}