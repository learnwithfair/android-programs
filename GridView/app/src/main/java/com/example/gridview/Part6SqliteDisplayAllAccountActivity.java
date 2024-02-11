package com.example.gridview;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Part6SqliteDisplayAllAccountActivity extends AppCompatActivity {

    private ListView listView;
    private ArrayList<String> info;
    private ArrayList<String> SL_Number;
    private ArrayList<String> names;
    int i=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part6_sqlite_display_all_account);
        this.setTitle("All Account Info");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        LinearLayout linearLayout = findViewById(R.id.Part6SqliteDisplayAllAccountActivityId);
        if (loadBackgroundColor()!=getResources().getColor(R.color.background_color)){
            linearLayout.setBackgroundColor(loadBackgroundColor());
        }
        listView = findViewById(R.id.part6sqliteShowAllAccountlistViewId);
        info = new ArrayList();
        SL_Number = new ArrayList();
        names = new ArrayList();
        MyDatabase myDatabase = new MyDatabase(this);
        Cursor cursor = myDatabase.displayAllData();
        while (cursor.moveToNext()){
            i++;
            StringBuffer str = new StringBuffer();
            str.append("ID : "+cursor.getString(1)+"\n");
            str.append("Password : "+cursor.getString(2)+"\n");
            str.append("Name : "+cursor.getString(3)+"\n");
            str.append("Age : "+cursor.getString(4)+"\n");
            str.append("Gender : "+cursor.getString(5)+"\n");
            str.append("E-mail : "+cursor.getString(6)+"\n");
            info.add((str.toString()));
            String n = Integer.toString(i);
            SL_Number.add(n);
            names.add((cursor.getString(3)));
        }
        SqliteCustomAdapter adapter = new SqliteCustomAdapter(this,SL_Number,info);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String values = names.get(position);
                Toast.makeText(Part6SqliteDisplayAllAccountActivity.this, values, Toast.LENGTH_SHORT).show();
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

