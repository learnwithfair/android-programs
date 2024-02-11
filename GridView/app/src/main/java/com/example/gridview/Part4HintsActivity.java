package com.example.gridview;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SearchView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class Part4HintsActivity extends AppCompatActivity {
    private ListView listView;
    ArrayAdapter<String> adapter;
    private String[] hints;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part4_hints);
        this.setTitle("Part-4 Hint's");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        LinearLayout linearLayout = findViewById(R.id.Part4HintsActivityId);
        if (loadBackgroundColor()!=getResources().getColor(R.color.background_color)){
            linearLayout.setBackgroundColor(loadBackgroundColor());
        }
        listView = findViewById(R.id.part4HintsListViewId);
        hints = getResources().getStringArray(R.array.part4Hintstext);
        adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,hints);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String value = adapter.getItem(position);
                if(value.equals(hints[0])){
                    Intent intent = new Intent(getApplicationContext(),Part4ArrayAdapterActivity.class);
                    startActivity(intent);
                } else if (value.equals(hints[1]))
                {
                    Intent intent = new Intent(getApplicationContext(),Part4CustomListView.class);
                    startActivity(intent);
                }else if (value.equals(hints[2]))
                {
                    Intent intent = new Intent(getApplicationContext(),Part4HintsActivity.class);
                    startActivity(intent);
                }else if (value.equals(hints[3]))
                {
                    Intent intent = new Intent(getApplicationContext(),Part4CustomListView.class);
                    startActivity(intent);
                }else if (value.equals(hints[4]))
                {
                    Intent intent = new Intent(getApplicationContext(),Part2Activity.class);
                    startActivity(intent);
                }else if (value.equals(hints[5]))
                {
                    Intent intent = new Intent(getApplicationContext(),Part4HintsActivity.class);
                    startActivity(intent);
                }else if (value.equals(hints[6])){
                    Intent intent = new Intent(getApplicationContext(),Part4ArrayGridViewActivity.class);
                    startActivity(intent);
                }else if (value.equals(hints[7])){
                    Intent intent = new Intent(getApplicationContext(),Part4CustomGridViewActivity.class);
                    startActivity(intent);
                }else if (value.equals(hints[8])){
                    Intent intent = new Intent(getApplicationContext(),Part4RecyclerViewActivity.class);
                    startActivity(intent);
                }else if (value.equals(hints[9])){
                    Intent intent = new Intent(getApplicationContext(),HomeActivity.class);
                    startActivity(intent);
                }else if (value.equals(hints[10])){
                    Intent intent = new Intent(getApplicationContext(),Part4AutoCompleteTextViewActivity.class);
                    startActivity(intent);
                }else if (value.equals(hints[11])){
                    Intent intent = new Intent(getApplicationContext(),Part4ExpandableListViewActivity.class);
                    startActivity(intent);
                }else if (value.equals(hints[12])){
                    Intent intent = new Intent(getApplicationContext(),Part4SpinnerActivity.class);
                    startActivity(intent);
                }else if (value.equals(hints[13])){
                    Intent intent = new Intent(getApplicationContext(),Part2Activity.class);
                    startActivity(intent);
                }else if (value.equals(hints[14])){
                    Intent intent = new Intent(getApplicationContext(),Part4MediaPlayerActivity.class);
                    startActivity(intent);
                }else if (value.equals(hints[15])){
                    Intent intent = new Intent(getApplicationContext(), Part4MediaPlayerActivity.class);
                    startActivity(intent);
                }else if (value.equals(hints[16])){
                    Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                    startActivity(intent);
                }else if (value.equals(hints[17])){
                    Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                    startActivity(intent);
                }else if (value.equals(hints[18])){
                    Intent intent = new Intent(getApplicationContext(), Part4HTMLContentActivity.class);
                    startActivity(intent);
                }else if (value.equals(hints[19])){
                    Intent intent = new Intent(getApplicationContext(), WelcomeActivity.class);
                    startActivity(intent);
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.search_menu_item,menu);
        MenuItem menuItem = menu.findItem(R.id.part1hintsSearchViewId);
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setQueryHint("Search");
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
        return super.onCreateOptionsMenu(menu);
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