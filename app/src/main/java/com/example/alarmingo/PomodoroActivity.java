package com.example.alarmingo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;

public class PomodoroActivity extends AppCompatActivity {

    CountDownTimer timer;
    boolean timerRunning;
    boolean breakScreen;    //don't delete; unused for now... might come in handy later
    long timeLeft;
    Button PomoButton, PomoPauseButton, PomoStopButton;
    androidx.appcompat.widget.AppCompatButton TimerButt;

    Vibrator vibrator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pomodoro);

        vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

        Intent thisIntent = getIntent();
        timeLeft = thisIntent.getIntExtra("time", 0) * 1000L;
        breakScreen = thisIntent.getBooleanExtra("break", false);

        PomoButton = findViewById(R.id.pomoStartButton);
        PomoPauseButton = findViewById(R.id.pomoPauseButton);
        PomoStopButton = findViewById(R.id.pomoStopButton);

        TimerButt = findViewById(R.id.pomoTimer);
        updateTimer();

        PomoButton.setOnClickListener(view -> {
            StartTimer();
            PomoButton.setVisibility(View.INVISIBLE);
            PomoPauseButton.setVisibility(View.VISIBLE);
            PomoStopButton.setVisibility(View.VISIBLE);
        });

        PomoPauseButton.setOnClickListener(view -> {
            if (timerRunning) {
                PomoPauseButton.setText(R.string.resume);
                stopTimer();
            } else {
                PomoPauseButton.setText(R.string.pause);
                StartTimer();
            }
        });

        PomoStopButton.setOnClickListener(view -> {
            stopTimer();
            Intent nextIntent = new Intent(PomodoroActivity.this, PomodoroActivity.class);
            nextIntent.putExtra("time", 1500);
            nextIntent.putExtra("break", true);
            startActivity(nextIntent);
            finish();
        });

    }

    void StartTimer() {
        final CharSequence val = TimerButt.getText();
        String min = val.toString().substring(0, 2);
        String sec = val.toString().substring(3, 5);
        int num = Integer.parseInt(min) * 60 + Integer.parseInt(sec);
        timeLeft = num * 1000L;

        timer = new CountDownTimer(timeLeft, 1000) {
            @Override
            public void onTick(long l) {
                timeLeft = l;
                updateTimer();
            }

            @Override
            public void onFinish() {
                vibrator.vibrate(900);
                Intent nextIntent = new Intent(PomodoroActivity.this, PomodoroActivity.class);
                nextIntent.putExtra("time", 300);
                nextIntent.putExtra("break", true);
                startActivity(nextIntent);
                finish();
            }
        }.start();
        timerRunning = true;
    }

    void updateTimer() {
        int time = (int) (timeLeft/1000);
        int mins = (int) time / 60;
        int secs = (int) time % 60;
        String M = (mins < 10) ? ("0" + mins) : String.valueOf(mins);
        String S = (secs < 10) ? ("0" + secs) : String.valueOf(secs);
        String T = M + ":" + S;
        TimerButt.setText(T);
    }

    void stopTimer() {
        timer.cancel();
        timerRunning = false;
    }
}