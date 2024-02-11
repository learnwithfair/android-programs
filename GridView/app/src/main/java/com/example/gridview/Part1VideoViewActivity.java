package com.example.gridview;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class Part1VideoViewActivity extends AppCompatActivity {
    private VideoView videoView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part1_video_view);
        this.setTitle("Video View");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.ic_baseline_album_24);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        ConstraintLayout constraintLayout = findViewById(R.id.Part1VideoViewActivityId);
        if (loadBackgroundColor()!=getResources().getColor(R.color.background_color)){
            constraintLayout.setBackgroundColor(loadBackgroundColor());
        }
        videoView = findViewById(R.id.part1VideoViewId);
        Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.dhriee_dhiree);
        videoView.setVideoURI(uri);
        MediaController mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);
        videoView.start();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()==android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        videoView.pause();
        super.onBackPressed();
    }
    public int loadBackgroundColor(){
        SharedPreferences preferences = getSharedPreferences("background", Context.MODE_PRIVATE);
        return  preferences.getInt("mycolor",getResources().getColor(R.color.background_color));
    }
}