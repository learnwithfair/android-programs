package com.example.gridview;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class Part4RecyclerViewActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private String[] CountryNames;
    RecyclerViewAdapter adapter;
    int[] flags = {R.drawable.afghanistan,R.drawable.algeria,R.drawable.argentina,R.drawable.austria,
            R.drawable.azerbaijan,R.drawable.bangladesh,R.drawable.belgium,R.drawable.benin,
            R.drawable.brazil,R.drawable.bulgaria,R.drawable.cabo_verde,R.drawable.canada,R.drawable.china,
            R.drawable.djibouti,R.drawable.ecuador,R.drawable.ghana,R.drawable.grenada,
            R.drawable.india,R.drawable.japan,R.drawable.kenya,R.drawable.malawi,R.drawable.mauritania,
            R.drawable.montenegro,R.drawable.pakistan,R.drawable.papua_new_guinea,R.drawable.saudi_arabia,
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part4_recycler_view);
        this.setTitle("Recycler View");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        LinearLayout linearLayout = findViewById(R.id.Part4RecyclerViewActivityId);
        if (loadBackgroundColor()!=getResources().getColor(R.color.background_color)){
            linearLayout.setBackgroundColor(loadBackgroundColor());
        }
        CountryNames = getResources().getStringArray(R.array.country_names);
        recyclerView = findViewById(R.id.part4RecyclerViewId);
        adapter = new RecyclerViewAdapter(CountryNames,flags,this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter.setOnItemClickListener(new RecyclerViewAdapter.ClickListener() {
            @Override
            public void OnClickListener(int position, View view) {
                String value = CountryNames[position];
                Toast.makeText(Part4RecyclerViewActivity.this, value, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void OnLongClickListener(int position, View view) {
                String value = CountryNames[position];
                Toast.makeText(Part4RecyclerViewActivity.this, "Long Click "+value, Toast.LENGTH_SHORT).show();
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