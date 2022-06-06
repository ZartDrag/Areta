package com.example.alarmingo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.Button;

public class PomodoroActivity extends AppCompatActivity {

    CountDownTimer timer;
    boolean timerRunning;
    long timeLeft;
    Button PomoButton;
    androidx.appcompat.widget.AppCompatButton TimerButt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pomodoro);

        Intent thisIntent = getIntent();
        timeLeft = thisIntent.getIntExtra("time",0);

        PomoButton = findViewById(R.id.pomoStartButton);
        TimerButt = findViewById(R.id.pomoTimer);

        //Set Time Format

    }

//    void StartTimer(){
//        final CharSequence val = RepsTextView.getText();
//        String num = val.toString().substring(0,2);
//        timeLeft = Long.parseLong(num)* 1000;
//
//        timer = new CountDownTimer(timeLeft, 1000) {
//            @Override
//            public void onTick(long l) {
//                timeLeft = l;
//                updateTimer();
//            }
//
//            @Override
//            public void onFinish() {
//                WorkoutList.callNextExercise(WorkoutList.WList.get(Pos+1),Pos+1,WorkoutDeetsTime.this);
//                finish();
//            }
//        }.start();
//        timerRunning=true;
//    }

    void updateTimer(){
        int time = (int) timeLeft/1000;
        String T = time + " seconds";   //Fix Time Format

        TimerButt.setText(T);
    }

    void stopTimer(){
        timer.cancel();
        timerRunning=false;
    }
}