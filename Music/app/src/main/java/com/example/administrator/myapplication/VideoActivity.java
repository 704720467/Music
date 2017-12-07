package com.example.administrator.myapplication;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class VideoActivity extends AppCompatActivity implements View.OnClickListener {
    private Button button_start = null;
    private Button button_pause = null;
    private Button button_stop = null;
    private VideoView videoView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        init();
        initPalyer();
    }


    private void init() {
        button_pause = (Button) findViewById(R.id.button_pause);
        button_start = (Button) findViewById(R.id.button_start);
        button_stop = (Button) findViewById(R.id.button_stop);
        button_pause.setOnClickListener(this);
        button_start.setOnClickListener(this);
        button_stop.setOnClickListener(this);
    }

    private void initPalyer() {
        videoView = (VideoView) findViewById(R.id.videoView);
        /**
         * w为其提供一个控制器，控制其暂停、播放……等功能
         */
        videoView.setMediaController(new MediaController(this));
        ViewGroup.LayoutParams lp = videoView.getLayoutParams();
        lp.width = getScreenWidthSize(this);
        lp.height = (int) Math.round(lp.width * 9 / 16.0);

        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                Log.i("通知", "完成");
            }
        });

        videoView.setOnErrorListener(new MediaPlayer.OnErrorListener() {

            @Override
            public boolean onError(MediaPlayer mp, int what, int extra) {
                Log.i("通知", "播放中出现错误");
                return false;
            }
        });

        String vf = "晴天";
        Bundle bundle = this.getIntent().getExtras();
        vf = bundle.getString("vf");
        if (vf.equals("晴天")) {
            videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.video_view1));
        } else if (vf.equals("知足")) {
            videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.video_view1));
        } else if (vf.equals("情歌")) {
            videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.video_view1));
        } else if (vf.equals("小幸运")) {
            videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.video_view1));
        } else if (vf.equals("追光者")) {
            videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.video_view1));
        } else if (vf.equals("好久不见")) {
            videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.video_view1));
        }
        videoView.requestFocus();
        videoView.start();
    }

    @Override
    public void onClick(View v) {
        if (videoView == null)
            return;
        switch (v.getId()) {
            case R.id.button_pause:
                if (videoView.isPlaying())
                    videoView.pause();
                else
                    videoView.start();
                break;
            case R.id.button_start:
                videoView.start();
                break;
            case R.id.button_stop:
                videoView.stopPlayback();
                break;
        }
    }

    /**
     * 获取屏幕宽单位是像素
     *
     * @param context
     * @return
     */
    public static int getScreenWidthSize(Context context) {
        DisplayMetrics dm = new DisplayMetrics();
        dm = context.getResources().getDisplayMetrics();
        return dm.widthPixels;
    }
}