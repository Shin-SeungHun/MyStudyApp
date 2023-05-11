package com.ssh.mystudyapp;

import static com.ssh.mystudyapp.R.id.tvAddress;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Ex1JoinActivity extends AppCompatActivity {

    TextView textView;

    public static String id, pw, name, hp, gender = "남자", address = "서울";
    EditText etId, etPw, etName, etHp;

    TextView tvGender;
    Switch switchView;

    String[] items = {"서울", "대전", "세종", "부산", "대구", "충남", "경기", "충북", "강원", "광주", "인천", "제주"};

    String temp = "";//스피너 선택값 저장변수

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex1_join);

        etId = (EditText) findViewById(R.id.etId);
        etPw = (EditText) findViewById(R.id.etPw);
        etName = (EditText) findViewById(R.id.etName);
        etHp = (EditText) findViewById(R.id.etHp);
        switchView = findViewById(R.id.switchView);
        tvGender = (TextView) findViewById(R.id.tvGender);


        findViewById(R.id.btnIdCheck).setOnClickListener(mClickListener);
        findViewById(R.id.btnJoin).setOnClickListener(mClickListener);
        findViewById(R.id.btnCancel).setOnClickListener(mClickListener);

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, items
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // 스피너에 어댑터 설정
        spinner.setAdapter(adapter);

        // 스피너에서 선택 했을 경우 이벤트 처리
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                temp = items[position];
                Log.d("스피너테스트", "선택값 저장된 변수 temp : " + temp);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                temp = "서울";
            }
        });

        switchView.setOnCheckedChangeListener(new Switch.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked) {
                    tvGender.setText("여자");
                } else {
                    tvGender.setText("남자");
                }
            }
        });
    }

    Button.OnClickListener mClickListener = new Button.OnClickListener() {
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btnIdCheck:

                    if (etId.getText().toString().equals(id)) {
                        Toast.makeText(Ex1JoinActivity.this, "중복된 아이디입니다.", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(Ex1JoinActivity.this, "사용가능한 아이디입니다.", Toast.LENGTH_SHORT).show();
                    }


                    break;

                case R.id.btnJoin:
                    id = etId.getText().toString();
                    pw = etPw.getText().toString();
                    name = etName.getText().toString();
                    hp = etHp.getText().toString();
                    gender = tvGender.getText().toString();


                    Toast.makeText(Ex1JoinActivity.this, "가입되었습니다.", Toast.LENGTH_SHORT).show();

                    Intent intent1 = new Intent(Ex1JoinActivity.this, Ex1JoinDetail.class);
                    intent1.putExtra("id", id);
                    intent1.putExtra("pw", pw);
                    intent1.putExtra("name", name);
                    intent1.putExtra("hp", hp);
                    intent1.putExtra("gender", gender);
                    intent1.putExtra("address", temp);
                    startActivity(intent1);
                    break;

                case R.id.btnCancel:

                    break;
            }
        }
    };
}