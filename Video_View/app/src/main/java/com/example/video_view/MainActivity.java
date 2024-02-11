package com.example.video_view;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {
    private VideoView videoView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        videoView = findViewById(R.id.videoViewId);
       Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.dheere);
       videoView.setVideoURI(uri);
       MediaController mediaController = new MediaController(this);
       videoView.setMediaController(mediaController);
       videoView.start();
    }
}