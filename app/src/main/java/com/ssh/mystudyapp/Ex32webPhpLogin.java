package com.ssh.mystudyapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;

import org.json.JSONException;
import org.json.JSONObject;


public class Ex32webPhpLogin extends AppCompatActivity {

    EditText etId, etPw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex32_web_login_layout);

        etId = (EditText)findViewById(R.id.etId);
        etPw = (EditText)findViewById(R.id.etPw);

        findViewById(R.id.btnLogin).setOnClickListener(mClickListener);
        findViewById(R.id.btnJoin).setOnClickListener(mClickListener);
    }
    View.OnClickListener mClickListener = new View.OnClickListener() {
        public void onClick(View v){


            switch (v.getId()) {
                case R.id.btnLogin :
                    String id = etId.getText().toString();
                    String pw = etPw.getText().toString();
                    Log.d("로그인성공","11 id:"+ id);
                    login(id,pw);
                    break;
                case R.id.btnJoin :
                    Intent intentJoin = new Intent(Ex32webPhpLogin.this, Ex32webPhpJoin.class);
                    startActivity(intentJoin);
                    break;

            }
        }
    };

    void login(String id,String pw)
    {
        Log.d("로그인성공","22 id:"+ id);
        Response.Listener<String> responseListener = new Response.Listener<String>()
        {
            @Override
            public void onResponse(String response) {
                try {

                    ///333333333333333333333333333333
                    JSONObject jsonObject = new JSONObject(response);
                    boolean success = jsonObject.getBoolean("success");
                    String id = jsonObject.getString("id");
                    String name = jsonObject.getString("name");
                    String hp = jsonObject.getString("hp");
                    Log.d("로그인성공","success:"+ success);
                    Log.d("로그인성공","name:"+ name);
                    Log.d("로그인성공","hp:"+ hp);

                    if(success) {

                        etId.setText("");
                        etPw.setText("");
                        Intent intentMain = new Intent(Ex32webPhpLogin.this, Ex32webPhpMain.class);
                        startActivity(intentMain);
                        Toast.makeText(Ex32webPhpLogin.this, "로그인 되었습니다.", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                    else {
                        Toast.makeText(Ex32webPhpLogin.this,"로그인실패!아이디/비번확인해주세요!",Toast.LENGTH_SHORT).show();
                        Log.d("로그인실패","로그인 실패 아이디 비번 확인하시오!");
                    }

                } catch (JSONException e) {
                    Toast.makeText(Ex32webPhpLogin.this,"로그인실패!아이디/비번확인해주세요!",Toast.LENGTH_SHORT).show();
                    Log.d("로그인실패","로그인 실패 아이디 비번 확인하시오!");
                    e.printStackTrace();
                }
            }
        };
        ///111111111111111111111111111111111111111111111
        Ex32ServerRequestLogin getUserCharLevelStat = new Ex32ServerRequestLogin(id, pw, responseListener);
        RequestQueue queue = Volley.newRequestQueue(Ex32webPhpLogin.this);
        queue.add(getUserCharLevelStat);

    }

}