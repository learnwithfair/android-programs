package com.example.gaussing_game;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private EditText editText;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.EditTextId);
        Button button = findViewById(R.id.buttonId);
        textView = findViewById(R.id.resultTextViewId);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String value = editText.getText().toString().trim();
                if(value.isEmpty()){
                    editText.setError("Please Fill up this Field");
                    editText.requestFocus();
                    return;
                }else{
                    int n = Integer.parseInt(value);
                    if(n<1||n>5){
                        editText.setError("Please Enter valid input");
                        editText.requestFocus();
                        return;
                    }else {

                        Random random = new Random();
                        int randomNumber = random.nextInt(5)+1;
                        if(randomNumber==n){
                            textView.setText("Congratulations!! You have Won");
                            editText.setText("");
                        }else {
                            textView.setText("Sorry, You have lost. Random number was "+randomNumber+". Please try again");
                            editText.setText("");
                        }
                    }
                }
            }
        });
    }

}