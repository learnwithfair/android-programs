package com.example.toast;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
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

                   Toast toast = Toast.makeText(MainActivity.this,"This is Toast",Toast.LENGTH_LONG);
                   toast.setGravity(Gravity.CENTER,0,200);
                   toast.show();
                   /*//oR
                   Toast.makeText(MainActivity.this, "Exception : "+e, Toast.LENGTH_SHORT).show();*/
            }
        });
    }
}