package com.ssh.mystudyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Ex24SQLiteLoginActivity extends AppCompatActivity {

    SQLiteDatabase db;
    MySQLiteOpenHelper helper;

    EditText etId, etPw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex24_sqlite_login);

        helper = new MySQLiteOpenHelper(
                Ex24SQLiteLoginActivity.this, //현재 화면의 내용
                "member.db", //파일명
                null, //커서 팩토리
                1); //버전 번호

        //아이디 비번 연동
        etId = (EditText) findViewById(R.id.etId);
        etPw = (EditText) findViewById(R.id.etPw);

        //버튼 연동
        findViewById(R.id.btnLogin).setOnClickListener(mClick);
        findViewById(R.id.btnJoin).setOnClickListener(mClick);

    }

    View.OnClickListener mClick = new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btnLogin:
                    String id = etId.getText().toString(); //화면에 입력한 아이디 가져오기
                    String pw = etPw.getText().toString(); //화면에 입력한 비밀번호 가져오기
                    if(id.equals("")){
                        Toast.makeText(Ex24SQLiteLoginActivity.this, "아이디를 입력해주세요.", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    if(pw.equals("")){
                        Toast.makeText(Ex24SQLiteLoginActivity.this, "비밀번호를 입력해주세요.", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    boolean loginCheck = false;
                    //디비 테이블에 id, pw 보내서 로그인 처리
                    loginCheck = dbLoginCheck(id,pw);

                    if(loginCheck == true){
                        Intent login = new Intent(Ex24SQLiteLoginActivity.this, Ex24SQLiteMainActivity.class);
                        startActivity(login);
                        finish();
                    }else{
                        Toast.makeText(Ex24SQLiteLoginActivity.this, "로그인에 실패했습니다.", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    break;

                case R.id.btnJoin:
                    Intent join = new Intent(Ex24SQLiteLoginActivity.this, Ex24SQLiteJoinActivity.class);
                    startActivity(join);
                    finish();
                    break;
            }
        }
    };

    public boolean dbLoginCheck(String loginId, String loginPw) {
        db = helper.getReadableDatabase(); //db객체를 가져온다 읽기전용
        Cursor c = db.rawQuery("SELECT * FROM member", null);

        while (c.moveToNext()) {
            int idx = c.getInt(0);
            String id = c.getString(1);
            String pw = c.getString(2);
            String name = c.getString(3);
            String hp = c.getString(4);
            String addr = c.getString(5);

            if(loginId.equals(id)){
                if(loginPw.equals(pw)){
                    //아이디 비밀번호가 맞을경우 종료 후 true값 리턴
                    c.close();
                    db.close();
                    Toast.makeText(this, "로그인되었습니다.", Toast.LENGTH_SHORT).show();
                    return true;
                }
            }

        }

        c.close();
        db.close();

        return false;
    }
}