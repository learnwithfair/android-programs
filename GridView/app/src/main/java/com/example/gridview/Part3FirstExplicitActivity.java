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

public class Part3FirstExplicitActivity extends AppCompatActivity implements View.OnClickListener {
    private Button bangladeshButton, indiaButton,pakistanButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part3_first_explicit);
        this.setTitle("Explicit Intent");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        LinearLayout linearLayout = findViewById(R.id.Part3FirstExplicitActivityId);
        if (loadBackgroundColor()!=getResources().getColor(R.color.background_color)){
            linearLayout.setBackgroundColor(loadBackgroundColor());
        }
        bangladeshButton = findViewById(R.id.part3ExplicitBangladeshButtonId);
        indiaButton = findViewById(R.id.part3ExpliciIndiatButtonId);
        pakistanButton = findViewById(R.id.part3ExpliciPakistantButtonId);
        bangladeshButton.setOnClickListener(this);
        indiaButton.setOnClickListener(this);
        pakistanButton.setOnClickListener(this);
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

        if (v.getId()==R.id.part3ExplicitBangladeshButtonId){
            Intent intent = new Intent(getApplicationContext(),Part3ExplicitCountryDetailsActivity.class);
            intent.putExtra("key","bangladesh");
            startActivity(intent);
        }else if (v.getId()==R.id.part3ExpliciIndiatButtonId){
            Intent intent = new Intent(getApplicationContext(),Part3ExplicitCountryDetailsActivity.class);
            intent.putExtra("key","india");
            startActivity(intent);
        }else if (v.getId()==R.id.part3ExpliciPakistantButtonId){
            Intent intent = new Intent(getApplicationContext(),Part3ExplicitCountryDetailsActivity.class);
            intent.putExtra("key","pakistan");
            startActivity(intent);
        }
    }
    public int loadBackgroundColor(){
        SharedPreferences preferences = getSharedPreferences("background", Context.MODE_PRIVATE);
        return  preferences.getInt("mycolor",getResources().getColor(R.color.background_color));
    }
}