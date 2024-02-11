package com.example.splash_screen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {
    private ProgressBar progressBar;
    int progress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //title bar hide
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //Actionbar hide
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        progressBar = findViewById(R.id.progressbarId);
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                doWork();
                  Intent intent = new Intent(getApplicationContext(),SecondAcivity.class);
                  startActivity(intent);
                finish();
            }
        });
        thread.start();
    }
    private void doWork() {
        for (progress=20;progress<=100;progress=progress+20){
            try {
                Thread.sleep(1000);
                progressBar.setProgress(progress);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}