package com.example.administrator.myapplication;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.widget.Toast;

import java.io.IOException;

public class MusicService extends Service {
    static int i = 1;
    private MyBinder iBinder;
    private MediaPlayer musicPlayer;
    private String result = "音乐";
    public class MyBinder extends Binder {
        MusicService getService() {
            return MusicService.this;
        }
    }
    public MusicService() {
    }
    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        iBinder = new MyBinder();
        Toast.makeText(this, "MusicService onBind", Toast.LENGTH_SHORT).show();
        return iBinder;
    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        result = intent.getStringExtra("i");
        return super.onStartCommand(intent, flags, startId);
    }
    public void playMusic() throws IOException {
        Toast.makeText(this, "MusicService playMusic", Toast.LENGTH_SHORT).show();
        switch (i) {
            case 1:
                musicPlayer = MediaPlayer.create(getApplicationContext(), R.raw.qingtian);
                break;
            case 2:
                musicPlayer = MediaPlayer.create(getApplicationContext(), R.raw.zhizu);
                break;
            case 3:
                musicPlayer = MediaPlayer.create(getApplicationContext(), R.raw.qingge);
                break;
            case 4:
                musicPlayer = MediaPlayer.create(getApplicationContext(), R.raw.xiaoxingyun);
                break;
            case 5:
                musicPlayer = MediaPlayer.create(getApplicationContext(), R.raw.zhuiguangzhe);
                break;
            case 6:
                musicPlayer = MediaPlayer.create(getApplicationContext(), R.raw.haojiubujian);
                break;
        }
        musicPlayer.setLooping(true);
        musicPlayer.start();
    }
    public void stopMusic() {
        if (musicPlayer == null)
            return;
        if (musicPlayer.isPlaying()) {
            Toast.makeText(this, "MusicService stopMusic", Toast.LENGTH_SHORT).show();
            musicPlayer.stop();
        }
    }
    public void pauseMusic() {
        if (musicPlayer == null)
            return;
        if (musicPlayer.isPlaying()) {
            Toast.makeText(this, "MusicService pauseMusic", Toast.LENGTH_SHORT).show();
            musicPlayer.pause();
        }
    }
}