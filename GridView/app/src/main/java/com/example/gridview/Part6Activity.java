package com.example.gridview;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class Part6Activity extends AppCompatActivity implements View.OnClickListener {
    private Button sharedpreferenceButton,fileButton,sqliteButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part6);
        this.setTitle("Part-6");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        LinearLayout linearLayout = findViewById(R.id.Part6ActivityId);
        if (loadBackgroundColor()!=getResources().getColor(R.color.background_color)){
            linearLayout.setBackgroundColor(loadBackgroundColor());
        }
        sharedpreferenceButton = findViewById(R.id.part6SharedPreferenceButtonId);
        fileButton = findViewById(R.id.part6FileDatabaseButtonId);
        sqliteButton = findViewById(R.id.part6SqliteDatabaseButtonId);
        sharedpreferenceButton.setOnClickListener(this);
        fileButton.setOnClickListener(this);
        sqliteButton.setOnClickListener(this);

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
        if (v.getId()==R.id.part6SharedPreferenceButtonId){
            SharedPreferences sharedPreferences = getSharedPreferences("student_details", Context.MODE_PRIVATE);
            String Email = sharedPreferences.getString("email","1");
            String password = sharedPreferences.getString("password","1");
            if (Email.equals("1")||password.equals("1")){
                showAlertDialog("Verify Your Save Account","You have't save your account");
            }else {
                showAlertDialog("Verify Your Save Account",("E-mail : "+Email+"\n\nPassword : "+password));
            }


        }else if (v.getId()==R.id.part6FileDatabaseButtonId){
            Intent intent = new Intent(getApplicationContext(),Part1TextAreaActivity.class);
            startActivity(intent);
        }else if (v.getId()==R.id.part6SqliteDatabaseButtonId){
            Intent intent = new Intent(getApplicationContext(),SqliteDatabaseActivity.class);
            startActivity(intent);
        }
    }
    public void showAlertDialog(String title,String message){

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setIcon(R.drawable.ic_baseline_verified_user_24);
        builder.show();
    }
    public int loadBackgroundColor(){
        SharedPreferences preferences = getSharedPreferences("background", Context.MODE_PRIVATE);
        return  preferences.getInt("mycolor",getResources().getColor(R.color.background_color));
    }
}