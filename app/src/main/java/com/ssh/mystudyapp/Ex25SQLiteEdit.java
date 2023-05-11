package com.ssh.mystudyapp;


import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
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

public class Ex25SQLiteEdit extends AppCompatActivity {

    SQLiteDatabase db;
    MySQLiteOpenHelperFriends helper;

    Switch swGender;
    TextView tvGender;

    EditText etName, etHp, etAddr, etAge;


    Button btnEdit, btnSearch, btnCancel;
    //전달할 변수들
    String selectGender = "남자";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex25_sqlite_edit);

        helper = new MySQLiteOpenHelperFriends(
                Ex25SQLiteEdit.this, // 현재 화면의 context
                "friend.db", // 파일명
                null, // 커서 팩토리
                1); // 버전 번호

        etAddr = (EditText) findViewById(R.id.etAddr);
        etAge = (EditText) findViewById(R.id.etAge);
        etName = (EditText) findViewById(R.id.etName);
        etHp = (EditText) findViewById(R.id.etHp);

        swGender = (Switch) findViewById(R.id.swGender);
        tvGender = (TextView) findViewById(R.id.tvGender);

        btnEdit = (Button) findViewById(R.id.btnEdit);
        btnSearch = (Button) findViewById(R.id.btnSearch);
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

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String findName = etName.getText().toString();

                if (findName.equals("")) {
                    Toast.makeText(Ex25SQLiteEdit.this, "이름을 입력해주세요.", Toast.LENGTH_SHORT).show();
                    return;
                }

                db = helper.getReadableDatabase(); //db객체를 가져온다 읽기전용
                Cursor c = db.rawQuery("SELECT * FROM friends", null);
                while (c.moveToNext()) {
                    int idx = c.getInt(0);
                    String name = c.getString(1);
                    String hp = c.getString(2);
                    String gender = c.getString(3);
                    String addr = c.getString(4);
                    String age = c.getString(5);
                    if (findName.equals(name)) {
                        etHp.setText(hp);
                        if (gender.equals("남자")) {
                            swGender.setChecked(false);
                        } else {
                            swGender.setChecked(true);
                        }
                        etAddr.setText(addr);
                        etAge.setText(age);

                    }
                }
                c.close();
                db.close();

