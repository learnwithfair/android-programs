package com.example.country_profile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {
    private ImageView imageView;
    private TextView textView;
    Bundle bundle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        imageView = findViewById(R.id.imageViewId);
        textView = findViewById(R.id.textViewId);
        bundle = getIntent().getExtras();
        if(bundle!=null){
            String value = bundle.getString("key");
            if(value.equals("bangladesh")){
                imageView.setImageResource(R.drawable.bangladesh);
                textView.setText(R.string.bangladesh_text);
            }else if(value.equals("india")){
                imageView.setImageResource(R.drawable.india);
                textView.setText(R.string.india_text);
            }else if(value.equals("pakistan")){
                imageView.setImageResource(R.drawable.pakistan);
                textView.setText(R.string.pakistan_text);
            }
        }
    }
}