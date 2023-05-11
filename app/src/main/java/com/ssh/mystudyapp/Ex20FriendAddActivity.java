package com.ssh.mystudyapp;

import android.content.Intent;
import android.os.Bundle;
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

public class Ex20FriendAddActivity extends AppCompatActivity {
    Switch swGender;
    TextView tvGender;

    EditText etName, etHp, etAddress, etAge;


    Button btnAdd, btnCancel;
    //전달할 변수들
    String sendId, sendPw, sendName, sendHp, selectGender = "남자";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex20_friend_add);


        etAddress = (EditText) findViewById(R.id.etAddress);
        etAge = (EditText) findViewById(R.id.etAge);
        etName = (EditText) findViewById(R.id.etName);
        etHp = (EditText) findViewById(R.id.etHp);

        swGender = (Switch) findViewById(R.id.swGender);
        tvGender = (TextView) findViewById(R.id.tvGender);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        swGender = findViewById(R.id.swGender);
        swGender.setOnCheckedChangeListener(new Switch.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked) {
                    tvGender.setText("여자");
                    selectGender = "여자";
                } else {
                    tvGender.setText("남자");
                    selectGender = "남자";
                }
            }
        });


        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String name = etName.getText().toString();
                String hp = etHp.getText().toString();
                String addr = etAddress.getText().toString();
                String gender = selectGender;

                if (name.equals("")) {
                    Toast.makeText(Ex20FriendAddActivity.this, "이름을 입력해주세요", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (hp.equals("")) {
                    Toast.makeText(Ex20FriendAddActivity.this, "연락처를 입력해주세요", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (addr.equals("")) {
                    Toast.makeText(Ex20FriendAddActivity.this, "주소를 입력해주세요", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (etAge.getText().toString().equals("")) {
                    Toast.makeText(Ex20FriendAddActivity.this, "나이를 입력해주세요", Toast.LENGTH_SHORT).show();
                    return;
                }
                //공백체크가 다 되었으면 나이는 숫자로 변환
                int age = Integer.parseInt(etAge.getText().toString());

                //리스트뷰 어댑터에 처리하는부분...
                Ex20FriendListActivity.setData(name, hp, addr, gender, age);
                //값자리 초기화
                etName.setText("");
                etHp.setText("");
                etAddress.setText("");
                etAge.setText("");

                Toast.makeText(Ex20FriendAddActivity.this, "친구가 추가되었습니다..", Toast.LENGTH_SHORT).show();
            }
        });


    }
}