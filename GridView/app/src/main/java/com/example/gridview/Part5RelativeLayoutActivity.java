package com.example.gridview;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class Part5RelativeLayoutActivity extends AppCompatActivity implements View.OnClickListener {
    private Button button1,button2,button3,button4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part5_relative_layout);
        this.setTitle("Relative Layout");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        RelativeLayout relativeLayout = findViewById(R.id.Part5RelativeLayoutActivityId);
        if (loadBackgroundColor()!=getResources().getColor(R.color.background_color)){
            relativeLayout.setBackgroundColor(loadBackgroundColor());
        }
        button1 = findViewById(R.id.Part5RelativeLayoutbutton1Id);
        button2 = findViewById(R.id.Part5RelativeLayoutbutton2Id);
        button3 = findViewById(R.id.Part5RelativeLayoutbutton3Id);
        button4 = findViewById(R.id.Part5RelativeLayoutbutton4Id);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
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
        if (v.getId()==R.id.Part5RelativeLayoutbutton1Id){
            String value = button1.getText().toString();
            Toast.makeText(this, value, Toast.LENGTH_SHORT).show();
        } else if (v.getId()==R.id.Part5RelativeLayoutbutton2Id){
            String value = button2.getText().toString();
            Toast.makeText(this, value, Toast.LENGTH_SHORT).show();
        } else if (v.getId()==R.id.Part5RelativeLayoutbutton3Id){
            String value = button3.getText().toString();
            Toast.makeText(this, value, Toast.LENGTH_SHORT).show();
        }else if (v.getId()==R.id.Part5RelativeLayoutbutton4Id){
            String value = button4.getText().toString();
            Toast.makeText(this, value, Toast.LENGTH_SHORT).show();
        }
    }
    public int loadBackgroundColor(){
        SharedPreferences preferences = getSharedPreferences("background", Context.MODE_PRIVATE);
        return  preferences.getInt("mycolor",getResources().getColor(R.color.background_color));
    }
}