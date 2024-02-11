package com.example.intent_for_send_data;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        this.setTitle("Second Activity");
        textView = findViewById(R.id.textViewId);
        Bundle bundle = getIntent().getExtras();
        if (bundle!=null){
            String value = bundle.getString("bangladesh");
            textView.setText(value);
        }
    }
}