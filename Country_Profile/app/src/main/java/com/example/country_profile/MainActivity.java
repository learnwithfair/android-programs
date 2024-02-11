package com.example.country_profile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button bangladeshbtn,indiabtn,pakistanbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bangladeshbtn = findViewById(R.id.bangladeshId);
        indiabtn = findViewById(R.id.indiaId);
        pakistanbtn = findViewById(R.id.pakistanId);
        bangladeshbtn.setOnClickListener(this);
        indiabtn.setOnClickListener(this);
        pakistanbtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.bangladeshId){
            Intent intent = new Intent(getApplicationContext(),ProfileActivity.class);
            intent.putExtra("key","bangladesh");
            startActivity(intent);
        }else if (v.getId()==R.id.indiaId){
            Intent intent = new Intent(getApplicationContext(),ProfileActivity.class);
            intent.putExtra("key","india");
            startActivity(intent);
        }else if (v.getId()==R.id.pakistanId){
            Intent intent = new Intent(getApplicationContext(),ProfileActivity.class);
            intent.putExtra("key","pakistan");
            startActivity(intent);
        }
    }
}