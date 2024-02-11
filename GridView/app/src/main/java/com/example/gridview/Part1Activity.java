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

public class Part1Activity extends AppCompatActivity {
    ArrayList<String> headetText;
    HashMap<String,ArrayList<String>> childText;
    ArrayList<String> child;
    private ExpandableListView expandableListView;
    private int lastExpandable = -1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part1);
        this.setTitle("Part-2");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        LinearLayout linearLayout = findViewById(R.id.part1LinearLayoutId);
        if (loadBackgroundColor()!=getResources().getColor(R.color.background_color)){
            linearLayout.setBackgroundColor(loadBackgroundColor());
        }
        expandableListView = findViewById(R.id.part1ExpandebleListViewId);
        headetText = new ArrayList<>();
        childText = new HashMap<>();
        headetText.add("    Part-2 Contains");
        child = new ArrayList<>();
        child.add("1.0 Part-2 Hint's");
        childText.put(headetText.get(0),child);
        headetText.add("1. Android View");
        child = new ArrayList<>();
        child.add("1.1  View");
        child.add("1.2  Text View");
        child.add("1.3  Image View");
        child.add("1.4  Scroll View");
        child.add("1.5  Video View");
        child.add("1.6  Web View");
        childText.put(headetText.get(1),child);
        headetText.add("2. Android Button");
        child = new ArrayList<>();
        child.add("2.1  Button");
        child.add("2.2  Image Button");
        child.add("2.3  Radio Button");
        child.add("2.4  Check Box");
        child.add("2.5  Switch");
        childText.put(headetText.get(2),child);
        headetText.add("3. Android Edit Text");
        child = new ArrayList<>();
        child.add("3.1  Edit Text");
        child.add("3.2  Text Area");
        childText.put(headetText.get(3),child);
        headetText.add("4. Android Bar");
        child = new ArrayList<>();
        child.add("4.1   Rating Bar");
        child.add("4.2   Seek Bar");
        child.add("4.3   Progress Bar Vertical");
        child.add("4.4   Progress Bar Horizontal");
        childText.put(headetText.get(4),child);
        headetText.add("5. Android Dialog");
        child = new ArrayList<>();
        child.add("5.1  Date Picker");
        child.add("5.2  Date Picker Dialog");
        child.add("5.3  Time Picker");
        child.add("5.4  Time Picker Dialog");
        child.add("5.5  Alert Dialog");
        childText.put(headetText.get(5),child);
        headetText.add("6. Android Clock");
        child = new ArrayList<>();
        child.add("6.1  Analog Clock");
        child.add("6.2  Digital Clock");
        child.add("6.3  Text Clock");
        childText.put(headetText.get(6),child);
        headetText.add("7. Android Toast");
        child = new ArrayList<>();
        child.add("7.1  Toast");
        child.add("7.2  Custom Toast");
        childText.put(headetText.get(7),child);
         headetText.add("8. Android Zoom Control");
        child = new ArrayList<>();
        child.add("8.1  Zoom Control");
        childText.put(headetText.get(8),child);
        headetText.add("9. Android Auto Link");
        child = new ArrayList<>();
        child.add("9.1  Auto Link");
        childText.put(headetText.get(9),child);

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
                if (value.equals("1.0 Part-2 Hint's"))
                {
                    Intent intent = new Intent(getApplicationContext(),Part1HintsActivity.class);
                    startActivity(intent);
                }else if (value.equals("1.1  View"))
                {
                    Intent intent = new Intent(getApplicationContext(),Part1ViewActivity.class);
                    startActivity(intent);
                } else if (value.equals("1.2  Text View"))
                {
                    Intent intent = new Intent(getApplicationContext(),Part1TextViewActivity.class);
                    startActivity(intent);
                }else if (value.equals("1.3  Image View"))
                {
                    Intent intent = new Intent(getApplicationContext(),Part1ImageViewActivity.class);
                    startActivity(intent);
                }else if (value.equals("1.4  Scroll View"))
                {
                    Intent intent = new Intent(getApplicationContext(),Part1ScrollViewActivity.class);
                    startActivity(intent);
                }else if (value.equals("1.5  Video View"))
                {
                    Intent intent = new Intent(getApplicationContext(),Part1VideoViewActivity.class);
                    startActivity(intent);
                }else if (value.equals("1.6  Web View"))
                {
                    Intent intent = new Intent(getApplicationContext(),Part1WebViewActivity.class);
                    startActivity(intent);
                }else if (value.equals("2.1  Button")){
                    Intent intent = new Intent(getApplicationContext(),Part1ButtonActivity.class);
                    startActivity(intent);
                }else if (value.equals("2.2  Image Button")){
                    Intent intent = new Intent(getApplicationContext(),Part1ImageButtonActivity.class);
                    startActivity(intent);
                }else if (value.equals("2.3  Radio Button")){
                    Intent intent = new Intent(getApplicationContext(),Part1RadioButtonActivity.class);
                    startActivity(intent);
                }else if (value.equals("2.4  Check Box")){
                    Intent intent = new Intent(getApplicationContext(),Part1CheckBoxActivity.class);
                    startActivity(intent);
                }else if (value.equals("2.5  Switch")){
                    Intent intent = new Intent(getApplicationContext(),Part1SwitchActivity.class);
                    startActivity(intent);
                }else if (value.equals("3.1  Edit Text")){
                    Intent intent = new Intent(getApplicationContext(),Part1EditTextActivity.class);
                    startActivity(intent);
                }else if (value.equals("3.2  Text Area")){
                    Intent intent = new Intent(getApplicationContext(),Part1TextAreaActivity.class);
                    startActivity(intent);
                }else if (value.equals("4.1   Rating Bar")){
                    Intent intent = new Intent(getApplicationContext(),Part1RatingBarActivity.class);
                    startActivity(intent);
                }else if (value.equals("4.2   Seek Bar")){
                    Intent intent = new Intent(getApplicationContext(),Part1SeekBarActivity.class);
                    startActivity(intent);
                }else if (value.equals("4.3   Progress Bar Vertical")){
                    Intent intent = new Intent(getApplicationContext(), Part1ProgressBarVerticalActivity.class);
                    startActivity(intent);
                }else if (value.equals("4.4   Progress Bar Horizontal")){
                    Intent intent = new Intent(getApplicationContext(), Part1ProgressBarHorizontalsActivity.class);
                    startActivity(intent);
                }else if (value.equals("5.1  Date Picker")){
                    Intent intent = new Intent(getApplicationContext(), Part1DatePikerActivity.class);
                    startActivity(intent);
                }else if (value.equals("5.2  Date Picker Dialog")){
                    Intent intent = new Intent(getApplicationContext(), Part1DatePickerDialogActivity.class);
                    startActivity(intent);
                }else if (value.equals("5.3  Time Picker")){
                    Intent intent = new Intent(getApplicationContext(), Part1TimePickerActivity.class);
                    startActivity(intent);
                }else if (value.equals("5.4  Time Picker Dialog")){
                    Intent intent = new Intent(getApplicationContext(), Part1TimePickerDialogActivity.class);
                    startActivity(intent);
                }else if (value.equals("5.5  Alert Dialog")){
                    Intent intent = new Intent(getApplicationContext(), Part1AlertDialogActivity.class);
                    startActivity(intent);
                }else if (value.equals("6.1  Analog Clock")){
                    Intent intent = new Intent(getApplicationContext(), Part1AnalogClockActivity.class);
                    startActivity(intent);
                }else if (value.equals("6.2  Digital Clock")){
                    Intent intent = new Intent(getApplicationContext(), Part1DigitalClockActivity.class);
                    startActivity(intent);
                }else if (value.equals("6.3  Text Clock")){
                    Intent intent = new Intent(getApplicationContext(), Part1TextClockActivity.class);
                    startActivity(intent);
                }else if (value.equals("7.1  Toast")){
                    Intent intent = new Intent(getApplicationContext(), Part1ToastActivity.class);
                    startActivity(intent);
                }else if (value.equals("7.2  Custom Toast")){
                    Intent intent = new Intent(getApplicationContext(), Part1CustomToastActivity.class);
                    startActivity(intent);
                }else if (value.equals("8.1  Zoom Control")){
                    Intent intent = new Intent(getApplicationContext(), Part1ZoomControlerActivity.class);
                    startActivity(intent);
                }else if (value.equals("9.1  Auto Link")){
                    Intent intent = new Intent(getApplicationContext(), Part1AutoLinkActivity.class);
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