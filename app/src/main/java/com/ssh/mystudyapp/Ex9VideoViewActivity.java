package com.ssh.mystudyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

public class Ex9VideoViewActivity extends AppCompatActivity {

    VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex9_video_view);

        videoView = (VideoView) findViewById(R.id.videoView);

        findViewById(R.id.btnPlay).setOnClickListener(mClickListener);
        findViewById(R.id.btnPause).setOnClickListener(mClickListener);
        findViewById(R.id.btnStop).setOnClickListener(mClickListener);

        Uri videoUri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.mv);
        videoView.setMediaController(new MediaController(this));
        videoView.setVideoURI(videoUri);
    }

    View.OnClickListener mClickListener = new View.OnClickListener() {
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btnPlay:
                    videoView.start();
                    break;

                case R.id.btnPause:
                    videoView.pause();
                    break;

                case R.id.btnStop:
                    videoView.stopPlayback();
                    break;
            }
        }
    };
}