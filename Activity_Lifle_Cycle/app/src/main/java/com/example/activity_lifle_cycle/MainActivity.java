package com.example.activity_lifle_cycle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this, "onCreate is called", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onStart() {
        Toast.makeText(this, "onStart is called", Toast.LENGTH_SHORT).show();
        super.onStart();
    }
    @Override
    protected void onResume() {
        Toast.makeText(this, "onResume is called", Toast.LENGTH_SHORT).show();
        super.onResume();
    }
    @Override
    protected void onPause() {
        Toast.makeText(this, "onPause is called", Toast.LENGTH_SHORT).show();
        super.onPause();
    }
    @Override
    protected void onStop() {
        Toast.makeText(this, "onStop is called", Toast.LENGTH_SHORT).show();
        super.onStop();
    }
    @Override
    protected void onRestart() {
        Toast.makeText(this, "onRestart is called", Toast.LENGTH_SHORT).show();
        super.onRestart();
    }
    @Override
    protected void onDestroy() {
        Toast.makeText(this, "onDestroy is called", Toast.LENGTH_SHORT).show();
        super.onDestroy();
    }
}