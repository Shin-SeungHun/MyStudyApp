package com.ssh.mystudyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;


public class Ex12SoccerGame extends AppCompatActivity {

    TextView tvResult, tvRecordTot, tvFailCnt, tvGoalCnt, tvChanceCnt;

     int chanceCnt = 10;//총게임수
     int recordTot = 0; //총게임전적
     int goalCnt = 0; //골넣은거
     int failCnt = 0; //골실패

    ImageView ivMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex12_soccer_game);

        ivMain = (ImageView) findViewById(R.id.ivMain);

        findViewById(R.id.btnMiddle).setOnClickListener(mClick);
        findViewById(R.id.btnPenalty).setOnClickListener(mClick);
        findViewById(R.id.btnHeading).setOnClickListener(mClick);
        findViewById(R.id.btnRestart).setOnClickListener(mClick);

        tvResult = (TextView) findViewById(R.id.tvResult);
        tvRecordTot = (TextView) findViewById(R.id.tvRecordTot);
        tvGoalCnt = (TextView) findViewById(R.id.tvGoalCnt);
        tvFailCnt = (TextView) findViewById(R.id.tvFailCnt);
        tvChanceCnt = (TextView) findViewById(R.id.tvChanceCnt);

        //초기화면
        tvChanceCnt.setText(chanceCnt + "회");
        tvGoalCnt.setText(goalCnt + "회");
        tvFailCnt.setText(failCnt + "회");
        tvRecordTot.setText(recordTot + "회");

    }


    public void gameStart(int gubun) {
        recordTot++;
        if (gubun == 1) {
            chanceCnt -= 2; //2씩 차감
            int rand = (int) (Math.random() * 10);
            if (rand >= 0 && rand < 5) {
                tvResult.setText("중거리 골");
                goalCnt++;
                Glide.with(Ex12SoccerGame.this).load(R.drawable.middle_goal).into(ivMain);
            } else {
                tvResult.setText("중거리 슛 실패");
                failCnt++;
                Glide.with(Ex12SoccerGame.this).load(R.drawable.kick_fail).into(ivMain);
            }
        } else if (gubun == 2) {
            chanceCnt -= 1; //1씩차감
            int rand = (int) (Math.random() * 10);
            if (rand >= 0 && rand < 3) {
                tvResult.setText("헤딩슛 골");
                goalCnt++;
                Glide.with(Ex12SoccerGame.this).load(R.drawable.heading_goal).into(ivMain);
            } else {
                tvResult.setText("헤딩슛 실패");
                failCnt++;
                Glide.with(Ex12SoccerGame.this).load(R.drawable.kick_fail2).into(ivMain);
            }
        } else if (gubun == 3) {
            chanceCnt -= 3; //3씩 차감
            int rand = (int) (Math.random() * 10);
            if (rand >= 0 && rand < 9) {
                tvResult.setText("패널티 골");
                goalCnt++;
                Glide.with(Ex12SoccerGame.this).load(R.drawable.penaltykick).into(ivMain);
            } else {
                tvResult.setText("패널티 킥 실패");
                failCnt++;
                Glide.with(Ex12SoccerGame.this).load(R.drawable.kick_fail).into(ivMain);
            }
        }

        tvChanceCnt.setText(tvChanceCnt + "회");
        tvGoalCnt.setText(goalCnt + "회");
        tvFailCnt.setText(failCnt + "회");
        tvRecordTot.setText(recordTot + "회");

    }

    View.OnClickListener mClick = new View.OnClickListener() {
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btnMiddle:
                    gameStart(1);

                    break;
                case R.id.btnPenalty:
                    gameStart(3);

                    break;
                case R.id.btnHeading:
                    gameStart(2);

                    break;
                case R.id.btnRestart:
                    chanceCnt = 10;
                    goalCnt = 0;
                    failCnt = 0;
                    recordTot = 0;
                    tvResult.setText("대기중...");
                    ivMain.setImageResource(R.drawable.fifa);
                    break;

            }
        }
    };

}