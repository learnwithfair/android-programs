package com.example.gridview;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Patterns;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText idEditText,passwordEditText,nameEditText,ageEditText,genderEditText,emailEditText;
    private Button submitButton,clearButton;
    private ProgressBar bar;
    private MyDatabase mydatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        this.setTitle("Create Account");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        LinearLayout linearLayout = findViewById(R.id.SignUpActivityId);
        if (loadBackgroundColor()!=getResources().getColor(R.color.background_color)){
            linearLayout.setBackgroundColor(loadBackgroundColor());
        }
        idEditText = findViewById(R.id.idEditTextId);
        passwordEditText = findViewById(R.id.passwordEditTextId);
        nameEditText = findViewById(R.id.nameEditTextId);
        ageEditText = findViewById(R.id.ageEditTextId);
        genderEditText = findViewById(R.id.genderEditTextId);
        emailEditText = findViewById(R.id.emailEditTextId);
        submitButton = findViewById(R.id.sbmitaccountId);
        clearButton = findViewById(R.id.clearButonId);
        bar = findViewById(R.id.progressId);
        bar.setVisibility(View.GONE);
       mydatabase = new MyDatabase(this);
        final SQLiteDatabase sqLiteDatabase = mydatabase.getWritableDatabase();
        passwordEditText.setOnLongClickListener(new View.OnLongClickListener() {
            int i = 2;
            @Override
            public boolean onLongClick(View v) {
                int type = nameEditText.getInputType();
                if (i==2){
                    passwordEditText.setInputType(type);
                    passwordEditText.requestFocus();
                    i=0;
                    return true;

                }else if (i==0){
                    passwordEditText.setInputType(129);
                    passwordEditText.requestFocus();
                    i=2;
                    return true;
                }else {
                    return true;
                }
            }
        });
        submitButton.setOnClickListener(this);
        clearButton.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
       if (v.getId()==R.id.sbmitaccountId){

           String id = idEditText.getText().toString().trim();
           String password = passwordEditText.getText().toString().trim();
           String name = nameEditText.getText().toString().trim();
           String age = ageEditText.getText().toString().trim();
           String gender = genderEditText.getText().toString().trim();
           String email = emailEditText.getText().toString().trim();
           if (id.isEmpty()||password.isEmpty()||name.isEmpty()||age.isEmpty()||gender.isEmpty()||email.isEmpty()){
               if (id.isEmpty()){
                   idEditText.setError("Please fill up this Field");
                   idEditText.requestFocus();
                   return;
               }else if (password.isEmpty()){
                   passwordEditText.setError("Please fill up this Field");
                   passwordEditText.requestFocus();
                   return;
               }else if (name.isEmpty()){
                   nameEditText.setError("Please fill up this Field");
                   nameEditText.requestFocus();
                   return;
               }else if (age.isEmpty()){
                   ageEditText.setError("Please fill up this Field");
                   ageEditText.requestFocus();
                   return;
               }else if (gender.isEmpty()){
                   genderEditText.setError("Please fill up this Field");
                   genderEditText.requestFocus();
                   return;
               }else if (email.isEmpty()){
                   emailEditText.setError("Please fill up this Field");
                   emailEditText.requestFocus();
                   return;
               }

           }else if(password.length()<6){
               passwordEditText.setError("Please insert valid password limit grater then 6");
               passwordEditText.requestFocus();
               return;
           }else if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
               emailEditText.setError("Please insert a valid Email address");
               emailEditText.requestFocus();
               return;
           }
           else {
               long row = mydatabase.saveData(id,password,name,age,gender,email);
               if (row==-1){
                   Toast.makeText(SignUpActivity.this, "You have already create account please login account.", Toast.LENGTH_SHORT).show();
               }else {
                   emptyData();
                  Toast.makeText(SignUpActivity.this, "Account created Successfully", Toast.LENGTH_SHORT).show();
               }
           }
       }else if (v.getId()==R.id.clearButonId){
           emptyData();
       }
    }

    private void emptyData() {
        idEditText.setText("");
        passwordEditText.setText("");
        nameEditText.setText("");
        ageEditText.setText("");
        genderEditText.setText("");
        emailEditText.setText("");
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()==android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);
        finish();
    }
    public int loadBackgroundColor(){
        SharedPreferences preferences = getSharedPreferences("background", Context.MODE_PRIVATE);
        return  preferences.getInt("mycolor",getResources().getColor(R.color.background_color));
    }
}