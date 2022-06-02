package com.example.alarmingo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

public class Puzzle2 extends AppCompatActivity {

    int count = 0, currCount=0;
    Button Butt1, Butt2, Butt3, Butt4, Butt5, Butt6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puzzle2);

        new Handler().postDelayed(AlarmList::start_alarm_tone, 60000); //Alarm would start ringing again if the user doesn't respond within one minute

        int max = 12, min = 6;
        count = (int) (Math.random() * (max - min + 1) + min);

        Butt1 = findViewById(R.id.butt1);
        Butt2 = findViewById(R.id.butt2);
        Butt3 = findViewById(R.id.butt3);
        Butt4 = findViewById(R.id.butt4);
        Butt5 = findViewById(R.id.butt5);
        Butt6 = findViewById(R.id.butt6);

        Butt1.setOnClickListener(view -> {
            currCount++;
            CheckClickCount();
            Butt1.setVisibility(View.INVISIBLE);
            VisibleButt();
        });

        Butt2.setOnClickListener(view -> {
            currCount++;
            CheckClickCount();
            Butt2.setVisibility(View.INVISIBLE);
            VisibleButt();
        });

        Butt3.setOnClickListener(view -> {
            currCount++;
            CheckClickCount();
            Butt3.setVisibility(View.INVISIBLE);
            VisibleButt();
        });

        Butt4.setOnClickListener(view -> {
            currCount++;
            CheckClickCount();
            Butt4.setVisibility(View.INVISIBLE);
            VisibleButt();
        });

        Butt5.setOnClickListener(view -> {
            currCount++;
            CheckClickCount();
            Butt5.setVisibility(View.INVISIBLE);
            VisibleButt();
        });

        Butt6.setOnClickListener(view -> {
            currCount++;
            CheckClickCount();
            Butt6.setVisibility(View.INVISIBLE);
            VisibleButt();
        });

    }

    void VisibleButt(){
        int max = 6, min = 1;
        int val = (int) (Math.random() * (max - min + 1) + min);

        switch (val) {
            case 1:
                Butt1.setVisibility(View.VISIBLE);
                break;

            case 2:
                Butt2.setVisibility(View.VISIBLE);
                break;

            case 3:
                Butt3.setVisibility(View.VISIBLE);
                break;

            case 4:
                Butt4.setVisibility(View.VISIBLE);
                break;

            case 5:
                Butt5.setVisibility(View.VISIBLE);
                break;

            case 6:
                Butt6.setVisibility(View.VISIBLE);
                break;
        }
    }

    void CheckClickCount(){
        if(count == currCount){
            AlarmList.stop_alarm_tone();
            finish();
        }
    }
}