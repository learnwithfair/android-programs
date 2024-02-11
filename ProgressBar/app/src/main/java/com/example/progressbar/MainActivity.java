package com.example.progressbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button startButton,stopButton;
    private ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startButton = findViewById(R.id.startbuttonId);
        stopButton = findViewById(R.id.stopButtonId);
        progressBar = findViewById(R.id.progressBarId);
        stopButton.setOnClickListener(this);
        startButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.startbuttonId){
            progressBar.setVisibility(View.VISIBLE);
        }else if(v.getId()==R.id.stopButtonId){
            progressBar.setVisibility(View.GONE);
        }
    }
}