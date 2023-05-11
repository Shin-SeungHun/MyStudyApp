package com.ssh.mystudyapp;



import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class Ex16FrameLayoutActivity extends AppCompatActivity {

    LinearLayout frame1, frame2, frame3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex16_frame_layout);

        findViewById(R.id.btnAct1).setOnClickListener(mClick);
        findViewById(R.id.btnAct2).setOnClickListener(mClick);
        findViewById(R.id.btnAct3).setOnClickListener(mClick);

        frame1 = (LinearLayout)findViewById(R.id.frame1);
        frame2 = (LinearLayout)findViewById(R.id.frame2);
        frame3 = (LinearLayout)findViewById(R.id.frame3);

    }

    View.OnClickListener mClick = new View.OnClickListener()
    {
        public void onClick(View v)
        {
            frame1.setVisibility(View.INVISIBLE);
            frame2.setVisibility(View.INVISIBLE);
            frame3.setVisibility(View.INVISIBLE);

            switch(v.getId())
            {
                case R.id.btnAct1:
                    frame1.setVisibility(View.VISIBLE);
                    Toast.makeText(Ex16FrameLayoutActivity.this,"화면1",Toast.LENGTH_SHORT).show();
                    break;
                case R.id.btnAct2:
                    frame2.setVisibility(View.VISIBLE);
                    Toast.makeText(Ex16FrameLayoutActivity.this,"화면2",Toast.LENGTH_SHORT).show();
                    break;
                case R.id.btnAct3:
                    frame3.setVisibility(View.VISIBLE);
                    Toast.makeText(Ex16FrameLayoutActivity.this,"화면3",Toast.LENGTH_SHORT).show();
                    break;

            }

        }
    };
}