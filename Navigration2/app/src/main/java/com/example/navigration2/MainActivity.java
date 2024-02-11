package com.example.navigration2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity  implements NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle toggle;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawerLayout = findViewById(R.id.drawerLayoutId);
        NavigationView navigationView= findViewById(R.id.navigationId);
        navigationView.setNavigationItemSelectedListener(this);
        toggle = new ActionBarDrawerToggle(this,drawerLayout,R.string.nav_open,R.string.nav_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        button = findViewById(R.id.buttonId);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Button", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (toggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()==R.id.homeId){

        }else if (item.getItemId()==R.id.personId){

        }else if (item.getItemId()==R.id.chatId){
            Intent intent = new Intent(Intent.ACTION_SEND);
            String subject = "Navigation Apps";
            String text = "This apps is very powerful and useful apps.";
            intent.setType("text/email");
            intent.putExtra(Intent.EXTRA_SUBJECT,subject);
            intent.putExtra(Intent.EXTRA_EMAIL,new String[] {"rahatul.ice.09.pust@gmail.com"});
            intent.putExtra(Intent.EXTRA_TEXT,text);
            startActivity(Intent.createChooser(intent,"Share with"));
        }else if (item.getItemId()==R.id.shareId){
            Intent intent = new Intent(Intent.ACTION_SEND);
            String subject = "Navigation Apps";
            String text = "This apps is very powerful and useful apps.";
            intent.setType("text/plain");
            intent.putExtra(Intent.EXTRA_SUBJECT,subject);
            intent.putExtra(Intent.EXTRA_TEXT,text);
            startActivity(Intent.createChooser(intent,"Share with"));
        }else if (item.getItemId()==R.id.contactId){
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:+8801790224950"));
            startActivity(intent);

        }
        return true;
    }
}