package com.example.timepicker;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private Button button;
    private TimePicker timePicker;
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textViewId);
        button = findViewById(R.id.buttonId);
        timePicker = findViewById(R.id.timepickerId);
        showTime();
        button.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
               showTime();
            }
        });
    }
    @RequiresApi(api = Build.VERSION_CODES.M)
    private void showTime() {
        timePicker.setIs24HourView(false);
        int minutes = timePicker.getMinute();
        int hour = timePicker.getHour();
        if(hour>12&&hour<20){
            hour = (hour%10)-2;
            textView.setText("Current Time : "+hour+":"+minutes);
        }else if(hour>19){
            hour = (hour%10)+8;
            textView.setText("Current Time : "+hour+":"+minutes);
        }
        else {
            textView.setText("Current Time : " + hour + ":" + minutes);
        }
    }
}