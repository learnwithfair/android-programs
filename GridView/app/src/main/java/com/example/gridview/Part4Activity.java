package com.example.gridview;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;

public class Part4Activity extends AppCompatActivity {
    ArrayList<String> headetText;
    HashMap<String,ArrayList<String>> childText;
    ArrayList<String> child;
    private ExpandableListView expandableListView;
    private int lastExpandable = -1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part4);
        this.setTitle("Part-4");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        LinearLayout linearLayout = findViewById(R.id.Part4ActivityId);
        if (loadBackgroundColor()!=getResources().getColor(R.color.background_color)){
            linearLayout.setBackgroundColor(loadBackgroundColor());
        }
        expandableListView = findViewById(R.id.part4ExpandebleListViewId);
        headetText = new ArrayList<>();
        childText = new HashMap<>();
        headetText.add("    Part-4 Contains");
        child = new ArrayList<>();
        child.add("1.0 Part-4 Hint's");
        childText.put(headetText.get(0),child);
        headetText.add("1. Android Adapter");
        child = new ArrayList<>();
        child.add("1.1  Array Adapter");
        child.add("1.2  Base Adapter");
        childText.put(headetText.get(1),child);
        headetText.add("2. Android List View");
        child = new ArrayList<>();
        child.add("2.1  Array list View");
        child.add("2.2  Custom List View");
        childText.put(headetText.get(2),child);
        headetText.add("3. Android Search View");
        child = new ArrayList<>();
        child.add("3.1  Search View in Toolbar");
        child.add("3.2  Search View in Actionbar");
        childText.put(headetText.get(3),child);
        headetText.add("4. Android Grid View");
        child = new ArrayList<>();
        child.add("4.1  Array Grid View");
        child.add("4.2  Custom Grid View");
        childText.put(headetText.get(4),child);
        headetText.add("5. Android Recycle View");
        child = new ArrayList<>();
        child.add("5.1  Recycle View");
        childText.put(headetText.get(5),child);
        headetText.add("6. Android Card View");
        child = new ArrayList<>();
        child.add("6.1  Card View");
        childText.put(headetText.get(6),child);
        headetText.add("7. Auto Complete Text View");
        child = new ArrayList<>();
        child.add("7.1  Auto Complete Text View");
        childText.put(headetText.get(7),child);
        headetText.add("8. Expandable List View");
        child = new ArrayList<>();
        child.add("8.1  Expandable List View");
        childText.put(headetText.get(8),child);
        headetText.add("9. Android Spinner");
        child = new ArrayList<>();
        child.add("9.1  Spinner");
        childText.put(headetText.get(9),child);
        headetText.add("10. Android Fragment");
        child = new ArrayList<>();
        child.add("10.1 Fragment");
        childText.put(headetText.get(10),child);
        headetText.add("11. Android Media Player");
        child = new ArrayList<>();
        child.add("11.1 Media Player");
        childText.put(headetText.get(11),child);
        headetText.add("12. Android Audio Player");
        child = new ArrayList<>();
        child.add("12.1 Audio Player");
        childText.put(headetText.get(12),child);
        headetText.add("13. Android Menu");
        child = new ArrayList<>();
        child.add("13.1 Menu Item");
        childText.put(headetText.get(13),child);
        headetText.add("14. Navigation Drawer");
        child = new ArrayList<>();
        child.add("14.1 Navigation Drawer");
        childText.put(headetText.get(14),child);
        headetText.add("15. HTML Content");
        child = new ArrayList<>();
        child.add("15.1 HTML Content");
        childText.put(headetText.get(15),child);
        headetText.add("16. Full Screen Activity");
        child = new ArrayList<>();
        child.add("16.1 Full Screen Activity");
        childText.put(headetText.get(16),child);

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
        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                String value = childText.get(headetText.get(groupPosition)).get(childPosition);
                if (value.equals("1.0 Part-4 Hint's"))
                {
                    Intent intent = new Intent(getApplicationContext(),Part4HintsActivity.class);
                    startActivity(intent);
                }else if (value.equals("1.1  Array Adapter"))
                {
                    Intent intent = new Intent(getApplicationContext(),Part4ArrayAdapterActivity.class);
                    startActivity(intent);
                } else if (value.equals("1.2  Base Adapter"))
                {
                    Intent intent = new Intent(getApplicationContext(),Part4CustomListView.class);
                    startActivity(intent);
                }else if (value.equals("2.1  Array list View"))
                {
                    Intent intent = new Intent(getApplicationContext(),Part4HintsActivity.class);
                    startActivity(intent);
                }else if (value.equals("2.2  Custom List View"))
                {
                    Intent intent = new Intent(getApplicationContext(),Part4CustomListView.class);
                    startActivity(intent);
                }else if (value.equals("3.1  Search View in Toolbar"))
                {
                    Intent intent = new Intent(getApplicationContext(),Part2Activity.class);
                    startActivity(intent);
                }else if (value.equals("3.2  Search View in Actionbar"))
                {
                    Intent intent = new Intent(getApplicationContext(),Part4HintsActivity.class);
                    startActivity(intent);
                }else if (value.equals("4.1  Array Grid View")){
                    Intent intent = new Intent(getApplicationContext(),Part4ArrayGridViewActivity.class);
                    startActivity(intent);
                }else if (value.equals("4.2  Custom Grid View")){
                    Intent intent = new Intent(getApplicationContext(),Part4CustomGridViewActivity.class);
                    startActivity(intent);
                }else if (value.equals("5.1  Recycle View")){
                    Intent intent = new Intent(getApplicationContext(),Part4RecyclerViewActivity.class);
                    startActivity(intent);
                }else if (value.equals("6.1  Card View")){
                    Intent intent = new Intent(getApplicationContext(),HomeActivity.class);
                    startActivity(intent);
                }else if (value.equals("7.1  Auto Complete Text View")){
                    Intent intent = new Intent(getApplicationContext(),Part4AutoCompleteTextViewActivity.class);
                    startActivity(intent);
                }else if (value.equals("8.1  Expandable List View")){
                    Intent intent = new Intent(getApplicationContext(),Part4ExpandableListViewActivity.class);
                    startActivity(intent);
                }else if (value.equals("9.1  Spinner")){
                    Intent intent = new Intent(getApplicationContext(),Part4SpinnerActivity.class);
                    startActivity(intent);
                }else if (value.equals("10.1 Fragment")){
                    Intent intent = new Intent(getApplicationContext(),Part2Activity.class);
                    startActivity(intent);
                }else if (value.equals("11.1 Media Player")){
                    Intent intent = new Intent(getApplicationContext(),Part4MediaPlayerActivity.class);
                    startActivity(intent);
                }else if (value.equals("12.1 Audio Player")){
                    Intent intent = new Intent(getApplicationContext(), Part4MediaPlayerActivity.class);
                    startActivity(intent);
                }else if (value.equals("13.1 Menu Item")){
                    Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                    startActivity(intent);
                }else if (value.equals("14.1 Navigation Drawer")){
                    Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                    startActivity(intent);
                }else if (value.equals("15.1 HTML Content")){
                    Intent intent = new Intent(getApplicationContext(), Part4HTMLContentActivity.class);
                    startActivity(intent);
                }else if (value.equals("16.1 Full Screen Activity")){
                    Intent intent = new Intent(getApplicationContext(), WelcomeActivity.class);
                    startActivity(intent);
                }
                return true;
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