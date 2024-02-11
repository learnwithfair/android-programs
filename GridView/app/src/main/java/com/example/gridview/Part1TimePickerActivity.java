package com.example.gridview;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

public class Part1TimePickerActivity extends AppCompatActivity {
    private TextView textView;
    private TimePicker timePicker;
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part1_time_picker);
        this.setTitle("Time Picker");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        LinearLayout linearLayout = findViewById(R.id.Part1TimePickerActivityId);
        if (loadBackgroundColor()!=getResources().getColor(R.color.background_color)){
            linearLayout.setBackgroundColor(loadBackgroundColor());
        }
        timePicker = findViewById(R.id.part1TimePickerId);
        textView = findViewById(R.id.Part1TimePickerTextViewId);
        timePicker.setIs24HourView(false);
        int minute = timePicker.getMinute();
        int hour = timePicker.getHour();
            textView.setText("Current Time : "+hour+":"+minute);

        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
          @Override
          public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {

                  textView.setText("Current Time : "+hourOfDay+":"+minute);
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
    public int loadBackgroundColor(){
        SharedPreferences preferences = getSharedPreferences("background", Context.MODE_PRIVATE);
        return  preferences.getInt("mycolor",getResources().getColor(R.color.background_color));
    }
}