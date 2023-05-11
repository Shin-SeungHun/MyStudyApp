package com.ssh.mystudyapp;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Ex20FriendDelActivity extends AppCompatActivity {
    Switch swGender;
    TextView tvHp, tvAddress, tvAge, tvGender;

    EditText etName;


    Button btnDel, btnSearch;
    //전달할 변수들
    String selectGender = "남자";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex20_friend_del);

        tvAddress = (TextView) findViewById(R.id.tvAddress);
        tvAge = (TextView) findViewById(R.id.tvAge);
        etName = (EditText) findViewById(R.id.etName);
        tvHp = (TextView) findViewById(R.id.tvHp);

        swGender = (Switch) findViewById(R.id.swGender);
        tvGender = (TextView) findViewById(R.id.tvGender);

        btnDel = (Button) findViewById(R.id.btnEdit);
        btnSearch = (Button) findViewById(R.id.btnSearch);

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

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String findName = etName.getText().toString();


                for (int i = 0; i < Ex20FriendListActivity.adapter.getCount(); i++) {
//                    Log.d("아이템값체크", "아이템"+ Ex20FriendListActivity.adapter.items.get(i));
                    Log.d("아이템값체크", "아이템" + Ex20FriendListActivity.adapter.items.get(i).getName());
                    if (findName.equals(Ex20FriendListActivity.adapter.items.get(i).getName())) {
                        Toast.makeText(Ex20FriendDelActivity.this, "친구를 찾았습니다.", Toast.LENGTH_SHORT).show();
                        etName.setText(Ex20FriendListActivity.adapter.items.get(i).getName());
                        tvHp.setText(Ex20FriendListActivity.adapter.items.get(i).getHp());
                        tvAddress.setText(Ex20FriendListActivity.adapter.items.get(i).getAddress());
                        tvAge.setText(Ex20FriendListActivity.adapter.items.get(i).getAge() + "");
                        tvGender.setText(Ex20FriendListActivity.adapter.items.get(i).getGender());
                    }


                }

                if (findName.equals("")) {
                    Toast.makeText(Ex20FriendDelActivity.this, "이름을 입력해주세요", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    Toast.makeText(Ex20FriendDelActivity.this, "친구가 없습니다.", Toast.LENGTH_SHORT).show();
                    return;
                }

            }
        });

        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String findName = etName.getText().toString();

                for (int i = 0; i < Ex20FriendListActivity.adapter.getCount(); i++) {
                    if (findName.equals(Ex20FriendListActivity.adapter.items.get(i).getName())) {
                        Ex20FriendListActivity.adapter.items.remove(i);
                        Toast.makeText(Ex20FriendDelActivity.this, "친구를 삭제했습니다.", Toast.LENGTH_SHORT).show();
                        break;
                    }
                }

                if (findName.equals("")) {
                    Toast.makeText(Ex20FriendDelActivity.this, "삭제할 대상이 없습니다.", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    Toast.makeText(Ex20FriendDelActivity.this, "없는 이름입니다.", Toast.LENGTH_SHORT).show();
                }

                //값자리 초기화
                etName.setText("");
                tvHp.setText("");
                tvAddress.setText("");
                tvAge.setText("");

                //메인에 있는 리스트뷰에 변화가 생겨서 갱신.
                Ex20FriendListActivity.adapter.notifyDataSetChanged();
            }
        });


    }
}