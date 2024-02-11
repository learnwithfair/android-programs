package com.example.gridview;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ZoomControls;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class Part1ZoomControlerActivity extends AppCompatActivity {
    private ImageView imageView;
    private ZoomControls controls;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part1_zoom_controler);
        this.setTitle("Zoom Controller");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        LinearLayout linearLayout = findViewById(R.id.Part1ZoomControlerActivityId);
        if (loadBackgroundColor()!=getResources().getColor(R.color.background_color)){
            linearLayout.setBackgroundColor(loadBackgroundColor());
        }
        imageView = findViewById(R.id.part1ZoomControllerImageViewId);
        controls = findViewById(R.id.part1ZoomControllerId);
        controls.setOnZoomInClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float x = imageView.getScaleX();
                float y = imageView.getScaleY();
                if(x>4 && y >4){
                    imageView.setScaleX((float) x);
                    imageView.setScaleY((float) y);
                }else {
                    imageView.setScaleX((float) x + 1);
                    imageView.setScaleY((float) y + 1);
                }

            }
        });
        controls.setOnZoomOutClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float x = imageView.getScaleX();
                float y =  imageView.getScaleY();
                if(x<=1&&y<=1){
                    imageView.setScaleX((float) x);
                    imageView.setScaleY((float) y);
                }else {
                    imageView.setScaleX((float) x - 1);
                    imageView.setScaleY((float) y - 1);
                }

            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()==android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
    public int loadBackgroundColor(){
        SharedPreferences preferences = getSharedPreferences("background", Context.MODE_PRIVATE);
        return  preferences.getInt("mycolor",getResources().getColor(R.color.background_color));
    }
}