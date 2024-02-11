package com.example.gridview;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener, NavigationView.OnNavigationItemSelectedListener {
    private CardView part1,part2,part3,part4,part5,part6,part7;
    String[] colors = {"Accent Color","Blue Color","Black Color","Green Color","Magenta Color","Pink Color","Purple Color","White Color"};
    String colorsText = "";
    private LinearLayout linearLayout;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle toggle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        this.setTitle("Home");
        drawerLayout = findViewById(R.id.homeActivityDrawerLayoutId);
        NavigationView navigationView = findViewById(R.id.nav_id);
        navigationView.setNavigationItemSelectedListener(this);
        toggle = new ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        linearLayout = findViewById(R.id.HomeActivityLinearLayoutId);
        if (loadBackgroundColor()!=getResources().getColor(R.color.background_color)){
            linearLayout.setBackgroundColor(loadBackgroundColor());
        }
        part1 = findViewById(R.id.part1cardViewId);
        part2 = findViewById(R.id.part2cardViewId);
        part3 = findViewById(R.id.part3cardViewId);
        part4 = findViewById(R.id.part4cardViewId);
        part5 = findViewById(R.id.part5cardViewId);
        part6 = findViewById(R.id.part6cardViewId);
        part7 = findViewById(R.id.part7cardViewId);

        part1.setOnClickListener(this);
        part2.setOnClickListener(this);
        part3.setOnClickListener(this);
        part4.setOnClickListener(this);
        part5.setOnClickListener(this);
        part6.setOnClickListener(this);
        part7.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_item,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (toggle.onOptionsItemSelected(item)){
            return true;
        }
       if (item.getItemId()==R.id.homeSettingId){

           ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,colors);
           AlertDialog.Builder builder = new AlertDialog.Builder(this);
           builder.setTitle("Set Background");
           builder.setIcon(R.drawable.r);
           builder.setAdapter(adapter, new DialogInterface.OnClickListener() {
             @Override
             public void onClick(DialogInterface dialog, int which) {
               String valuetext =  colors[which];
                 if (valuetext.equals(colors[0])){
                     linearLayout.setBackgroundColor(getResources().getColor(R.color.background_color));
                     saveBackgroundColor(getResources().getColor(R.color.background_color));

                 }else if (valuetext == colors[1]){
                     linearLayout.setBackgroundColor(getResources().getColor(R.color.meterial_blue));
                     saveBackgroundColor(getResources().getColor(R.color.meterial_blue));
                 }else if (valuetext == colors[2]){
                     linearLayout.setBackgroundColor(getResources().getColor(R.color.black));
                     saveBackgroundColor(getResources().getColor(R.color.black));
                 }else if (valuetext == colors[3]){
                     linearLayout.setBackgroundColor(getResources().getColor(R.color.meterial_green));
                     saveBackgroundColor(getResources().getColor(R.color.meterial_green));
                 }else if (valuetext == colors[4]){
                     linearLayout.setBackgroundColor(getResources().getColor(R.color.magenta_color));
                     saveBackgroundColor(getResources().getColor(R.color.magenta_color));
                 }else if (valuetext == colors[5]){
                     linearLayout.setBackgroundColor(getResources().getColor(R.color.meterial_pink));
                     saveBackgroundColor(getResources().getColor(R.color.meterial_pink));
                 }else if (valuetext == colors[6]){
                     linearLayout.setBackgroundColor(getResources().getColor(R.color.meterial_deep_purple));
                     saveBackgroundColor(getResources().getColor(R.color.meterial_deep_purple));
                 }else if (valuetext == colors[7]){
                     linearLayout.setBackgroundColor(getResources().getColor(R.color.whitecolor));
                     saveBackgroundColor(getResources().getColor(R.color.whitecolor));
                 }

             }
         });

           builder.show();
        } else if (item.getItemId()==R.id.homeShareId){
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");
            String subject = "Android Programming App";
            String text = "This app very helpful and easily use for learning Android App development. You can easily get this app search com.example.gridview";
            intent.putExtra(Intent.EXTRA_SUBJECT,subject);
            intent.putExtra(Intent.EXTRA_TEXT,text);
            startActivity(Intent.createChooser(intent,"Share With"));
        }else if (item.getItemId()==R.id.homefeedbackId){
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/email");
            String subject = "Android Programming App";
            String text = "This app very helpful and easily use for learning Android App development. You can easily get this app search com.example.gridview";
            intent.putExtra(Intent.EXTRA_SUBJECT,subject);
            intent.putExtra(Intent.EXTRA_TEXT,text);
            intent.putExtra(Intent.EXTRA_EMAIL,new String[] {"rahatul.ice.09.pust@gmail.com","rahatulislamraju@gmail.com"});
            startActivity(Intent.createChooser(intent,"Feedback With"));
        }else if (item.getItemId()==R.id.homehelpId){
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.tutorialpoint.com"));
            startActivity(intent);

        }else if (item.getItemId()==R.id.homeloginId){
           Intent intent = new Intent(getApplicationContext(),MainActivity.class);
           startActivity(intent);
            SharedPreferences sharedPreferences = getSharedPreferences("logoutdemo", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putInt("logout",0);
            editor.commit();
            finishAffinity();
        }else if (item.getItemId()==R.id.homeCreateAccountId){
           Intent intent = new Intent(getApplicationContext(),SignUpActivity.class);
           startActivity(intent);
            SharedPreferences sharedPreferences = getSharedPreferences("logoutdemo", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putInt("logout",0);
            editor.commit();
            finishAffinity();
        }else if (item.getItemId()==R.id.homelogoutId){
            SharedPreferences sharedPreferences = getSharedPreferences("logoutdemo", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putInt("logout",0);
            editor.commit();
            Intent intent = new Intent(getApplication(),MainActivity.class);
            startActivity(intent);
            finishAffinity();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()==R.id.nav_homeId){
                drawerLayout.closeDrawer(GravityCompat.START);
        } else if (item.getItemId()==R.id.nav_personId){
            Intent intent = new Intent(getApplicationContext(),nav_profileActivity.class);
            startActivity(intent);
        }else if (item.getItemId()==R.id.nav_chatId){
            Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.facebook.com"));
            startActivity(intent);

        }else if (item.getItemId()==R.id.nav_shareId){
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");
            String subject = "Android Programming App";
            String text = "This app very helpful and easily use for learning Android App development. You can easily get this app search com.example.gridview";
            intent.putExtra(Intent.EXTRA_SUBJECT,subject);
            intent.putExtra(Intent.EXTRA_TEXT,text);
            startActivity(Intent.createChooser(intent,"share with"));

        }else if (item.getItemId()==R.id.nav_contactId){
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:+8801790224950"));
            startActivity(intent);
        }
        return false;
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.part1cardViewId){
            Intent intent = new Intent(getApplicationContext(),Part2Activity.class);
            startActivity(intent);
        }else if (v.getId()==R.id.part2cardViewId){
            Intent intent = new Intent(getApplicationContext(),Part1Activity.class);
            startActivity(intent);
        }else if (v.getId()==R.id.part3cardViewId){
            Intent intent = new Intent(getApplicationContext(),Part3Activity.class);
            startActivity(intent);
        }else if (v.getId()==R.id.part4cardViewId){
            Intent intent = new Intent(getApplicationContext(),Part4Activity.class);
            startActivity(intent);
        }else if (v.getId()==R.id.part5cardViewId){
            Intent intent = new Intent(getApplicationContext(),Part5Activity.class);
            startActivity(intent);
        }else if (v.getId()==R.id.part6cardViewId){
            Intent intent = new Intent(getApplicationContext(),Part6Activity.class);
            startActivity(intent);
        }else if (v.getId()==R.id.part7cardViewId){
            Intent intent = new Intent(getApplicationContext(),Part7Activity.class);
            startActivity(intent);
        }

    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
           else {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Warning Message");
            builder.setMessage("Do you want to Exit ?");
            builder.setIcon(R.drawable.ic_baseline_warning_24);
            builder.setCancelable(false);
            builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finishAffinity();
                }
            });
            builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });
            builder.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
            builder.show();
        }
    }
    public void saveBackgroundColor(int chooserColor){
        SharedPreferences preferences = getSharedPreferences("background",Context.MODE_PRIVATE);
        SharedPreferences.Editor setColor = preferences.edit();
        setColor.putInt("mycolor",chooserColor);
        setColor.commit();
    }
    public int loadBackgroundColor(){
        SharedPreferences preferences = getSharedPreferences("background", Context.MODE_PRIVATE);
        return preferences.getInt("mycolor",getResources().getColor(R.color.background_color));
    }


}