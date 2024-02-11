package com.example.radio_button;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private RadioButton male,female,other;
    private Button button;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        male = findViewById(R.id.maleId);
        female = findViewById(R.id.femaleId);
        other = findViewById(R.id.otherId);
        button = findViewById(R.id.buttonId);
        textView = findViewById(R.id.textViewId);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(male.isChecked()){
                    String value = male.getText().toString().trim();
                    textView.setText(value+" is Checked");
                }else if(female.isChecked()){
                    String value = female.getText().toString().trim();
                    textView.setText(value+" is Checked");
                }else if(other.isChecked()){
                    String value = other.getText().toString().trim();
                    textView.setText(value+" is Checked");
                }else {
                    textView.setText("You have't Checked");
                }
            }
        });
    }
}