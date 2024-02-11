package com.example.custom_toast;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.buttonId);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater inflater = getLayoutInflater();
                View view = inflater.inflate(R.layout.custom_layout, (ViewGroup) findViewById(R.id.customToastId));
                Toast toast = new Toast(MainActivity.this);
                toast.setView(view);
                toast.setDuration(Toast.LENGTH_LONG);
                toast.show();
            }
        });
    }
}