package com.example.mayur.doctor24_7;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SplashScreen extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        getSupportActionBar().hide();
        ImageView image = (ImageView)findViewById(R.id.imageView);
        Animation animation1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.blink);
        image.startAnimation(animation1);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(500);
                    Intent intent=new Intent(SplashScreen.this,Login.class);
                    startActivity(intent);
                    finish();
                } catch (InterruptedException e) {
                }
            }
        }).start();
    }
}