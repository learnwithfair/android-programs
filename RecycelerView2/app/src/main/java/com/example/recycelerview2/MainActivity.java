package com.example.recycelerview2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.recycelerview2.MyAdapter.ClickListener;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    MyAdapter adapter;
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
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerViewId);
        final String[] countryNames = getResources().getStringArray(R.array.country_names);
        adapter = new  MyAdapter(this,countryNames,flags);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter.SetOnItemClickListener(new ClickListener() {
            @Override
            public void OnClickListener(int position, View view) {
                Toast.makeText(MainActivity.this, "OnClickListener "+countryNames[position], Toast.LENGTH_SHORT).show();
            }

            @Override
            public void OnLongClickListener(int position, View view) {
                Toast.makeText(MainActivity.this, "OnLongClickListener "+countryNames[position], Toast.LENGTH_SHORT).show();
            }
        });

    }
}