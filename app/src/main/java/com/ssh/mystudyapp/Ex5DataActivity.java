package com.ssh.mystudyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Ex5DataActivity extends AppCompatActivity {

    public static String id, hp;
    EditText etId, etHp, etExportId, etExportHp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex5_data);


        etId = (EditText) findViewById(R.id.etId);
        etHp = (EditText) findViewById(R.id.etHp);
        etExportId = (EditText) findViewById(R.id.etExportId);
        etExportHp = (EditText) findViewById(R.id.etExportHp);

        findViewById(R.id.btnSave).setOnClickListener(mClickListener);
        findViewById(R.id.btnExport).setOnClickListener(mClickListener);
    }

    Button.OnClickListener mClickListener = new Button.OnClickListener() {
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btnSave:
                    id = etId.getText().toString();
                    hp = etHp.getText().toString();

                    etId.setText("");
                    etHp.setText("");
                    Toast.makeText(Ex5DataActivity.this, "저장되었습니다.", Toast.LENGTH_SHORT).show();
                    break;

                case R.id.btnExport:
                    String getId = etExportId.getText().toString();
                    String getHp = etExportHp.getText().toString();

                    Intent intent1 = new Intent(Ex5DataActivity.this, Ex5DataReceiveActivity.class);
                    intent1.putExtra("id", getId);
                    intent1.putExtra("hp", getHp);
                    startActivity(intent1);
                    break;


            }
        }
    };
}