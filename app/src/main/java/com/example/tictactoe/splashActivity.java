package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

@SuppressLint("CustomSplashScreen")
public class splashActivity extends AppCompatActivity {

    LottieAnimationView laView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

//        laView.findViewById(R.id.laView);
//        laView.setAnimation(R.raw.lottie);
//        laView.playAnimation();

//        TextView splash = findViewById(R.id.splash);
//        Animation anim = AnimationUtils.loadAnimation(this, R.anim.move);
//        splash.startAnimation(anim);

        new Handler().postDelayed(() -> {
            Intent iSplash = new Intent(splashActivity.this, firstActivity.class);
            startActivity(iSplash);
            finish();
        }, 1500);
    }
}