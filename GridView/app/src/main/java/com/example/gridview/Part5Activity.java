package com.example.gridview;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class Part5Activity extends AppCompatActivity implements View.OnClickListener {
 private Button relativelayoutButton,tableLayoutButton,frameLayoutButton,tabLayoutButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part5);
        this.setTitle("Part-5");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        LinearLayout linearLayout = findViewById(R.id.Part5ActivityId);
        if (loadBackgroundColor()!=getResources().getColor(R.color.background_color)){
            linearLayout.setBackgroundColor(loadBackgroundColor());
        }
        relativelayoutButton = findViewById(R.id.part5RelativeLayoutButtonId);
        tableLayoutButton = findViewById(R.id.part5TableLayoutButtonId);
        frameLayoutButton = findViewById(R.id.part5FrameLayoutButtonId);
        tabLayoutButton = findViewById(R.id.part5TabLayoutButtonId);
        relativelayoutButton.setOnClickListener(this);
        tableLayoutButton.setOnClickListener(this);
        frameLayoutButton.setOnClickListener(this);
        tabLayoutButton.setOnClickListener(this);
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
        if (v.getId()==R.id.part5RelativeLayoutButtonId){
            Intent intent = new Intent(getApplicationContext(),Part5RelativeLayoutActivity.class);
            startActivity(intent);
        }else if (v.getId()==R.id.part5TableLayoutButtonId){
            Intent intent = new Intent(getApplicationContext(),Part5TableLayoutActivity.class);
            startActivity(intent);
        }else if (v.getId()==R.id.part5FrameLayoutButtonId){
            Intent intent = new Intent(getApplicationContext(),Part5FrameLayoutActivity.class);
            startActivity(intent);

        }else if (v.getId()==R.id.part5TabLayoutButtonId){
            Intent intent = new Intent(getApplicationContext(),Part5TabLayout.class);
            startActivity(intent);

        }
    }
    public int loadBackgroundColor(){
        SharedPreferences preferences = getSharedPreferences("background", Context.MODE_PRIVATE);
        return  preferences.getInt("mycolor",getResources().getColor(R.color.background_color));
    }
}