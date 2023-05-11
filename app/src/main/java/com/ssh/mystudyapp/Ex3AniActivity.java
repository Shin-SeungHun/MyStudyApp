package com.ssh.mystudyapp;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class Ex3AniActivity extends AppCompatActivity {
    ImageView ivMain;
    Animation ani1, ani2, ani3, ani4, ani5, ani6, ani7, ani8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex3_ani);
        ivMain = (ImageView) findViewById(R.id.ivMain);

        ani1 = AnimationUtils.loadAnimation(this, R.anim.alpha);
        ani2 = AnimationUtils.loadAnimation(this, R.anim.scale);
        ani3 = AnimationUtils.loadAnimation(this, R.anim.translate);
        ani4 = AnimationUtils.loadAnimation(this, R.anim.rotate);
        ani5 = AnimationUtils.loadAnimation(this, R.anim.set);
        ani6 = AnimationUtils.loadAnimation(this, R.anim.set1);
        ani7 = AnimationUtils.loadAnimation(this, R.anim.set2);

        findViewById(R.id.btnAni1).setOnClickListener(mClickListener);
        findViewById(R.id.btnAni2).setOnClickListener(mClickListener);
        findViewById(R.id.btnAni3).setOnClickListener(mClickListener);
        findViewById(R.id.btnAni4).setOnClickListener(mClickListener);
        findViewById(R.id.btnAni5).setOnClickListener(mClickListener);
        findViewById(R.id.btnAni6).setOnClickListener(mClickListener);
        findViewById(R.id.btnAni7).setOnClickListener(mClickListener);
        findViewById(R.id.btnAni8).setOnClickListener(mClickListener);


    }

    Button.OnClickListener mClickListener = new Button.OnClickListener() {
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btnAni1:
                    ivMain.startAnimation(ani1);
                    break;
                case R.id.btnAni2:
                    ivMain.startAnimation(ani2);
                    break;
                case R.id.btnAni3:
                    ivMain.startAnimation(ani3);
                    break;
                case R.id.btnAni4:
                    ivMain.startAnimation(ani4);
                    break;
                case R.id.btnAni5:
                    ivMain.startAnimation(ani5);
                    break;
                case R.id.btnAni6:
                    ivMain.startAnimation(ani6);
                    break;
                case R.id.btnAni7:
                    ivMain.startAnimation(ani7);
                    break;
                case R.id.btnAni8:
                    ivMain.startAnimation(ani8);
                    break;


            }
        }
    };
}