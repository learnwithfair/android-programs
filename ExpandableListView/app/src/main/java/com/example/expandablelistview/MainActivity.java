package com.example.expandablelistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    private ExpandableListView expandableListView;
    ArrayList<String> headerText;
    ArrayList<String> child;
    HashMap<String, ArrayList<String>> childText;
    String[] title,details;
    int lastExpandable=-1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        expandableListView = findViewById(R.id.expandableListViewId);
        title= getResources().getStringArray(R.array.header_Name);
        details = getResources().getStringArray(R.array.child_Name);
        headerText = new ArrayList<>();
        childText = new HashMap<>();
        headerText.add("1. C programming?");
        child = new ArrayList<String>();
        child.add("1.1 What is C programming?");
        child.add("1.2 Basic Structure of C programming?");
        child.add("1.3 Advantage of C programming?");
        child.add("1.4 Disadvantage of C programming?");
        child.add("1.5 History of C programming?");
        childText.put(headerText.get(0),child);
        headerText.add("2. Loop of C Programing?");
        child = new ArrayList<>();
        child.add("2.1 For Loop of C programming?");
        child.add("2.2 While loop of C programming?");
        child.add("2.3 Do While of C programming?");
        childText.put(headerText.get(1),child);
        for (int i = 2;i<(title.length)+2;i++){
            headerText.add(i,title[i-2]);
            child = new ArrayList<>();
            child.add(details[i-2]);
            childText.put(headerText.get(i),child);
        }
        CustomAdapter adapter = new CustomAdapter(this,headerText,childText);
        expandableListView.setAdapter(adapter);
        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {
                if(lastExpandable!=-1 && lastExpandable!=groupPosition){
                    expandableListView.collapseGroup(lastExpandable);
                    lastExpandable=groupPosition;
                }else {
                    lastExpandable=groupPosition;
                }
            }
        });
        expandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                String value = headerText.get(groupPosition);
                Toast.makeText(MainActivity.this, "Group name "+value, Toast.LENGTH_SHORT).show();
                return false;
            }
        });
        expandableListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
            @Override
            public void onGroupCollapse(int groupPosition) {
                String value = headerText.get(groupPosition);
                Toast.makeText(MainActivity.this, value+" is collapse", Toast.LENGTH_SHORT).show();
            }
        });
        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                String value = childText.get(headerText.get(groupPosition)).get(childPosition);
                Toast.makeText(MainActivity.this, value, Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }
}