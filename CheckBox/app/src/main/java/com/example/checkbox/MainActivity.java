package com.example.checkbox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private CheckBox milk,water,sugar;
    private Button button;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        milk = findViewById(R.id.milkCheckBoxId);
        water = findViewById(R.id.WaterCheckBoxId);
        sugar = findViewById(R.id.SugarCheckBoxId);
        textView = findViewById(R.id.textViewId);
        button = findViewById(R.id.buttonId);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuffer value = new StringBuffer("");
                if(milk.isChecked()){
                    String str = milk.getText().toString().trim();
                    value.append(str+" is Ordered\n");
                }if(water.isChecked()){
                    String str = water.getText().toString().trim();
                    value.append(str+" is Ordered\n");
                }if(sugar.isChecked()){
                    String str = sugar.getText().toString().trim();
                    value.append(str+" is Ordered\n");
                }
                textView.setText(value);
            }
        });
    }
}