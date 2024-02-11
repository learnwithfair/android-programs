package com.example.gridview;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class Part7Activity extends AppCompatActivity implements View.OnClickListener {
    private RadioGroup grp1,grp2,grp3,grp4,grp5,grp6,grp7;
    private RadioButton btn1,btn2,btn3,btn4,btn5,btn6,btn7;
    private RatingBar ratingBar;
    private Button resetButton,submitButton;
    private int marks = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part7);
        this.setTitle("Part-7");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        LinearLayout linearLayout = findViewById(R.id.Part7ActivityId);
        if (loadBackgroundColor()!=getResources().getColor(R.color.background_color)){
            linearLayout.setBackgroundColor(loadBackgroundColor());
        }
        grp1 = findViewById(R.id.part7Question1RadioGroupId);
        grp2 = findViewById(R.id.part7Question2RadioGroupId);
        grp3 = findViewById(R.id.part7Question3RadioGroupId);
        grp4 = findViewById(R.id.part7Question4RadioGroupId);
        grp5 = findViewById(R.id.part7Question5RadioGroupId);
        grp6 = findViewById(R.id.part7Question6RadioGroupId);
        grp7 = findViewById(R.id.part7Question7RadioGroupId);
        btn1 = findViewById(R.id.part7Question1AnsId);
        btn2 = findViewById(R.id.part7Question2AnsId);
        btn3 = findViewById(R.id.part7Question3AnsId);
        btn4 = findViewById(R.id.part7Question4AnsId);
        btn5 = findViewById(R.id.part7Question5AnsId);
        btn6 = findViewById(R.id.part7Question6AnsId);
        btn7 = findViewById(R.id.part7Question7AnsId);
        ratingBar = findViewById(R.id.part7RattingbarId);
        resetButton = findViewById(R.id.part7ResetButtonId);
        submitButton = findViewById(R.id.part7SubmitButtonId);
        ratingBar.setClickable(false);
        resetButton.setOnClickListener(this);
        submitButton.setOnClickListener(this);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()==android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.part7SubmitButtonId){
           int selectedId = grp1.getCheckedRadioButtonId();
           if (btn1==findViewById(selectedId)){
               marks++;
           }
           if (btn2==findViewById(grp2.getCheckedRadioButtonId())){
               marks++;
           }if (btn3==findViewById(grp3.getCheckedRadioButtonId())){
               marks++;
           }if (btn4==findViewById(grp4.getCheckedRadioButtonId())){
               marks++;
           }if (btn5==findViewById(grp5.getCheckedRadioButtonId())){
               marks++;
           }if (btn6==findViewById(grp6.getCheckedRadioButtonId())){
               marks++;
           }if (btn7==findViewById(grp7.getCheckedRadioButtonId())){
               marks++;
           }
           if (marks==7){
               ratingBar.setRating(marks);
               LayoutInflater inflater = getLayoutInflater();
               View view = inflater.inflate(R.layout.congratulations_layout, (ViewGroup) findViewById(R.id.congratulationslayoutId),false);
               AlertDialog.Builder builder = new AlertDialog.Builder(this);
               builder.setIcon(R.drawable.r);
               builder.setCancelable(false);
              builder.setView(view);
               builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialog, int which) {
                       dialog.cancel();
                   }
               });
               builder.show();
               marks=0;

           }else if (marks==0){
               ratingBar.setRating(marks);
               AlertDialog.Builder builder = new AlertDialog.Builder(this);
               builder.setTitle("Sorry !!!");
               builder.setMessage("You have Marks : "+marks+"/7");
               builder.setIcon(R.drawable.r);
               builder.setCancelable(false);
               builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialog, int which) {
                       dialog.cancel();
                   }
               });
               builder.show();
               marks=0;
           }
           else {
               ratingBar.setRating(marks);
               AlertDialog.Builder builder = new AlertDialog.Builder(this);
               builder.setTitle("Congratulations!!!");
               builder.setMessage("You have Marks : "+marks+"/7");
               builder.setIcon(R.drawable.r);
               builder.setCancelable(false);
               builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialog, int which) {
                       dialog.cancel();
                   }
               });
               builder.show();
               marks=0;
           }



        }else if (v.getId()==R.id.part7ResetButtonId){
            Intent intent = new Intent(getApplicationContext(),Part7Activity.class);
            startActivity(intent);
            marks=0;
            ratingBar.setRating(marks);
            finish();
        }
    }
    public int loadBackgroundColor(){
        SharedPreferences preferences = getSharedPreferences("background", Context.MODE_PRIVATE);
        return  preferences.getInt("mycolor",getResources().getColor(R.color.background_color));
    }
}