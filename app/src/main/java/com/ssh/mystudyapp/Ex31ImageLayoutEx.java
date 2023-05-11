package com.ssh.mystudyapp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;


public class Ex31ImageLayoutEx extends AppCompatActivity {

    ImageView ivFood;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex31_image_layout);
        ivFood = (ImageView)findViewById(R.id.ivFood);

        findViewById(R.id.menu1).setOnClickListener(mClickListener);
        findViewById(R.id.menu2).setOnClickListener(mClickListener);
    }
    View.OnClickListener mClickListener = new View.OnClickListener() {
        public void onClick(View v){


            switch (v.getId()) {
                case R.id.menu1 :
                    Glide.with(Ex31ImageLayoutEx.this).load(R.drawable.food_eat).into(ivFood);
                    // Toast.makeText(Ex31ImageLayoutEx.this,"1번음식선택!",Toast.LENGTH_SHORT).show();
                    break;
                case R.id.menu2 :
                    ivFood.setImageResource(0);
                    // Toast.makeText(Ex31ImageLayoutEx.this,"1번음식선택!",Toast.LENGTH_SHORT).show();
                    break;

            }
        }
    };

}