package com.ssh.mystudyapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class Ex21GpsMapEx extends AppCompatActivity {

    Intent intent;
    EditText etKeyword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex21_gps);

        etKeyword = (EditText)findViewById(R.id.etKeyword);
        findViewById(R.id.btnStart).setOnClickListener(mClick);



        //player = MediaPlayer.create(Ex15ServiceEx.this, R.raw.so);



    }
    View.OnClickListener mClick = new View.OnClickListener()
    {
        public void onClick(View v)
        {
            switch(v.getId())
            {
                case R.id.btnStart:

                    String keyword = etKeyword.getText().toString();
                    Intent intent = new Intent (Ex21GpsMapEx.this, GoogleMapSearchActivity.class);
                    intent.putExtra("keyword",keyword);
                    startActivity(intent);
                    break;

            }

        }
    };
}