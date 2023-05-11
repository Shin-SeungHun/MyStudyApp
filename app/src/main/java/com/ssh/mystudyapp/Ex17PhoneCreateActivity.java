package com.ssh.mystudyapp;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class Ex17PhoneCreateActivity extends AppCompatActivity {
    TextView tvName1,tvName2,tvName3,tvName4,tvName5;
    TextView tvPhone1,tvPhone2,tvPhone3,tvPhone4,tvPhone5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex17_phone);

        tvName1 = (TextView)findViewById(R.id.tvName1);
        tvName2 = (TextView)findViewById(R.id.tvName2);
        tvName3 = (TextView)findViewById(R.id.tvName3);
        tvName4 = (TextView)findViewById(R.id.tvName4);
        tvName5 = (TextView)findViewById(R.id.tvName5);

        tvPhone1 = (TextView)findViewById(R.id.tvPhone1);
        tvPhone2 = (TextView)findViewById(R.id.tvPhone2);
        tvPhone3 = (TextView)findViewById(R.id.tvPhone3);
        tvPhone4 = (TextView)findViewById(R.id.tvPhone4);
        tvPhone5 = (TextView)findViewById(R.id.tvPhone5);

        findViewById(R.id.btnTel1).setOnClickListener(mClick);
        findViewById(R.id.btnTel2).setOnClickListener(mClick);
        findViewById(R.id.btnTel3).setOnClickListener(mClick);
        findViewById(R.id.btnTel4).setOnClickListener(mClick);
        findViewById(R.id.btnTel5).setOnClickListener(mClick);
    }
    View.OnClickListener mClick = new View.OnClickListener()
    {
        public void onClick(View v)
        {
            switch(v.getId())
            {
                case R.id.btnTel1:
                    String tel_name1 = "tel:"+tvName1.getText().toString();
                    String tel_number1 = "tel:"+tvPhone1.getText().toString();

                    Intent intentTel1 = new Intent(Intent.ACTION_VIEW, Uri.parse(tel_number1));
                    startActivity(intentTel1);
                    Toast.makeText(Ex17PhoneCreateActivity.this,tel_name1+"에게 전화를 겁니다!",Toast.LENGTH_SHORT).show();
                    break;

                case R.id.btnTel2:
                    String tel_name2 = "tel:"+tvName2.getText().toString();
                    String tel_number2 = "tel:"+tvPhone2.getText().toString();

                    Intent intentTel2 = new Intent(Intent.ACTION_VIEW, Uri.parse(tel_number2));
                    startActivity(intentTel2);
                    Toast.makeText(Ex17PhoneCreateActivity.this,tel_name2+"에게 전화를 겁니다!",Toast.LENGTH_SHORT).show();
                    break;

                case R.id.btnTel3:
                    String tel_name3 = "tel:"+tvName3.getText().toString();
                    String tel_number3 = "tel:"+tvPhone3.getText().toString();

                    Intent intentTel3 = new Intent(Intent.ACTION_VIEW, Uri.parse(tel_number3));
                    startActivity(intentTel3);
                    Toast.makeText(Ex17PhoneCreateActivity.this,tel_name3+"에게 전화를 겁니다!",Toast.LENGTH_SHORT).show();
                    break;

                case R.id.btnTel4:
                    String tel_name4 = "tel:"+tvName4.getText().toString();
                    String tel_number4 = "tel:"+tvPhone4.getText().toString();

                    Intent intentTel4 = new Intent(Intent.ACTION_VIEW, Uri.parse(tel_number4));
                    startActivity(intentTel4);
                    Toast.makeText(Ex17PhoneCreateActivity.this,tel_name4+"에게 전화를 겁니다!",Toast.LENGTH_SHORT).show();
                    break;

                case R.id.btnTel5:
                    String tel_name5 = "tel:"+tvName5.getText().toString();
                    String tel_number5 = "tel:"+tvPhone5.getText().toString();

                    Intent intentTel5 = new Intent(Intent.ACTION_VIEW, Uri.parse(tel_number5));
                    startActivity(intentTel5);
                    Toast.makeText(Ex17PhoneCreateActivity.this,tel_name5+"에게 전화를 겁니다!",Toast.LENGTH_SHORT).show();
                    break;

            }

        }
    };

}