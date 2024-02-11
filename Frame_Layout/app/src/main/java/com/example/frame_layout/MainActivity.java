package com.example.frame_layout;

import androidx.appcompat.app.AppCompatActivity;

import android.opengl.Visibility;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private LinearLayout bangladeshimg,saidiimg,azerbaijanimg,afghanistanimg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bangladeshimg = findViewById(R.id.bangladeshId);
        azerbaijanimg = findViewById(R.id.azerbaijanId);
        afghanistanimg = findViewById(R.id.afghanistanId);
        saidiimg = findViewById(R.id.saudiId);
        bangladeshimg.setOnClickListener(this);
        azerbaijanimg.setOnClickListener(this);
        afghanistanimg.setOnClickListener(this);
        saidiimg.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.bangladeshId){
            bangladeshimg.setVisibility(View.GONE);
            saidiimg.setVisibility(View.VISIBLE);
        }else if(v.getId()==R.id.saudiId){
            saidiimg.setVisibility(View.GONE);
            azerbaijanimg.setVisibility(View.VISIBLE);
        }else if(v.getId()==R.id.azerbaijanId){
            azerbaijanimg.setVisibility(View.GONE);
            afghanistanimg.setVisibility(View.VISIBLE);
        }else if(v.getId()==R.id.afghanistanId){
            afghanistanimg.setVisibility(View.GONE);
            bangladeshimg.setVisibility(View.VISIBLE);
        }
    }
}