package com.example.melayu;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class page3_5 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page3_5);

        VideoView myVDO = findViewById(R.id.video_View4);
        String videoPath = "android.resource://" + getOpPackageName() + "/" + R.raw.buy;
        Uri uri = Uri.parse(videoPath);
        myVDO.setVideoURI(uri);

        MediaController mediaController = new MediaController(this);
        myVDO.setMediaController(mediaController);
        mediaController.setAnchorView(myVDO);
        myVDO.start();
    }
}
