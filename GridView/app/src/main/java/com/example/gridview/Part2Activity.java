package com.example.gridview;


import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SearchView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


public class Part2Activity extends AppCompatActivity {
    String[] names;
    private ListView listview;
    private SearchView searchView;
   private Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part2);
        this.setTitle("Android Fundamental");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        LinearLayout linearLayout = findViewById(R.id.Part2ActivityId);
        if (loadBackgroundColor()!=getResources().getColor(R.color.background_color)){
            linearLayout.setBackgroundColor(loadBackgroundColor());
        }
        names = getResources().getStringArray(R.array.androidFundamentalText);
        listview = findViewById(R.id.part2FundamentallistViewId);
        searchView = findViewById(R.id.part2FundamentalsearchViewId);
        final ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, names);
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String value = adapter.getItem(position);
                if (value.equals(names[0])){
                    fragment = new Part2AndroidIntroductionFragment();
                    FragmentManager fragmentManager = getFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.part2FundamentalfragmentId,fragment);
                    fragmentTransaction.commit();
                } else if (value.equals(names[1])){
                    getFragmentManager().beginTransaction().replace(R.id.part2FundamentalfragmentId,new Part2HistoryFragment()).commit();
                }else if (value.equals(names[2])){
                    getFragmentManager().beginTransaction().replace(R.id.part2FundamentalfragmentId,new Part2FeaturesFragment()).commit();
                }else if (value.equals(names[3])){
                    getFragmentManager().beginTransaction().replace(R.id.part2FundamentalfragmentId,new Part2VersionFragment ()).commit();
                }else if (value.equals(names[4])){
                    getFragmentManager().beginTransaction().replace(R.id.part2FundamentalfragmentId,new Part2RequiredSoftwateFragment ()).commit();
                }else if (value.equals(names[5])){
                    getFragmentManager().beginTransaction().replace(R.id.part2FundamentalfragmentId,new Part2ViewGroupFragment ()).commit();
                }else if (value.equals(names[6])){
                    getFragmentManager().beginTransaction().replace(R.id.part2FundamentalfragmentId,new Part2AndroidTricksFragment ()).commit();
                }

            }
        });
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
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