package com.example.administrator.myapplication;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class MusicplayerActivity extends AppCompatActivity implements View.OnClickListener {
    static int i = 1;
    private MusicService musicService;
    private ImageView btnStart, btnStop, btnPause;

    private ServiceConnection mServiceConnection = new ServiceConnection() {
        public void onServiceConnected(ComponentName name, IBinder service) {
            musicService = ((MusicService.MyBinder) service).getService();
        }

        public void onServiceDisconnected(ComponentName name) {
            musicService = null;
        }
    };

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_musicplayer);
        Bundle bundle = this.getIntent().getExtras();
        String result = bundle.getString("song");
        if (result.equals("晴天")) {
            i = 1;
        } else if (result.equals("知足")) {
            i = 2;
        } else if (result.equals("情歌")) {
            i = 3;
        } else if (result.equals("小幸运")) {
            i = 4;
        } else if (result.equals("追光者")) {
            i = 5;
        } else if (result.equals("好久不见")) {
            i = 6;
        }
        Intent intent = new Intent(this, MusicService.class);
        intent.putExtra("i", i);
        //        startService(intent);
        bindService(intent, mServiceConnection, Context.BIND_AUTO_CREATE);
        btnStart = (ImageView) findViewById(R.id.start);
        btnStop = (ImageView) findViewById(R.id.stop);
        btnPause = (ImageView) findViewById(R.id.pause);
        //        class mylistener implements View.OnClickListener {
        //            public void onClick(View v) {
        //                Intent intent = new Intent();
        //                intent.setClass(MusicplayerActivity.this, MusicService.class);
        //                startActivity(intent);
        //            }
        //        }
        btnStart.setOnClickListener(this);
        btnStop.setOnClickListener(this);
        btnPause.setOnClickListener(this);
    }

    protected void onDestroy() {
        //        MusicplayerActivity.this.stopService(new Intent(MusicplayerActivity.this, MusicService.class));
        //解绑服务
        //        unbindService(mServiceConnection);
        musicService.stopMusic();
        musicService.unbindService(mServiceConnection);
        super.onDestroy();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.start:
                try {
                    musicService.playMusic();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case R.id.pause:
                musicService.pauseMusic();
                break;
            case R.id.stop:
                musicService.pauseMusic();
                break;
        }
    }
}