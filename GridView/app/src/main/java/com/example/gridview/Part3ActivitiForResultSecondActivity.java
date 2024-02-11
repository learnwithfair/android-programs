package com.example.gridview;

import android.content.Context;
import android.content.Intent;
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

public class Part3ActivitiForResultSecondActivity extends AppCompatActivity {
    private EditText usernameEditText;
    private Button submitButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part3_activiti_for_result_second);
        this.setTitle("Activity For Result");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        LinearLayout linearLayout = findViewById(R.id.Part3ActivitiForResultSecondActivityId);
        if (loadBackgroundColor()!=getResources().getColor(R.color.background_color)){
            linearLayout.setBackgroundColor(loadBackgroundColor());
        }
        usernameEditText = findViewById(R.id.part3ActivityForResultUserNameEditTextId);
        submitButton = findViewById(R.id.part3ActivityForResultSubmitButtonId);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String value = usernameEditText.getText().toString().trim();
                if (value.isEmpty()){
                    usernameEditText.setError("Please Fill Up This Filed");
                    usernameEditText.requestFocus();
                    return;
                }else {
                    Intent intent = new Intent(getApplicationContext(),Part3ActivitiForResultActivity.class);
                    intent.putExtra("username",value);
                    setResult(1,intent);
                    finish();
                }
            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()==android.R.id.home){
            warningData();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        warningData();
    }
   private void warningData(){
        String value = usernameEditText.getText().toString().trim();
        if (value.isEmpty()){
            usernameEditText.setError("Please Fill Up This Filed");
            usernameEditText.requestFocus();
        }else {
            Toast.makeText(this, "Please Click the Submit Button.", Toast.LENGTH_SHORT).show();
        }
    }
    public int loadBackgroundColor(){
        SharedPreferences preferences = getSharedPreferences("background", Context.MODE_PRIVATE);
        return  preferences.getInt("mycolor",getResources().getColor(R.color.background_color));
    }
}