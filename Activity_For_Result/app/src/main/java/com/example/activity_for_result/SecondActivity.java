package com.example.activity_for_result;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SecondActivity extends AppCompatActivity {
    private EditText editText;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        editText = findViewById(R.id.editTextId);
        button = findViewById(R.id.button2Id);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String value = editText.getText().toString().trim();
                if(value.isEmpty()){
                    editText.setError("Please Fill up this Field");
                    editText.requestFocus();
                    return;
                }else {
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    intent.putExtra("key", value);
                    setResult(1, intent);
                    finish();
                }
            }
        });
    }
}