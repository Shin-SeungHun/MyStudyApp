package com.ssh.mystudyapp;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Ex13HandlerActivity extends AppCompatActivity {

    //애니메이션 클래스변수 (효과별)
    Animation ani1, ani2, ani3;

    //애니메이션 효과를 줄 대상 버튼 선언
    Button btnLogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex13_handler);

        btnLogo = (Button) findViewById(R.id.btnLogo);

        findViewById(R.id.btnAct1).setOnClickListener(mClick);
        findViewById(R.id.btnAct2).setOnClickListener(mClick);
        findViewById(R.id.btnAct3).setOnClickListener(mClick);

        //각 애니메이션 변수에 설정값 셋팅
        ani1 = AnimationUtils.loadAnimation(Ex13HandlerActivity.this, R.anim.translate);
        ani2 = AnimationUtils.loadAnimation(Ex13HandlerActivity.this, R.anim.translate);
        ani3 = AnimationUtils.loadAnimation(Ex13HandlerActivity.this, R.anim.translate);


    }

    View.OnClickListener mClick = new View.OnClickListener() {
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btnAct1:
                    //이벤트 핸들러를 통해서 몇초후의 동작을 시킴...
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            btnLogo.startAnimation(ani1);
                        }
                    }, 1000); //1초 후 인트로 실행

                    break;
                case R.id.btnAct2:
                    //이벤트 핸들러를 통해서 몇초후의 동작을 시킴...
                    Handler handler2 = new Handler();
                    handler2.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            btnLogo.startAnimation(ani2);
                        }
                    }, 2000); //2초 후 인트로 실행

                    break;
                case R.id.btnAct3:
                    //이벤트 핸들러를 통해서 몇초후의 동작을 시킴...
                    Handler handler3 = new Handler();
                    handler3.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            btnLogo.startAnimation(ani3);
                        }
                    }, 3000); //3초 후 인트로 실행
                    break;

            }

        }
    };
}