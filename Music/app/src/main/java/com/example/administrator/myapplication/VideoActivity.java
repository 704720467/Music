package com.example.administrator.myapplication;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

public class VideoActivity extends AppCompatActivity {
    private Button button_start = null;
    private Button button_pause = null;
    private Button button_stop = null;
    private VideoView videoView = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String vf = "晴天";
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        Bundle bundle = this.getIntent().getExtras();
        String result = bundle.getString("vf");
        init();
        if (vf == "晴天") {
            videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.video_view1));
        } else if (vf == "知足") {
            videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.video_view1));
        } else if (vf == "情歌") {
            videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.video_view1));
        } else if (vf == "小幸运") {
            videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.video_view1));
        } else if (vf == "追光者") {
            videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.video_view1));
        } else if (vf == "好久不见") {
            videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.video_view1));
        }
        registerButtonHandler();
        videoView.requestFocus();
    }
    private void registerButtonHandler() {
        button_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                videoView.start();
            }
        });
        button_pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (videoView.isPlaying()) {
                    videoView.pause();
                } else {
                    videoView.start();
                }
            }
        });
        button_stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                videoView.stopPlayback();
            }
        });
    }
    private void init() {
        button_pause = (Button) findViewById(R.id.button_pause);
        button_start = (Button) findViewById(R.id.button_start);
        button_stop = (Button) findViewById(R.id.button_stop);
        videoView = (VideoView) findViewById(R.id.videoView);
    }
}