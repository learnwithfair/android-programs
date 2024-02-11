package com.example.gridview;

import android.app.AlertDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class Part1CheckBoxActivity extends AppCompatActivity implements View.OnClickListener {
    private CheckBox cbox,ccbox,javabox,htmlbox;
    private Button showButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part1_check_box);
        this.setTitle("Check Box");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        LinearLayout linearLayout = findViewById(R.id.Part1CheckBoxActivityId);
        if (loadBackgroundColor()!=getResources().getColor(R.color.background_color)){
            linearLayout.setBackgroundColor(loadBackgroundColor());
        }
        cbox = findViewById(R.id.part1CCheckBoxId);
        ccbox = findViewById(R.id.part1CCCheckBoxId);
        javabox = findViewById(R.id.part1JavaCheckBoxId);
        htmlbox = findViewById(R.id.part1HtmlCheckBoxId);
        showButton = findViewById(R.id.part1CheckBoxShowButtonId);
        showButton.setOnClickListener(this);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()==android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {


        if (v.getId()==R.id.part1CheckBoxShowButtonId){
            StringBuffer str = new StringBuffer();
            if (cbox.isChecked()){
                String value = cbox.getText().toString().trim();
                str.append(value+"\n");
            }if (ccbox.isChecked()){
                String value = ccbox.getText().toString().trim();
                str.append(value+"\n");
            }if (javabox.isChecked()){
                String value = javabox.getText().toString().trim();
                str.append(value+"\n");
            }if (htmlbox.isChecked()){
                String value = htmlbox.getText().toString().trim();
                str.append(value+"\n");
            }
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("You Have Selected");
            builder.setMessage(str);
            builder.show();
        }

    }
    public int loadBackgroundColor(){
        SharedPreferences preferences = getSharedPreferences("background", Context.MODE_PRIVATE);
        return  preferences.getInt("mycolor",getResources().getColor(R.color.background_color));
    }

}