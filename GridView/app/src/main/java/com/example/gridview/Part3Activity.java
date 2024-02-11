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

public class Part3Activity extends AppCompatActivity implements View.OnClickListener {
    private Button ExplicitButton,ImplicitButon,ActivityForResultButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part3);
        this.setTitle("Part-3");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        LinearLayout linearLayout = findViewById(R.id.Part3ActivityId);
        if (loadBackgroundColor()!=getResources().getColor(R.color.background_color)){
            linearLayout.setBackgroundColor(loadBackgroundColor());
        }
        ExplicitButton = findViewById(R.id.part3ExplicitButtonId);
        ImplicitButon = findViewById(R.id.part3ImplicitButtonId);
        ActivityForResultButton = findViewById(R.id.part3ActivityForResultButtonId);
        ExplicitButton.setOnClickListener(this);
        ImplicitButon.setOnClickListener(this);
        ActivityForResultButton.setOnClickListener(this);
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
        if (v.getId()==R.id.part3ExplicitButtonId){
            Intent intent = new Intent(getApplicationContext(),Part3FirstExplicitActivity.class);
            startActivity(intent);
        } if (v.getId()==R.id.part3ImplicitButtonId){
            Intent intent = new Intent(getApplicationContext(),Part3ImplicitActivity.class);
            startActivity(intent);
        }if (v.getId()==R.id.part3ActivityForResultButtonId){
            Intent intent = new Intent(getApplicationContext(),Part3ActivitiForResultActivity.class);
            startActivity(intent);
        }
    }
    public int loadBackgroundColor(){
        SharedPreferences preferences = getSharedPreferences("background", Context.MODE_PRIVATE);
        return  preferences.getInt("mycolor",getResources().getColor(R.color.background_color));
    }
}