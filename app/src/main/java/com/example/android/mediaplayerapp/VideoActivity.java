package com.example.android.mediaplayerapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

public class VideoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        VideoView vView = findViewById(R.id.videoView);
        vView.requestFocus();
        String vSource ="android.resource://com.example.android.mediaplayerapp/" + R.raw.mountains;
        vView.setVideoURI(Uri.parse(vSource));
        vView.setMediaController(new MediaController(this));
        vView.start();
    }

    public void playMusic(View view) {
        Intent intent = new Intent(VideoActivity.this, MusicActivity.class);
        startActivity(intent);
    }

}
