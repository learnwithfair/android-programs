package com.example.share__feedback;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
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
 String[] counryNames;
 private ListView listView;
 ArrayAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setTitle("Country names");
        counryNames = getResources().getStringArray(R.array.country_names);
        listView = findViewById(R.id.listViewId);
        adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,counryNames);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               String value = adapter.getItem(position).toString();
                Toast.makeText(MainActivity.this, value, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = new MenuInflater(this);
        menuInflater.inflate(R.menu.menu_layout,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.settingId){
            String value = item.getTitle().toString().trim();
            Toast.makeText(this, value, Toast.LENGTH_SHORT).show();
            return true;
        }else if (item.getItemId()==R.id.shareId){
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");
            String subject = "C programing Apps";
            String body = "this apps is very helpful for learning C programing. It can easily find in Google search com.example.share__feedback ";
            intent.putExtra(Intent.EXTRA_SUBJECT,subject);
            intent.putExtra(Intent.EXTRA_TEXT,body);
            startActivity(Intent.createChooser(intent,"Share with"));
            return true;

        }else if (item.getItemId()==R.id.feedbackId){
           Intent intent = new Intent(getApplicationContext(),FeedbackActivity.class);
           startActivity(intent);
            return true;
        }else if (item.getItemId()==R.id.about_usId){
            String value = item.getTitle().toString().trim();
            Toast.makeText(this, value, Toast.LENGTH_SHORT).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}