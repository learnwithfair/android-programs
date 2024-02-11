package com.example.timepicker_dialog;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private Button button;
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textViewId);
        button = findViewById(R.id.buttonId);
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
        TimePicker timePicker = new TimePicker(MainActivity.this);
        timePicker.setIs24HourView(false);
        int hour = timePicker.getHour();
        int minutes = timePicker.getMinute();
        TimePickerDialog timePickerDialog = new TimePickerDialog(MainActivity.this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                textView.setText("Current Time : "+hourOfDay+":"+minute);
            }
        },hour,minutes,false);
        timePickerDialog.show();
    }
}