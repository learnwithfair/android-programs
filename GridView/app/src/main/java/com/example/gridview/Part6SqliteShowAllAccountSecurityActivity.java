package com.example.gridview;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Part6SqliteShowAllAccountSecurityActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText passwordEditText,nameEditText;
    private Button submitButton,clearButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part6_sqlite_show_all_account_security);
        this.setTitle("Admin Security");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        LinearLayout linearLayout = findViewById(R.id.Part6SqliteShowAllAccountSecurityActivityId);
        if (loadBackgroundColor()!=getResources().getColor(R.color.background_color)){
            linearLayout.setBackgroundColor(loadBackgroundColor());
        }
        passwordEditText = findViewById(R.id.part6SqliteSecurityEditTextpasswordId);
        nameEditText = findViewById(R.id.part6SqliteSecurityEditTextusernameId);
        submitButton = findViewById(R.id.part6SqliteSecuritysubmitButtonId);
        clearButton = findViewById(R.id.part6SqliteSecurityclearButonId);
        passwordEditText.setOnLongClickListener(new View.OnLongClickListener() {
            int i = 2;
            @Override
            public boolean onLongClick(View v) {
                if (i==2){
                    passwordEditText.setInputType(2);
                    passwordEditText.requestFocus();
                    i=0;
                    return true;

                }else if (i==0){
                    passwordEditText.setInputType(18);
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

        if (v.getId()==R.id.part6SqliteSecurityclearButonId){
            passwordEditText.setText("");
            nameEditText.setText("");

        }else if (v.getId()==R.id.part6SqliteSecuritysubmitButtonId){
            String password = passwordEditText.getText().toString().trim();
            String name = nameEditText.getText().toString().trim();
           if (password.isEmpty()||name.isEmpty()){
               if (name.isEmpty()){
                   nameEditText.setError("Please fill up this Field");
                   nameEditText.requestFocus();
                   return;
               }
              else if (password.isEmpty()){
                   passwordEditText.setError("Please fill up this Field");
                   passwordEditText.requestFocus();
                   return;
               }
           }else if(password.length()<6){
               passwordEditText.setError("Please insert valid password limit grater then 6");
               passwordEditText.requestFocus();
               return;
           }else if (password.equals("88288390")&&name.equals("admin")){
               passwordEditText.setText("");
               nameEditText.setText("");
               Intent intent = new Intent(getApplicationContext(),Part6SqliteDisplayAllAccountActivity.class);
               startActivity(intent);
           }
           else {
               if (name.equals("admin")){
                   passwordEditText.setError("Incorrect Password");
                   passwordEditText.requestFocus();
                   return;
               }
               else if (password.equals("88288390")){
                   nameEditText.setError("Incorrect Username");
                   nameEditText.requestFocus();
                   return;
               }else {
                   Toast.makeText(this, "Username and Password don't matched", Toast.LENGTH_SHORT).show();
                   nameEditText.setError("Incorrect Username");
                   nameEditText.requestFocus();
                   return;
               }
           }
        }
    }
    public int loadBackgroundColor(){
        SharedPreferences preferences = getSharedPreferences("background", Context.MODE_PRIVATE);
        return  preferences.getInt("mycolor",getResources().getColor(R.color.background_color));
    }
}