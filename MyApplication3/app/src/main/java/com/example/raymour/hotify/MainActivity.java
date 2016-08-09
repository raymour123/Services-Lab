package com.example.raymour.hotify;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mPlayer;

    ImageButton mPlay;
    ImageButton mPause;
    Button mStop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPlay = (ImageButton) findViewById(R.id.play);
        mPause = (ImageButton) findViewById(R.id.pause);
        mStop = (Button) findViewById(R.id.stop);

        mPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MusicService.class);
                startService(intent);
            }
        });

        mPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MusicService.pause();
            }
        });

        mStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MusicService.stop();
                stopService(new Intent(MainActivity.this, MusicService.class));
            }
        });

    }
}
