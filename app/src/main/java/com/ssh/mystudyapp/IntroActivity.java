package com.ssh.mystudyapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class IntroActivity extends AppCompatActivity {

    Animation ani1;
    ImageView ivIntro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro); //xml , java 소스 연결


        ani1 = AnimationUtils.loadAnimation(IntroActivity.this, R.anim.scale);
        ivIntro = (ImageView) findViewById(R.id.ivIntro);
        ivIntro.startAnimation(ani1);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent); //인트로 실행 후 바로 MainActivity로 넘어감.
                finish();
            }
        }, 1000); //3초 후 인트로 실행

    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}

