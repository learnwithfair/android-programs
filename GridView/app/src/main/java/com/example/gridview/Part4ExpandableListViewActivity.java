package com.example.gridview;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;

public class Part4ExpandableListViewActivity extends AppCompatActivity {
    private ArrayList<String> headetText;
    private HashMap<String,ArrayList<String>> childText;
    private ArrayList<String> child;
    private ExpandableListView expandableListView;
    private int lastExpandable = -1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part4_expandable_list_view);
        this.setTitle("Expandable List View");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        LinearLayout linearLayout = findViewById(R.id.Part4ExpandableListViewActivityId);
        if (loadBackgroundColor()!=getResources().getColor(R.color.background_color)){
            linearLayout.setBackgroundColor(loadBackgroundColor());
        }
        expandableListView = findViewById(R.id.part4ExpandebleListViewId);
        String[] abbriviationheader  = getResources().getStringArray(R.array.abbriviation_header_Name);
        String[] abbriviationchild  = getResources().getStringArray(R.array.abbriviation_child_Name);
        headetText = new ArrayList<>();
        childText = new HashMap<>();
        for (int i =0 ;i<(abbriviationheader.length);i++){
            headetText.add(abbriviationheader[i]);
            child = new ArrayList<>();
            child.add(abbriviationchild[i]);
            childText.put(headetText.get(i),child);
        }

        ExpandableCustomAdapter expandableCustomAdapter = new ExpandableCustomAdapter(this,headetText,childText);
        expandableListView.setAdapter(expandableCustomAdapter);
        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {
                if(lastExpandable!=-1&&lastExpandable!=groupPosition){
                    expandableListView.collapseGroup(lastExpandable);
                    lastExpandable = groupPosition;
                }else {
                    lastExpandable = groupPosition;
                }
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