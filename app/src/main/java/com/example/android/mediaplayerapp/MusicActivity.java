package com.example.android.mediaplayerapp;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MusicActivity extends AppCompatActivity {
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);
    }
    //start music
    public void onMusicPlay(View view) {
        if (mediaPlayer == null)
            mediaPlayer = MediaPlayer.create(this, R.raw.symphony_no_5_by_beethoven);
        mediaPlayer.start();
    }
    //pause music
    public void onMusicPause(View view) {
        mediaPlayer.pause();
    }
    //stop music
    public void onMusicStop(View view) {
        mediaPlayer.stop();
        mediaPlayer = null;
    }

}
