package com.example.android.mediaplayerapp;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    private MediaPlayer mediaPlayer;
    private Button watchVideo;
    private ToggleButton toggleButton;
    private RadioButton radioButton;
    private TextView txt1;
    private  TextView txt2;
    private CheckBox checkBox;

    private CompoundButton.OnCheckedChangeListener checker = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton checkBox, boolean isChecked) {
            if (checkBox.isChecked()) {
                watchVideo.setEnabled(true);
            } else if (watchVideo.isEnabled()) {
                watchVideo.setEnabled(false);
            }
        }
    };

    public void onToggle(View view) {
        if (toggleButton.isChecked()) {
            mediaPlayer.stop();
            txt1.setText("Music is OFF");
        }else
            txt1.setText("Music is GONE");
    }

    public void onRadio(View view) {
        if (radioButton.isChecked())
            txt2.setText("You pushed a button");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        checkBox = findViewById(R.id.checkBox);
        watchVideo = findViewById(R.id.button);
        toggleButton = findViewById(R.id.toggleButton);
        radioButton = findViewById(R.id.radioButton);
        txt1 = findViewById(R.id.textView);
        txt2 = findViewById(R.id.textView2);
        mediaPlayer = new MediaPlayer();
        mediaPlayer = MediaPlayer.create(this, R.raw.symphony_no_5_by_beethoven);
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        mediaPlayer.setLooping(true);
        mediaPlayer.start();
        checkBox.setOnCheckedChangeListener(checker);
        watchVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, VideoActivity.class);
                startActivity(intent);
                mediaPlayer.stop();
            }
        });
    }

}
