package com.example.gridview;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class Part1DatePickerDialogActivity extends AppCompatActivity {
    private TextView textView;
    private Button setbutton;
int day,month,year;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part1_date_picker_dialog);
        this.setTitle("Date Picker Dialog");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        LinearLayout linearLayout = findViewById(R.id.Part1DatePickerDialogActivityId);
        if (loadBackgroundColor()!=getResources().getColor(R.color.background_color)){
            linearLayout.setBackgroundColor(loadBackgroundColor());
        }
        textView = findViewById(R.id.Part1DatePickerDialogTextViewId);
        setbutton = findViewById(R.id.part1DatePickerDialogButtonId);
        DatePicker datePicker = new DatePicker(this);
        day = datePicker.getDayOfMonth();
        month = datePicker.getMonth()+1;
         year = datePicker.getYear();
         setbutton.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 showDate();
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
    public void showDate(){
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                textView.setText("Current Date : "+dayOfMonth+"/"+(month+1)+"/"+year);
            }
        },year,month,day);
        datePickerDialog.show();
    }
    public int loadBackgroundColor(){
        SharedPreferences preferences = getSharedPreferences("background", Context.MODE_PRIVATE);
        return  preferences.getInt("mycolor",getResources().getColor(R.color.background_color));
    }
}