package com.example.melayu;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class psge1_5 extends AppCompatActivity {
    MediaPlayer mySong1, mySong2, mySong3, mySong4, mySong5, mySong6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_psge1_5);
        mySong1 = MediaPlayer.create(psge1_5.this, R.raw.fx1);
        mySong2 = MediaPlayer.create(psge1_5.this, R.raw.fx2);
        mySong3 = MediaPlayer.create(psge1_5.this, R.raw.fx3);
        mySong4 = MediaPlayer.create(psge1_5.this, R.raw.fx4);
        mySong5 = MediaPlayer.create(psge1_5.this, R.raw.fx5);
        mySong6 = MediaPlayer.create(psge1_5.this, R.raw.fx6);

    }

    public void playIT1(View v) { mySong1.start(); }
    public void playIT2(View v) { mySong2.start(); }
    public void playIT3(View v) { mySong3.start(); }
    public void playIT4(View v) { mySong4.start(); }
    public void playIT5(View v) { mySong5.start(); }
    public void playIT6(View v) { mySong6.start(); }


    @Override
    protected void onPause() {
        super.onPause();
        mySong1.release();
        mySong2.release();
        mySong3.release();
        mySong4.release();
        mySong5.release();
        mySong6.release();

    }

}
