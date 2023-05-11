package com.ssh.mystudyapp;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class Ex23TimerEx extends AppCompatActivity{
    int secondValue=0;//초
    int minValue=0;//분
    TextView mText;
    Handler mHandler;
    Button btnStart, btnEnd;

    //타이머 제어 변수
    boolean check =false;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex23_input_timer);

        mText=(TextView)findViewById(R.id.text);

        btnStart = (Button)findViewById(R.id.btnStart);
        btnEnd = (Button)findViewById(R.id.btnEnd);
        btnStart.setOnClickListener(mClickListener);
        btnEnd.setOnClickListener(mClickListener);

        mHandler = new Handler() {
            public void handleMessage(Message msg) {
                if(check==true) {
                    secondValue++;
                    if(secondValue>=60)
                    {
                        secondValue=0;
                        minValue++;
                    }
                    if(minValue==0) {
                        mText.setText("초 = " + secondValue);
                    }
                    else
                    {
                        mText.setText("분 = " + minValue+"/초 = " + secondValue);
                    }
                }
                mHandler.sendEmptyMessageDelayed(0, 1000);
                Log.d("타이머","진행중?");

            }
        };
        mHandler.sendEmptyMessage(0);
    }

    Button.OnClickListener mClickListener = new Button.OnClickListener() {
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btnStart:
                    check = true;
                    Log.d("타이머","테스트스타트");
                    break;
                case R.id.btnEnd:
                    check = false;
                    Log.d("타이머","테스트엔드");
                    break;
            }
        }
    };

}