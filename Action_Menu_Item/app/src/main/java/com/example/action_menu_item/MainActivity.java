package com.example.action_menu_item;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private SearchView searchView;
    String[] countryNames;
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setTitle("Country Names");
        listView = findViewById(R.id.listViewId);
        countryNames = getResources().getStringArray(R.array.country_names);
        adapter = new ArrayAdapter(getApplicationContext(),R.layout.sample_layout,R.id.textViewId,countryNames);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String value =  adapter.getItem(position).toString();
                Toast.makeText(MainActivity.this, value, Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_layout,menu);
        searchData(menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.settingId){
            String value = item.getTitle().toString();
            Toast.makeText(this, value, Toast.LENGTH_SHORT).show();
            return true;
        }else if(item.getItemId()==R.id.searchViewId){

            return true;
        }else if(item.getItemId()==R.id.shareId){
            String value = item.getTitle().toString();
            Toast.makeText(this, value, Toast.LENGTH_SHORT).show();
            return true;
        }else if(item.getItemId()==R.id.feedbackId){
            String value = item.getTitle().toString();
            Toast.makeText(this, value, Toast.LENGTH_SHORT).show();
            return true;
        }else if(item.getItemId()==R.id.aboutId){
            String value = item.getTitle().toString();
            Toast.makeText(this, value, Toast.LENGTH_SHORT).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public void searchData(Menu menu){
        MenuItem menuItem = menu.findItem(R.id.searchViewId);
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setQueryHint("Search here..");
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
}