//                for (int i = 0; i < Ex25SQLiteFriendListActivity.adapter.getCount(); i++) {
////                    Log.d("아이템값체크", "아이템"+ Ex20FriendListActivity.adapter.items.get(i));
//                    Log.d("아이템값체크", "아이템" + Ex25SQLiteFriendListActivity.adapter.items.get(i).getName());
//                    if (findName.equals(Ex25SQLiteFriendListActivity.adapter.items.get(i).getName())) {
//                        //Toast.makeText(Ex20FriendEditActivity.this, "수정체크:"+name+"/"+selectGender+"/"+age, Toast.LENGTH_SHORT).show();
//                        Toast.makeText(Ex25SQLiteEdit.this, "친구를 찾았습니다.", Toast.LENGTH_SHORT).show();
//
//
//                        etName.setText(Ex25SQLiteFriendListActivity.adapter.items.get(i).getName());
//                        etHp.setText(Ex25SQLiteFriendListActivity.adapter.items.get(i).getHp());
//                        etAddr.setText(Ex25SQLiteFriendListActivity.adapter.items.get(i).getAddress());
//                        etAge.setText(Ex25SQLiteFriendListActivity.adapter.items.get(i).getAge() + "");
//                        if ("남자".equals(Ex25SQLiteFriendListActivity.adapter.items.get(i).getGender())) {
//                            swGender.setChecked(false);
////                            Ex25SQLiteFriendListActivity.adapter.items.get(i).setGender(selectGender);
//                        } else {
//                            swGender.setChecked(true);
////                            Ex25SQLiteFriendListActivity.adapter.items.get(i).setGender(selectGender);
//                        }
//                    } else {
//                        Toast.makeText(Ex25SQLiteEdit.this, "친구가 없습니다.", Toast.LENGTH_SHORT).show();
//                    }
//                }


            }

        });

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etName.getText().toString();
                String hp = etHp.getText().toString();
                String addr = etAddr.getText().toString();
                String gender = selectGender;

                String findName = etName.getText().toString();
                String inputHp = etHp.getText().toString();
                String inputAddress = etAddr.getText().toString();

                if (findName.equals("")) {
                    Toast.makeText(Ex25SQLiteEdit.this, "이름을 입력해주세요.", Toast.LENGTH_SHORT).show();
                    return;
                } else if (inputHp.equals("")) {
                    Toast.makeText(Ex25SQLiteEdit.this, "연락처를 입력해주세요.", Toast.LENGTH_SHORT).show();
                    return;
                } else if (inputAddress.equals("")) {
                    Toast.makeText(Ex25SQLiteEdit.this, "주소를 입력해주세요.", Toast.LENGTH_SHORT).show();
                    return;
                } else if (etAge.getText().toString().equals("")) {
                    Toast.makeText(Ex25SQLiteEdit.this, "나이를 입력해주세요.", Toast.LENGTH_SHORT).show();
                    return;
                }
                //공백체크가 다 되었으면 나이는 숫자로 변환
                int age = Integer.parseInt(etAge.getText().toString());

                //리스트뷰 어댑터에 처리하는부분...
                for (int i = 0; i < Ex25SQLiteFriendListActivity.adapter.getCount(); i++) {
                    if (findName.equals(Ex25SQLiteFriendListActivity.adapter.items.get(i).getName())) {
                        Toast.makeText(Ex25SQLiteEdit.this, "수정되었습니다.", Toast.LENGTH_SHORT).show();
//                        Toast.makeText(Ex20FriendEditActivity.this, "수정체크:" + name + "/" + selectGender + "/" + age, Toast.LENGTH_SHORT).show();
                        //값자리 초기화
                        Ex25SQLiteFriendListActivity.adapter.items.get(i).setName(name);
                        Ex25SQLiteFriendListActivity.adapter.items.get(i).setHp(hp);
                        Ex25SQLiteFriendListActivity.adapter.items.get(i).setAddress(addr);

                        Ex25SQLiteFriendListActivity.adapter.items.get(i).setAge(age);
                        if ("남자".equals(Ex25SQLiteFriendListActivity.adapter.items.get(i).getGender())) {
                            Ex25SQLiteFriendListActivity.adapter.items.get(i).setGender(selectGender);
                        } else {
                            Ex25SQLiteFriendListActivity.adapter.items.get(i).setGender(selectGender);
                        }
                    }
                }
                //db에 수정요청
                update(name, hp, selectGender, addr, age);

                etName.setText("");
                etHp.setText("");
                etAddr.setText("");
                etAge.setText("");
                Toast.makeText(Ex25SQLiteEdit.this, "수정이 완료되었습니다.", Toast.LENGTH_SHORT).show();
                //메인에 있는 리스트뷰에 변화가 생겨서 갱신
                Ex25SQLiteFriendListActivity.adapter.notifyDataSetChanged();


            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent main = new Intent(Ex25SQLiteEdit.this, Ex25SQLiteFriendListActivity.class);
                startActivity(main);
                finish();
            }
        });

    }

    // update
    public void update(String name, String hp, String gender, String addr, int age) {
        db = helper.getWritableDatabase(); //db 객체를 얻어온다. 쓰기가능

        ContentValues values = new ContentValues();
//        values.put("name", name);
        values.put("hp", hp);
        values.put("gender", gender);
        values.put("addr", addr);
        values.put("age", age);
        db.update("friend", values, "id='" + name + "'", null);

        db.close();
        Toast.makeText(getApplicationContext(), name + "의 정보가 수정되었습니다.", Toast.LENGTH_SHORT).show();
        //수정완료후 초기화
        etName.setText("");
        etHp.setText("");
        etAddr.setText("");
        etAge.setText("");
//        etAddr.setText("");
    }

//    // 수정 아이디 찾기
//    public void searchEditId(String editId) {
//
//        // 1) db의 데이터를 읽어와서, 2) 결과 저장, 3)해당 데이터를 꺼내 사용
//        db = helper.getReadableDatabase(); // db객체를 얻어온다. 읽기 전용
//        Cursor c = db.rawQuery("SELECT * FROM friend where name='" + editId + "'", null);
//
//        String Result = "";
//        boolean check = false;
//        while (c.moveToNext()) {
//            int idx = c.getInt(0);
//            String name = c.getString(1);
//            String hp = c.getString(2);
//            String gender = c.getString(3);
//            String addr = c.getString(4);
//            String age = c.getString(5);
//
//
//            etName.setText(name);
//            etHp.setText(hp);
//            etAddr.setText(addr);
//            etAge.setText(age);
////            etAddr.setText(addr);
//            check = true;
//        }
//        if (check == false) {
//            etName.setText("");
//            etHp.setText("");
//            etAddr.setText("");
//            etAge.setText("");
//            Toast.makeText(Ex25SQLiteEdit.this, "찾는 대상이없습니다!", Toast.LENGTH_SHORT).show();
//        }
//        c.close();
//        db.close();
//    }
}