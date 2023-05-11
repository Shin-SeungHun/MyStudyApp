package com.ssh.mystudyapp;


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

public class Ex28RecyclerViewFriendDel extends AppCompatActivity {

    SQLiteDatabase db;
    MySQLiteOpenHelperFriends2 helper;

    Switch swGender;
    TextView tvHp, tvAddr, tvAge, tvGender;

    EditText etName;


    Button btnDel, btnSearch, btnCancel;
    //전달할 변수들
    String selectGender = "남자";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex28_recyclerview_del);

        helper = new MySQLiteOpenHelperFriends2(
                Ex28RecyclerViewFriendDel.this, // 현재 화면의 context
                "friend.db", // 파일명
                null, // 커서 팩토리
                1); // 버전 번호

        tvAddr = (TextView) findViewById(R.id.tvAddr);
        tvAge = (TextView) findViewById(R.id.tvAge);
        etName = (EditText) findViewById(R.id.etName);
        tvHp = (TextView) findViewById(R.id.tvHp);

        swGender = (Switch) findViewById(R.id.swGender);
        tvGender = (TextView) findViewById(R.id.tvGender);

        btnDel = (Button) findViewById(R.id.btnEdit);
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
                    Toast.makeText(Ex28RecyclerViewFriendDel.this, "이름을 입력해주세요", Toast.LENGTH_SHORT).show();
                    return;
                }

                for (int i = 0; i < Ex28RecyclerViewFriendList.adapter.getItemCount(); i++) {
//                    Log.d("아이템값체크", "아이템"+ Ex20FriendListActivity.adapter.items.get(i));
                    Log.d("아이템값체크", "아이템" + Ex28RecyclerViewFriendList.adapter.items.get(i).getName());
                    if (findName.equals(Ex28RecyclerViewFriendList.adapter.items.get(i).getName())) {
                        Toast.makeText(Ex28RecyclerViewFriendDel.this, "친구를 찾았습니다.", Toast.LENGTH_SHORT).show();
                        etName.setText(Ex28RecyclerViewFriendList.adapter.items.get(i).getName());
                        tvHp.setText(Ex28RecyclerViewFriendList.adapter.items.get(i).getHp());
                        tvAddr.setText(Ex28RecyclerViewFriendList.adapter.items.get(i).getAddr());
                        tvAge.setText(Ex28RecyclerViewFriendList.adapter.items.get(i).getAge() + "");
                        tvGender.setText(Ex28RecyclerViewFriendList.adapter.items.get(i).getGender());
                    }


                }


            }

        });

        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String findName = etName.getText().toString();

                if (findName.equals("")) {
                    Toast.makeText(Ex28RecyclerViewFriendDel.this, "이름을 입력해주세요.", Toast.LENGTH_SHORT).show();
                    return;
                }

                for (int i = 0; i < Ex28RecyclerViewFriendList.adapter.getItemCount(); i++) {
                    //Log.d("아이템값체크","아아템:"+Ex28RecyclerViewFriendList.adapter.items.get(i).getName());
                    if (findName.equals(Ex28RecyclerViewFriendList.adapter.items.get(i).getName())) {
                        Ex28RecyclerViewFriendList.adapter.items.remove(i);
                        Toast.makeText(Ex28RecyclerViewFriendDel.this, "친구를 삭제했습니다.", Toast.LENGTH_SHORT).show();
                        break;
                    }
                }

                //메인에 있는 리스트뷰에 변화가 생겨서 갱신.
                Ex28RecyclerViewFriendList.adapter.notifyDataSetChanged();

                //값자리 초기화
                etName.setText("");
                tvHp.setText("");
                tvAddr.setText("");
                tvAge.setText("");

                Toast.makeText(Ex28RecyclerViewFriendDel.this, "삭제되었습니다.", Toast.LENGTH_SHORT).show();
                delete(findName);
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent main = new Intent(Ex28RecyclerViewFriendDel.this, Ex28RecyclerViewFriendList.class);
                startActivity(main);
                finish();
            }
        });


    }

    public void delete(String delName) {
        db = helper.getWritableDatabase();
        db.delete("friend", "name='" + delName + "'", null);
        Log.d("db", delName + "가 정상적으로 삭제 되었습니다.");
        Toast.makeText(getApplicationContext(), delName + "의 정보가 삭제되었습니다.", Toast.LENGTH_SHORT).show();
        db.close();

        //삭제후처리
        etName.setText("");
        tvHp.setText("");
        tvAddr.setText("");
        tvAge.setText("");
        //tvDelList.setText("[ 대상이 삭제되었습니다. ]");
    }

//    public void searchDelName(String findName) {
//        // 1) db의 데이터를 읽어와서, 2) 결과 저장, 3)해당 데이터를 꺼내 사용
//        db = helper.getReadableDatabase(); // db객체를 얻어온다. 읽기 전용
//        Cursor c = db.rawQuery("SELECT * FROM friend where name = '" + findName + "'", null);
//
//        String Result = "";
//        while (c.moveToNext()) {
//            int idx = c.getInt(0);
//            String name = c.getString(1);
//            //String pw = c.getString(2);
//            String hp = c.getString(3);
//            String gender = c.getString(4);
//            String addr = c.getString(5);
//            String age = c.getString(5);
//
//            Result += name + " | " + hp + " | " + gender + " | " + addr + " | " + age;
//            Log.d("삭제대상정보", Result);
//
//        }
////        tvDelList.setText(Result);
//        c.close();
//        db.close();
//    }
}