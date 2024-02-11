package com.example.datepicker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private DatePicker datePicker;
    private TextView textView;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        datePicker = findViewById(R.id.datePickerId);
        textView= findViewById(R.id.textViewId);
        button = findViewById(R.id.buttonId);
        showDate();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDate();
            }
        });
    }

    private void showDate() {
        int day = datePicker.getDayOfMonth();
        int month = datePicker.getMonth()+1;
        int year = datePicker.getYear();
        textView.setText("Current Date : "+day+"/"+month+"/"+year);
    }

}