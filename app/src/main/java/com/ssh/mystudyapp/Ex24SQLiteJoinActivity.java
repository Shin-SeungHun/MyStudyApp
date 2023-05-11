package com.ssh.mystudyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Ex24SQLiteJoinActivity extends AppCompatActivity {

    MySQLiteOpenHelper helper;

    String id, pw, name, hp, addr; // 입력값을 변수에 저장해서 insert처리할 변수

    Button btnJoin, btnCancel;

    EditText etId, etPw, etHp, etName, etAddr;

    String TAG = "회원가입";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex24_sqlite_join);

        //db생성
        helper = new MySQLiteOpenHelper(
                Ex24SQLiteJoinActivity.this, //현재 화면의 context
                "member.db", //파일명
                null, //커서 팩토리
                1); //버전 번호

        btnJoin = (Button) findViewById(R.id.btnJoin);
        btnCancel = (Button) findViewById(R.id.btnCancel);

        etId = (EditText) findViewById(R.id.etId);
        etPw = (EditText) findViewById(R.id.etPw);
        etHp = (EditText) findViewById(R.id.etHp);
        etName = (EditText) findViewById(R.id.etName);
        etAddr = (EditText) findViewById(R.id.etAddr);

        btnJoin.setOnClickListener(mClick);
        btnCancel.setOnClickListener(mClick);
    }


    View.OnClickListener mClick = new View.OnClickListener() {
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btnJoin:
                    //공백체크
                    if (etId.getText().toString().equals("")) {
                        Toast.makeText(Ex24SQLiteJoinActivity.this, "아이디를 입력해주세요.", Toast.LENGTH_SHORT).show();
                        break;
                    }
                    //공백없이 입력이 되었을 경우 변수에 저장
                    id = etId.getText().toString();

                    if (etPw.getText().toString().equals("")) {
                        Toast.makeText(Ex24SQLiteJoinActivity.this, "비밀번호를 입력해주세요.", Toast.LENGTH_SHORT).show();
                        break;
                    }

                    //공백없이 입력이 되었을 경우 변수에 저장
                    pw = etPw.getText().toString();

                    if (etName.getText().toString().equals("")) {
                        Toast.makeText(Ex24SQLiteJoinActivity.this, "이름을 입력해주세요.", Toast.LENGTH_SHORT).show();
                        break;
                    }

                    //공백없이 입력이 되었을 경우 변수에 저장
                    name = etName.getText().toString();

                    if (etHp.getText().toString().equals("")) {
                        Toast.makeText(Ex24SQLiteJoinActivity.this, "연락처를 입력하세요.", Toast.LENGTH_SHORT).show();
                        break;
                    }

                    //공백없이 입력잘되었을경우 변수에 저장
                    hp = etHp.getText().toString();

                    if (etAddr.getText().toString().equals("")) {
                        Toast.makeText(Ex24SQLiteJoinActivity.this, "주소를 입력해주세요.", Toast.LENGTH_SHORT).show();
                        break;
                    }

                    //공백없이 입력이 되었을 경우 변수에 저장
                    addr = etAddr.getText().toString();

                    //db에 삽입
                    insert(id, pw, name, hp, addr);

                    //회원가입 후 가입정보 확인
                    Intent intentJoinOk = new Intent(Ex24SQLiteJoinActivity.this, Ex24JoinOkActivity.class);
                    intentJoinOk.putExtra("id", id);
                    intentJoinOk.putExtra("pw", pw);
                    intentJoinOk.putExtra("name", name);
                    intentJoinOk.putExtra("hp", hp);
                    intentJoinOk.putExtra("addr", addr);
                    startActivity(intentJoinOk);
                    finish();
                    break;

                case R.id.btnCancel:
                    Intent login = new Intent(Ex24SQLiteJoinActivity.this, Ex24SQLiteLoginActivity.class);
                    startActivity(login);
                    finish();
                    break;
            }

        }
    };

    //db 메소드 처리
    public void insert(String id, String pw, String name, String hp, String addr) {
        SQLiteDatabase db = helper.getWritableDatabase(); //db 객체를 얻어옴, 쓰기 가능

        //값들을 컨트롤하기 위한 클래스 생성
        ContentValues values = new ContentValues();

        //db.insert의 매개변수인 values가 contentValues의 변수
        //데이터의 삽입은 put으로 함
        values.put("id", id);
        values.put("pw", pw);
        values.put("name", name);
        values.put("hp", hp);
        values.put("addr", addr);

        db.insert("member", null, values); //테이블, 널컬럼핵, 테이터(널컬럽핵=디폴트)

        //tip : 마우스를 db.insert에 올리면 매개변수가 어떤 것이 와야 하는지 알 수 있다.
        db.close(); // db 종료
        Toast.makeText(getApplicationContext(), id + "로 회원가입 완료했습니다.", Toast.LENGTH_LONG).show();

        Log.d(TAG, "아이디: " + id + " / " + "비밀번호: " + pw + " / " + "이름: " + name + " / " + "연락처: " + hp + " / " + "주소: " + addr + " db저장");
    }
}