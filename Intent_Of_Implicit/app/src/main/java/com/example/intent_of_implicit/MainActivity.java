package com.example.intent_of_implicit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button callmeButton,visitmeButton,locationmeButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        callmeButton = findViewById(R.id.callmeId);
        visitmeButton = findViewById(R.id.visitmeId);
        locationmeButton = findViewById(R.id.mylocationId);
        callmeButton.setOnClickListener(this);
        visitmeButton.setOnClickListener(this);
        locationmeButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.callmeId){
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:+8801790224950"));
            startActivity(intent);
        }else if(v.getId()==R.id.visitmeId){
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.pust.ac.bd"));
            startActivity(intent);
        }else if(v.getId()==R.id.mylocationId){
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:24.896837, 91.902739"));
            startActivity(intent);
        }
    }
}