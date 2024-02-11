package com.example.gridview;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class Part3ImplicitActivity extends AppCompatActivity implements View.OnClickListener {
    private Button visitMeButton,contactMeButton,locationMeButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part3_implicit);
        this.setTitle("Implicit Intent");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setBackgroundDrawable(getResources().getDrawable(R.color.magenta_color));
        visitMeButton = findViewById(R.id.part3ImplicitBangladeshVisitMeButtonId);
        contactMeButton = findViewById(R.id.part3ImplicitContactMeButtonId);
        locationMeButton = findViewById(R.id.part3ImpliciLocationMeButtonId);
        visitMeButton.setOnClickListener(this);
        contactMeButton.setOnClickListener(this);
        locationMeButton.setOnClickListener(this);
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
        if (v.getId()==R.id.part3ImplicitBangladeshVisitMeButtonId){
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("mailto:rahatul.ice.09.pust@gmail.com"));
            startActivity(intent);
        }else if (v.getId()==R.id.part3ImplicitContactMeButtonId){
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:+8801790224950"));
            startActivity(intent);
        }else if (v.getId()==R.id.part3ImpliciLocationMeButtonId){
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:24.896837, 91.902739"));
            startActivity(intent);
        }
    }
    public int loadBackgroundColor(){
        SharedPreferences preferences = getSharedPreferences("background", Context.MODE_PRIVATE);
        return  preferences.getInt("mycolor",getResources().getColor(R.color.background_color));
    }
}