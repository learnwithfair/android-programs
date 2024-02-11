package com.example.gridview;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class Part4CustomGridViewActivity extends AppCompatActivity {
    String[] countryNames;
    private GridView gridView;
    Part4GridViewCustomAdapter adapter;
    int[] flags = {R.drawable.afghanistan,R.drawable.algeria,R.drawable.argentina,R.drawable.austria,
            R.drawable.azerbaijan,R.drawable.bangladesh,R.drawable.belgium,R.drawable.benin,
            R.drawable.brazil,R.drawable.bulgaria,R.drawable.cabo_verde,R.drawable.canada,R.drawable.china,
            R.drawable.djibouti,R.drawable.ecuador,R.drawable.ghana,R.drawable.grenada,
            R.drawable.india,R.drawable.japan,R.drawable.kenya,R.drawable.malawi,R.drawable.mauritania,
            R.drawable.montenegro,R.drawable.pakistan,R.drawable.papua_new_guinea,R.drawable.saudi_arabia,
            R.drawable.kenya,
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part4_custom_grid_view);
        this.setTitle("Custom Grid View");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        LinearLayout linearLayout = findViewById(R.id.Part4CustomGridViewActivityId);
        if (loadBackgroundColor()!=getResources().getColor(R.color.background_color)){
            linearLayout.setBackgroundColor(loadBackgroundColor());
        }
        gridView = findViewById(R.id.part4CustomgridViewId);
        countryNames= getResources().getStringArray(R.array.country_names);
        adapter = new Part4GridViewCustomAdapter(this,countryNames,flags);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String value = countryNames[position];
                Toast.makeText(getApplicationContext(), value, Toast.LENGTH_SHORT).show();
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