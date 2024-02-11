package com.example.gridview;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class Part4SpinnerActivity extends AppCompatActivity {
    private Spinner spinner;
    CustomAdapter adapter;
    int[] flags = {R.drawable.afghanistan,R.drawable.algeria,R.drawable.argentina,R.drawable.austria,
            R.drawable.azerbaijan,R.drawable.bangladesh,R.drawable.belgium,R.drawable.benin,
            R.drawable.brazil,R.drawable.bulgaria,R.drawable.cabo_verde,R.drawable.canada,R.drawable.china,
            R.drawable.djibouti,R.drawable.ecuador,R.drawable.ghana,R.drawable.grenada,
            R.drawable.india,R.drawable.japan,R.drawable.kenya,R.drawable.malawi,R.drawable.mauritania,
            R.drawable.montenegro,R.drawable.pakistan,R.drawable.papua_new_guinea,R.drawable.saudi_arabia,
    };
    String[] countryNames;
    int i = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part4_spinner);
        this.setTitle("Spinner");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        LinearLayout linearLayout = findViewById(R.id.Part4SpinnerActivityId);
        if (loadBackgroundColor()!=getResources().getColor(R.color.background_color)){
            linearLayout.setBackgroundColor(loadBackgroundColor());
        }
        countryNames = getResources().getStringArray(R.array.country_names);
        spinner = findViewById(R.id.part4SpinnerId);
        adapter = new CustomAdapter(this,countryNames,flags);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String value =countryNames[position];
                if (i==0){
                    i++;
                }else {

                    Toast.makeText(Part4SpinnerActivity.this, value, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

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