package com.example.gridview;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class Part1TextClockActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part1_text_clock);
        this.setTitle("Text Clock");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        LinearLayout linearLayout = findViewById(R.id.Part1TextClockActivityId);
        if (loadBackgroundColor()!=getResources().getColor(R.color.background_color)){
            linearLayout.setBackgroundColor(loadBackgroundColor());
        }
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