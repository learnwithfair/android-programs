package com.example.cardview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private CardView school,hospital,airport,restaurant;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        school = findViewById(R.id.schoolId);
        hospital = findViewById(R.id.hospitalId);
        airport = findViewById(R.id.airportId);
        restaurant = findViewById(R.id.restaurantId);
        school.setOnClickListener(this);
        hospital.setOnClickListener(this);
        airport.setOnClickListener(this);
        restaurant.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.schoolId){
            Intent intent = new Intent(getApplicationContext(),School_Activity.class);
            startActivity(intent);
        }else if (v.getId()==R.id.hospitalId){
            Intent intent = new Intent(getApplicationContext(),Hospital_Activity.class);
            startActivity(intent);
        }else if (v.getId()==R.id.airportId){
            Intent intent = new Intent(getApplicationContext(),Airport_Activity.class);
            startActivity(intent);
        }else if (v.getId()==R.id.restaurantId){
            Intent intent = new Intent(getApplicationContext(),Restaurant_Activity.class);
            startActivity(intent);
        }
    }
}