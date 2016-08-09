package com.example.raymour.hotify;

import android.app.Service;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;

import java.io.IOException;

/**
 * Created by raymour on 8/8/16.
 */
public class MusicService extends Service {
    private static final String TAG = "MusicService";
    public static MediaPlayer mPlayer;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mPlayer = null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (mPlayer == null) {

            String url = "https://archive.org/download/BittersweetSymphony_846/The_Verve_-_Bittersweet_Symphony_-_XtremeFilez.com.mp3";
            mPlayer = new MediaPlayer();
            mPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
            try {
                mPlayer.setDataSource(url);
                mPlayer.prepare();
            } catch (IOException e) {
                e.printStackTrace();
            }
            mPlayer.start();

        } else {
            play();
        }
        return START_NOT_STICKY;
    }


    public static void pause() {
        if (mPlayer != null && mPlayer.isPlaying()) {
            mPlayer.pause();
        }
    }

    public void play() {
        if (mPlayer != null && !mPlayer.isPlaying()) {
            mPlayer.start();
        }
    }

    public static void stop () {
        mPlayer.stop();
        mPlayer.release();
    }
}
