package com.example.gridview;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class ForgotActivity extends AppCompatActivity {
    private EditText idEditText,emailEditText;
    private Button button;
    private MyDatabase myDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot);
        this.setTitle("Forgot Password");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        LinearLayout linearLayout = findViewById(R.id.forgotLinearLayoutId);
        if (loadBackgroundColor()!=getResources().getColor(R.color.background_color)){
            linearLayout.setBackgroundColor(loadBackgroundColor());
        }
        idEditText = findViewById(R.id.forgotidEditTextId);
        emailEditText = findViewById(R.id.forgotemailEditTextId);
        button = findViewById(R.id.forgotsubmitButtonId);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String ID = idEditText.getText().toString().trim();
                String Email = emailEditText.getText().toString().trim();
                if (ID.isEmpty()|| Email.isEmpty()){
                    if (ID.isEmpty()){
                        idEditText.setError("Please fill up this field.");
                        idEditText.requestFocus();
                        return;
                    }else if (Email.isEmpty()){
                        emailEditText.setError("Please fill up this field.");
                        emailEditText.requestFocus();
                        return;
                    }
                }
                else {
                    myDatabase = new MyDatabase(getApplicationContext());
                    String value = myDatabase.forgotPassword(ID, Email);
                    if (value.isEmpty()){
                        Toast.makeText(ForgotActivity.this, "Account is invalid. Please create a new account.", Toast.LENGTH_SHORT).show();
                    }else {
                        idEditText.setText("");
                        emailEditText.setText("");
                        Toast.makeText(ForgotActivity.this, "Password : "+value, Toast.LENGTH_LONG).show();
                    }
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