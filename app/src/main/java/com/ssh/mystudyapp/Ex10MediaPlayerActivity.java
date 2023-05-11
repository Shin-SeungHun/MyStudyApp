package com.ssh.mystudyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;

import java.io.IOException;

public class Ex10MediaPlayerActivity extends AppCompatActivity {

    SeekBar seekBar;
    MediaPlayer mediaPlayer;
    TextView tvText, tvTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex10_media_player);

        tvText = (TextView) findViewById(R.id.tvText);
        tvTitle = (TextView) findViewById(R.id.tvTitle);

        seekBar = (SeekBar) findViewById(R.id.seekBar);

        findViewById(R.id.btnPlay).setOnClickListener(mClickListener);
        findViewById(R.id.btnPause).setOnClickListener(mClickListener);
        findViewById(R.id.btnStop).setOnClickListener(mClickListener);

        mediaPlayer = MediaPlayer.create(Ex10MediaPlayerActivity.this, R.raw.heiz);


        seekBar = (SeekBar) findViewById(R.id.seekBar);
        seekBar.setVisibility(ProgressBar.VISIBLE);
        seekBar.setMax(mediaPlayer.getDuration());

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser) {
                    mediaPlayer.seekTo(progress);
                }
                int m = progress / 60000;
                int s = (progress % 60000) / 1000;
                String strTime = String.format("%02d:%02d", m, s);
                //text.setText(strTime);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
    }


    public void Thread() {
        Runnable task = new Runnable() {


            public void run() {
                // �뚯븙�� �ъ깮以묒씪��
                while (mediaPlayer.isPlaying()) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    seekBar.setProgress(mediaPlayer.getCurrentPosition());
                }
            }
        };
        Thread thread = new Thread(task);
        thread.start();
    }

    View.OnClickListener mClickListener = new View.OnClickListener() {
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btnPlay:

                    mediaPlayer.start();
                    Thread();
                    tvText.setText("노래 재생중");
                    break;

                case R.id.btnPause:
                    tvText.setText("노래 일시정지중");
                    try {
                        mediaPlayer.prepare();
                    } catch (IOException ie) {
                        ie.printStackTrace();
                    }
                    mediaPlayer.seekTo(0);


                    break;

                case R.id.btnStop:

                    mediaPlayer.stop();

                    tvText.setText("노래 정지");
                    break;
            }
        }
    };
}