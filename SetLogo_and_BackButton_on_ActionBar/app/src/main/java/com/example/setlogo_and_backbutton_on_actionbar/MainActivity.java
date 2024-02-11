package com.example.setlogo_and_backbutton_on_actionbar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       this.setTitle("Program-1");
       //for Actionbar edit
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        //for set logo
       getSupportActionBar().setLogo(R.drawable.rahatul);
       getSupportActionBar().setDisplayUseLogoEnabled(true);
        button = findViewById(R.id.buttonId);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),SecondActivity.class);
                startActivity(intent);
            }
        });
    }
}