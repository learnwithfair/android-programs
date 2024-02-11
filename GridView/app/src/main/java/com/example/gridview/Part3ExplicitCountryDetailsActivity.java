package com.example.gridview;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class Part3ExplicitCountryDetailsActivity extends AppCompatActivity {
    private ImageView imageView;
    private TextView textView;
    Bundle bundle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part3_explicit_country_details);
        this.setTitle("Country Details");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ScrollView scrollView = findViewById(R.id.Part3ExplicitCountryDetailsActivityId);
        if (loadBackgroundColor()!=getResources().getColor(R.color.background_color)){
            scrollView.setBackgroundColor(loadBackgroundColor());
        }
        imageView = findViewById(R.id.part3CountryDetailsimageViewId);
        textView = findViewById(R.id.part3CountryDetailstextViewId);
        bundle = getIntent().getExtras();
        if (bundle!=null){
            String value = bundle.getString("key");
            if (value.equals("bangladesh")){
                imageView.setImageResource(R.drawable.bangladesh);
                textView.setText(getResources().getString(R.string.bangladesh_text));
            }else if (value.equals("india")){
                imageView.setImageResource(R.drawable.india);
                textView.setText(getResources().getString(R.string.india_text));
            }else if (value.equals("pakistan")){
                imageView.setImageResource(R.drawable.pakistan);
                textView.setText(getResources().getString(R.string.pakistan_text));
            }
        }
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