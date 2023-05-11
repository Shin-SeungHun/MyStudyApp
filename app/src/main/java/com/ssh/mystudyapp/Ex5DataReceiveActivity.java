package com.ssh.mystudyapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Ex5DataReceiveActivity extends AppCompatActivity {
    TextView tvId, tvHp, tvIdStatic, tvHpStatic;
    Button btnSetter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex5_data_receive);



        tvId = (TextView) findViewById(R.id.tvId);
        tvHp = (TextView) findViewById(R.id.tvHp);
        tvIdStatic = (TextView) findViewById(R.id.tvIdStatic);
        tvHpStatic = (TextView) findViewById(R.id.tvHpStatic);
        btnSetter = (Button)findViewById(R.id.btnSetter);

        //전달받은 데이타 받기
        Intent getData = getIntent();
        String id = getData.getStringExtra("id");
        String hp = getData.getStringExtra("hp");
        tvId.setText(id);
        tvHp.setText(hp);


        //onCreate()메서드 안해서 단독형으로 클릭이벤트처리
        btnSetter.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                tvIdStatic.setText(Ex5DataActivity.id);
                tvHpStatic.setText(Ex5DataActivity.hp);
            }
        });
    }

}