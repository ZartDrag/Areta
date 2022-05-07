package com.example.alarmingo;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Puzzle1 extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puzzle1);

        EditText InputText = findViewById(R.id.input_text);
        InputText.setInputType(InputType.TYPE_CLASS_NUMBER);

        int num1,num2,max = 49,min=0, ans;
        boolean sign;

        num1 = (int) (Math.random() * (max - min + 1) + min);
        num2 = (int) (Math.random() * (max - min + 1) + min);
        sign = ((int) (Math.random() * 2 + 1)) == 1;

        if(num1<num2){
            int temp = num1;
            num1 = num2;
            num2 = temp;
        }

        TextView Num1 = findViewById(R.id.num_1);
        TextView Num2 = findViewById(R.id.num_2);
        TextView Sign = findViewById(R.id.sign);

        Num1.setText(Integer.toString(num1));
        Num2.setText(Integer.toString(num2));

        if(sign){
            Sign.setText("+");
            ans = num1+num2;
        } else {
            Sign.setText("-");
            ans = num1-num2;
        }

        Button EnterButton = findViewById(R.id.enter_button);
        EnterButton.setOnClickListener( v -> {
            String result = InputText.getText().toString();
            if(result.equals(Integer.toString(ans))){
                Toast.makeText(Puzzle1.this, "Correct!", Toast.LENGTH_SHORT).show();
                AlarmList.stop_alarm_tone();
                finish();
            } else {
                Toast.makeText(Puzzle1.this, "Incorrect!!", Toast.LENGTH_LONG).show();
                AlarmList.start_alarm_tone();
            }
        });
    }
}