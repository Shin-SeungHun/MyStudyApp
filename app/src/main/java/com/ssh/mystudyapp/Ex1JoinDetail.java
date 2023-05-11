package com.ssh.mystudyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Ex1JoinDetail extends AppCompatActivity {

    TextView tvId, tvPw, tvName, tvHp, tvGender, tvAddress;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex1_join_detail);

        tvId = (TextView) findViewById(R.id.tvId);
        tvPw = (TextView) findViewById(R.id.tvPw);
        tvName = (TextView) findViewById(R.id.tvName);
        tvHp = (TextView) findViewById(R.id.tvHp);
        tvGender = (TextView) findViewById(R.id.tvGender);
        tvAddress = (TextView) findViewById(R.id.tvAddress);


        //전달받은 데이타 받기
        Intent getData = getIntent();
        String id = getData.getStringExtra("id");
        String pw = getData.getStringExtra("pw");
        String name = getData.getStringExtra("name");
        String hp = getData.getStringExtra("hp");
        String gender = getData.getStringExtra("gender");
        String address = getData.getStringExtra("address");

        tvId.setText(id);
        tvPw.setText(pw);
        tvName.setText(name);
        tvHp.setText(hp);
        tvGender.setText(gender);
        tvAddress.setText(address);
    }
}