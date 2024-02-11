package com.example.edit_text;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText nameEditText,ageEditText;
    private Button showButton;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nameEditText = findViewById(R.id.nameEdiTextId);
        ageEditText = findViewById(R.id.ageEditTextId);
        showButton = findViewById(R.id.showButtonId);
        textView = findViewById(R.id.textViewId);
        showButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameEditText.getText().toString().trim();
                String age = ageEditText.getText().toString().trim();
                if(name.isEmpty()){
                    nameEditText.setError("Please Insert your name");
                    nameEditText.requestFocus();
                    return;
                }else if(age.isEmpty()){
                    ageEditText.setError("Please Insert your age");
                    ageEditText.requestFocus();
                    return;
                }else {
                textView.setText("Name: "+name+"\nAge : "+age);
                nameEditText.setText("");
                ageEditText.setText("");
                }
            }
        });
    }
}