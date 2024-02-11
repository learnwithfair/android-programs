package com.example.customadapter;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;
import android.widget.MultiAutoCompleteTextView;
import android.widget.SearchView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private AutoCompleteTextView autoCompleteTextView;
    String[] countryNames;
    CustomAdapter adapter;
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
        autoCompleteTextView = findViewById(R.id.autoCompleteId);
        listView = findViewById(R.id.listViewId);
        countryNames = getResources().getStringArray(R.array.country_names);
        adapter = new CustomAdapter(this,countryNames,flags);
        listView.setAdapter(adapter);
        ArrayAdapter adapter1 = new ArrayAdapter(this,android.R.layout.simple_list_item_multiple_choice,countryNames);
        autoCompleteTextView.setThreshold(1);
        autoCompleteTextView.setAdapter(adapter1);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String value = countryNames[position];
                Toast.makeText(MainActivity.this, value, Toast.LENGTH_SHORT).show();
            }
        });

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_layout,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()==R.id.settingId){
            String value = item.getTitle().toString();
            Toast.makeText(this, value, Toast.LENGTH_SHORT).show();
        }else if (item.getItemId()==R.id.shareId){
            String value = item.getTitle().toString();
            Toast.makeText(this, value, Toast.LENGTH_SHORT).show();
        }else if (item.getItemId()==R.id.searchViewId){
            String value = item.getTitle().toString();
            Toast.makeText(this, value, Toast.LENGTH_SHORT).show();
        }else if (item.getItemId()==R.id.feedbackId){
            String value = item.getTitle().toString();
            Toast.makeText(this, value, Toast.LENGTH_SHORT).show();
        }else if (item.getItemId()==R.id.aboutId){
            String value = item.getTitle().toString();
            Toast.makeText(this, value, Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
}