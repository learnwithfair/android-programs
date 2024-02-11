package com.example.gridview;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class nav_profileActivity extends AppCompatActivity implements View.OnClickListener {
private ImageButton youtubebtn,twiterbtn,facebookbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav_profile);
        this.setTitle("Profile");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.ic_baseline_person_24);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        youtubebtn = findViewById(R.id.profileyoutubeId);
        twiterbtn = findViewById(R.id.profiletwiterId);
        facebookbtn = findViewById(R.id.profilefacebookId);
        youtubebtn.setOnClickListener(this);
        twiterbtn.setOnClickListener(this);
        facebookbtn.setOnClickListener(this);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()==android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.profileyoutubeId){
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.youtube.com"));
            startActivity(intent);
        }else if (v.getId()==R.id.profiletwiterId){
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.twiter.com"));
            startActivity(intent);
        }else if (v.getId()==R.id.profilefacebookId){
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.facebook.com"));
            startActivity(intent);
        }
    }
}