package com.example.gridview;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class Part5FrameLayoutActivity extends AppCompatActivity implements View.OnClickListener {
    private LinearLayout bangladeshimg,saidiimg,azerbaijanimg,afghanistanimg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part5_frame_layout);
        this.setTitle("Frame Layout");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        FrameLayout frameLayout = findViewById(R.id.Part5FrameLayoutActivityId);
        if (loadBackgroundColor()!=getResources().getColor(R.color.background_color)){
            frameLayout.setBackgroundColor(loadBackgroundColor());
        }
        bangladeshimg = findViewById(R.id.part5FrameLayoutbangladeshId);
        azerbaijanimg = findViewById(R.id.part5FrameLayoutazerbaijanId);
        afghanistanimg = findViewById(R.id.part5FrameLayoutafghanistanId);
        saidiimg = findViewById(R.id.part5FrameLayoutsaudiId);
        bangladeshimg.setOnClickListener(this);
        azerbaijanimg.setOnClickListener(this);
        afghanistanimg.setOnClickListener(this);
        saidiimg.setOnClickListener(this);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()==android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.part5FrameLayoutbangladeshId){
            bangladeshimg.setVisibility(View.GONE);
            saidiimg.setVisibility(View.VISIBLE);
        }else if(v.getId()==R.id.part5FrameLayoutsaudiId){
            saidiimg.setVisibility(View.GONE);
            azerbaijanimg.setVisibility(View.VISIBLE);
        }else if(v.getId()==R.id.part5FrameLayoutazerbaijanId){
            azerbaijanimg.setVisibility(View.GONE);
            afghanistanimg.setVisibility(View.VISIBLE);
        }else if(v.getId()==R.id.part5FrameLayoutafghanistanId){
            afghanistanimg.setVisibility(View.GONE);
            bangladeshimg.setVisibility(View.VISIBLE);
        }
    }
    public int loadBackgroundColor(){
        SharedPreferences preferences = getSharedPreferences("background", Context.MODE_PRIVATE);
        return  preferences.getInt("mycolor",getResources().getColor(R.color.background_color));
    }
}