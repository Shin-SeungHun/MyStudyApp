package com.ssh.mystudyapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Ex1LoginActivity extends AppCompatActivity {
    EditText etId, etPw;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex1_login);
        //id연동
        etId = (EditText) findViewById(R.id.etId);
        etPw = (EditText) findViewById(R.id.etPw);
        findViewById(R.id.btnLogin).setOnClickListener(mClickListener);
        findViewById(R.id.btnJoin).setOnClickListener(mClickListener);
    }

    //버튼이벤트를 감지함...
    Button.OnClickListener mClickListener = new Button.OnClickListener() {
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btnLogin:
                    dataTest1();
                    break;
                case R.id.btnJoin:
                    dataTest2();
                    break;
            }
        }
    };

    void dataTest1() {
        String id = etId.getText().toString();
        String pw = etPw.getText().toString();
        Toast.makeText(Ex1LoginActivity.this,
                "아이디:" + id + " / 비번:" + pw,
                Toast.LENGTH_SHORT).show();

    }

    void dataTest2() {
//        String id = etId.getText().toString();
//        String pw = etPw.getText().toString();
//        Log.d("로그인화면","아이디:"+id+" / 비번:"+pw);

        Intent intent1 =
                new Intent(Ex1LoginActivity.this, Ex1JoinActivity.class);
        startActivity(intent1);
    }


}