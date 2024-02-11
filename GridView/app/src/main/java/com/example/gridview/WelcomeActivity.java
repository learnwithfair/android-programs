package com.example.gridview;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

public class WelcomeActivity extends AppCompatActivity {
    private ProgressBar progressBar;
    private VideoView videoView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //progressBar = findViewById(R.id.progressbarId);
        videoView = findViewById(R.id.welcomevideoViewId);
        Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.welcome_animation);
        videoView.setVideoURI(uri);
        videoView.start();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                doWork();

                   SharedPreferences sharedPreferences2 = getSharedPreferences("logoutdemo", Context.MODE_PRIVATE);
                    int n = sharedPreferences2.getInt("logout",0);
                    if (n==0){
                        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                        startActivity(intent);
                        finish();
                    }else {
                        Intent intent = new Intent(getApplicationContext(),HomeActivity.class);
                        startActivity(intent);
                        finish();
                    }

               }

           // }
        });
        thread.start();
    }

    private void doWork() {
       for (int progress=14;progress<=100;progress = progress+14){
           try {
               Thread.sleep(1000);
              // progressBar.setProgress(progress);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
       }
    }

}