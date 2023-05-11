package com.ssh.mystudyapp;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
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

public class Ex28RecyclerViewFriendAdd extends AppCompatActivity {

    MySQLiteOpenHelperFriends2 helper;
    Switch swGender;
    TextView tvGender;


    int age;
    EditText etName, etHp, etAddr, etAge;


    Button btnAdd, btnCancel;
    //전달할 변수들
    String sendId, sendPw, sendName, sendHp, selectGender = "남자";

    String TAG = "친구추가";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex28_recyclerview_friend_add);

        //데이베이스 생성.
        helper = new MySQLiteOpenHelperFriends2(
                Ex28RecyclerViewFriendAdd.this, // 현재 화면의 context
                "friend.db", // 파일명
                null, // 커서 팩토리
                1); // 버전 번호

        etAddr = (EditText) findViewById(R.id.etAddr);
        etAge = (EditText) findViewById(R.id.etAge);
        etName = (EditText) findViewById(R.id.etName);
        etHp = (EditText) findViewById(R.id.etHp);

        swGender = (Switch) findViewById(R.id.swGender);
        tvGender = (TextView) findViewById(R.id.tvGender);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnCancel = (Button) findViewById(R.id.btnCancel);
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


                String name = etName.getText().toString().trim(); //trim()으로 공백제거
                String hp = etHp.getText().toString().trim();
                String addr = etAddr.getText().toString().trim();
                String gender = selectGender;

                if (name.equals("")) {
                    Toast.makeText(Ex28RecyclerViewFriendAdd.this, "이름을 입력해주세요", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (hp.equals("")) {
                    Toast.makeText(Ex28RecyclerViewFriendAdd.this, "연락처를 입력해주세요", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (addr.equals("")) {
                    Toast.makeText(Ex28RecyclerViewFriendAdd.this, "주소를 입력해주세요", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (etAge.getText().toString().equals("")) {
                    Toast.makeText(Ex28RecyclerViewFriendAdd.this, "나이를 입력해주세요", Toast.LENGTH_SHORT).show();
                    return;
                }
                //공백체크가 다 되었으면 나이는 숫자로 변환
                int age = Integer.parseInt(etAge.getText().toString());


                insert(name, hp, gender, addr, age + "");


                //리스트뷰 어댑터에 처리하는부분...
                //Ex25SQLiteFriendListActivity.setData(name, hp, addr, gender, age);

                //값자리 초기화
                etName.setText("");
                etHp.setText("");
                etAddr.setText("");
                etAge.setText("");

                Toast.makeText(Ex28RecyclerViewFriendAdd.this, "친구가 추가되었습니다..", Toast.LENGTH_SHORT).show();

            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent main = new Intent(Ex28RecyclerViewFriendAdd.this, Ex28RecyclerViewFriendList.class);
                startActivity(main);
                finish();
            }
        });


    }

    public void insert(String name, String hp, String gender, String addr, String age) {

        SQLiteDatabase db = helper.getWritableDatabase(); // db 객체를 얻어온다. 쓰기 가능

        //값들을 컨트롤 하려고 클래스 생성
        ContentValues values = new ContentValues();

        // db.insert의 매개변수인 values가 ContentValues 변수이므로 그에 맞춤
        // 데이터의 삽입은 put을 이용한다.
        values.put("name", name);
        values.put("hp", hp);
        values.put("gender", gender);
        values.put("address", addr);
        values.put("age", age);
        db.insert("friend", null, values); // 테이블/널컬럼핵/데이터(널컬럼핵=디폴트)

        // tip : 마우스를 db.insert에 올려보면 매개변수가 어떤 것이 와야 하는지 알 수 있다.
        db.close();
        Toast.makeText(getApplicationContext(), name + "친구 추가 완료.", Toast.LENGTH_LONG).show();

        Log.d(TAG, name + "/" + hp + "/" + addr + "/" + gender + "/" + age + " 의 정보로 디비저장완료.");
        Ex28RecyclerViewFriendList.selectFriendList();
    }
}