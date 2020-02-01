package com.example.melayu;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class page3_4 extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.Q)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page3_4);

        VideoView myVDO = findViewById(R.id.video_View3);
        String videoPath = "android.resource://" + getOpPackageName() + "/" + R.raw.mymom;
        Uri uri = Uri.parse(videoPath);
        myVDO.setVideoURI(uri);

        MediaController mediaController = new MediaController(this);
        myVDO.setMediaController(mediaController);
        mediaController.setAnchorView(myVDO);
        myVDO.start();
    }
}
