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

public class Ex20FriendEditActivity extends AppCompatActivity {
    Switch swGender;
    TextView tvGender;

    EditText etName, etHp, etAddress, etAge;


    Button btnEdit, btnSearch;
    //전달할 변수들
    String selectGender = "남자";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex20_friend_edit);

        etAddress = (EditText) findViewById(R.id.etAddress);
        etAge = (EditText) findViewById(R.id.etAge);
        etName = (EditText) findViewById(R.id.etName);
        etHp = (EditText) findViewById(R.id.etHp);

        swGender = (Switch) findViewById(R.id.swGender);
        tvGender = (TextView) findViewById(R.id.tvGender);

        btnEdit = (Button) findViewById(R.id.btnEdit);
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
                        //Toast.makeText(Ex20FriendEditActivity.this, "수정체크:"+name+"/"+selectGender+"/"+age, Toast.LENGTH_SHORT).show();
                        Toast.makeText(Ex20FriendEditActivity.this, "친구를 찾았습니다.", Toast.LENGTH_SHORT).show();


                        etName.setText(Ex20FriendListActivity.adapter.items.get(i).getName());
                        etHp.setText(Ex20FriendListActivity.adapter.items.get(i).getHp());
                        etAddress.setText(Ex20FriendListActivity.adapter.items.get(i).getAddress());
                        etAge.setText(Ex20FriendListActivity.adapter.items.get(i).getAge() + "");
                        if ("남자".equals(Ex20FriendListActivity.adapter.items.get(i).getGender())) {
                             swGender.setChecked(false);
//                            Ex20FriendListActivity.adapter.items.get(i).setGender(selectGender);
                        } else {
                             swGender.setChecked(true);
//                            Ex20FriendListActivity.adapter.items.get(i).setGender(selectGender);
                        }
                    } else {
                        Toast.makeText(Ex20FriendEditActivity.this, "친구가 없습니다.", Toast.LENGTH_SHORT).show();
                    }
                }

                if(findName.equals("")){
                    Toast.makeText(Ex20FriendEditActivity.this, "이름을 입력해주세요.", Toast.LENGTH_SHORT).show();
                    return;
                }else{
                    Toast.makeText(Ex20FriendEditActivity.this, "없는 이름입니다.", Toast.LENGTH_SHORT).show();

                }


            }
        });

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etName.getText().toString();
                String hp = etHp.getText().toString();
                String address = etAddress.getText().toString();
                String gender = selectGender;

                String findName = etName.getText().toString();
                String inputHp = etHp.getText().toString();
                String inputAddress = etAddress.getText().toString();

                if(findName.equals("")){
                    Toast.makeText(Ex20FriendEditActivity.this, "이름을 입력해주세요.", Toast.LENGTH_SHORT).show();
                    return;
                }else if(inputHp.equals("")){
                    Toast.makeText(Ex20FriendEditActivity.this, "연락처를 입력해주세요.", Toast.LENGTH_SHORT).show();
                    return;
                }else if(inputAddress.equals("")){
                    Toast.makeText(Ex20FriendEditActivity.this, "주소를 입력해주세요.", Toast.LENGTH_SHORT).show();
                    return;
                }else if(etAge.getText().toString().equals("")){
                    Toast.makeText(Ex20FriendEditActivity.this, "나이를 입력해주세요.", Toast.LENGTH_SHORT).show();
                    return;
                }
                //공백체크가 다 되었으면 나이는 숫자로 변환
                int age = Integer.parseInt(etAge.getText().toString());

                //리스트뷰 어댑터에 처리하는부분...
                for (int i = 0; i < Ex20FriendListActivity.adapter.getCount(); i++) {
                    if (findName.equals(Ex20FriendListActivity.adapter.items.get(i).getName())) {
                        Toast.makeText(Ex20FriendEditActivity.this, "수정되었습니다.", Toast.LENGTH_SHORT).show();
//                        Toast.makeText(Ex20FriendEditActivity.this, "수정체크:" + name + "/" + selectGender + "/" + age, Toast.LENGTH_SHORT).show();
                        //값자리 초기화
                        Ex20FriendListActivity.adapter.items.get(i).setName(name);
                        Ex20FriendListActivity.adapter.items.get(i).setHp(hp);
                        Ex20FriendListActivity.adapter.items.get(i).setAddress(address);

                        Ex20FriendListActivity.adapter.items.get(i).setAge(age);
                        if ("남자".equals(Ex20FriendListActivity.adapter.items.get(i).getGender())) {
                            Ex20FriendListActivity.adapter.items.get(i).setGender(selectGender);
                        } else {
                            Ex20FriendListActivity.adapter.items.get(i).setGender(selectGender);
                        }
                    }
                }


//                etName.setText("");
//                etHp.setText("");
//                etAddress.setText("");
//                etAge.setText("");

                //메인에 있는 리스트뷰에 변화가 생겨서 갱신
                Ex20FriendListActivity.adapter.notifyDataSetChanged();


            }
        });


    }
}