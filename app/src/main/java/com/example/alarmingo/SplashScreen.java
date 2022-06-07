package com.example.alarmingo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

@SuppressLint("CustomSplashScreen")
public class SplashScreen extends AppCompatActivity {

    Animation up, down;
    CardView logoImage;
    TextView AretaName, AretaCaption;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        logoImage = findViewById(R.id.logo);
        AretaName = findViewById(R.id.areta_name);
        AretaCaption = findViewById(R.id.areta_caption);

        up = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.up);
        logoImage.setAnimation(up);

        down = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.down);
        AretaCaption.setAnimation(down);

        new Handler().postDelayed(() -> {
            startActivity(new Intent(getApplicationContext(), HomeScreen.class));
            finish();
        }, 4500);

    }
}