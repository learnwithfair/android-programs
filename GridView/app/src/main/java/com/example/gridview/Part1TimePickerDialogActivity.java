package com.example.gridview;

import android.app.TimePickerDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

public class Part1TimePickerDialogActivity extends AppCompatActivity {
    private Button setTimeButton;
    private TextView textView;
    int hour,minute;
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part1__time_picker_dialog);
        this.setTitle("Time Picker Dialog");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        LinearLayout linearLayout = findViewById(R.id.Part1TimePickerDialogActivityId);
        if (loadBackgroundColor()!=getResources().getColor(R.color.background_color)){
            linearLayout.setBackgroundColor(loadBackgroundColor());
        }
        textView = findViewById(R.id.Part1TimePickerDialogTextViewId);
        setTimeButton = findViewById(R.id.part1TimePickerDialogButtonId);
        TimePicker timePicker = new TimePicker(this);
        timePicker.setIs24HourView(false);
        hour = timePicker.getHour();
        minute = timePicker.getMinute();
        setTimeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTime();
            }
        });

    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()==android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
    void showTime(){
        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                textView.setText("Current Time : "+hourOfDay+":"+minute);
            }
        },hour,minute,false);
        timePickerDialog.show();
    }
    public int loadBackgroundColor(){
        SharedPreferences preferences = getSharedPreferences("background", Context.MODE_PRIVATE);
        return  preferences.getInt("mycolor",getResources().getColor(R.color.background_color));
    }
}