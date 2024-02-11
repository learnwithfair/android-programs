package com.example.gridview;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class SqliteDatabaseActivity extends AppCompatActivity implements View.OnClickListener {
    private Button showButton,updateButton,deleteButton,showAllButton,showAllAccountButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite_database);
        this.setTitle("SQLite Database");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        LinearLayout linearLayout = findViewById(R.id.SqliteDatabaseActivityId);
        if (loadBackgroundColor()!=getResources().getColor(R.color.background_color)){
            linearLayout.setBackgroundColor(loadBackgroundColor());
        }
        showButton = findViewById(R.id.part6sqliteeShowDataButtonId);
        updateButton = findViewById(R.id.part6sqliteeUpdateButtonId);
        deleteButton = findViewById(R.id.part6sqliteDeleteButtonId);
        showAllButton = findViewById(R.id.part6sqliteeshowAllButtonId);
        showAllAccountButton = findViewById(R.id.part6sqliteeshowAllAccountButtonId);
        showButton.setOnClickListener(this);
        updateButton.setOnClickListener(this);
        deleteButton.setOnClickListener(this);
        showAllButton.setOnClickListener(this);
        showAllAccountButton.setOnClickListener(this);
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
        if (v.getId()==R.id.part6sqliteeShowDataButtonId){
            SharedPreferences sharedPreferences = getSharedPreferences("account_info", Context.MODE_PRIVATE);
            String Email = sharedPreferences.getString("email","null");
            String password = sharedPreferences.getString("password","null");
            MyDatabase database = new MyDatabase(this);
            String message = database.displayData(password,Email);
            if (message.isEmpty()){
                showAlertDialog("Error Message","Can't Find your Account");
            }else {
               showAlertDialog("Verify Your Account",message);
            }
        }else if (v.getId()==R.id.part6sqliteeUpdateButtonId){
            Intent intent = new Intent(getApplicationContext(),Part6SqliteUpdateActivity.class);
            startActivity(intent);
        }else if (v.getId()==R.id.part6sqliteDeleteButtonId){
            AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setTitle("Warning Message");
            alert.setIcon(R.drawable.ic_baseline_warning_24);
            alert.setMessage("Are you sure delete account?");
            alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    SharedPreferences sharedPreferences = getSharedPreferences("account_info", Context.MODE_PRIVATE);
                    String Email = sharedPreferences.getString("email","null");
                   MyDatabase myDatabase = new MyDatabase(getApplicationContext());
                   int n = myDatabase.deleteData(Email);
                    if (n == 1) {
                        Toast.makeText(getApplicationContext(), "Data is Successfully Deleted", Toast.LENGTH_SHORT).show();
                        SharedPreferences logout = getSharedPreferences("logoutdemo", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = logout.edit();
                        editor.putInt("logout",0);
                        editor.commit();
                        //
                        SharedPreferences changevalue = getSharedPreferences("student_details", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor1 = changevalue.edit();
                        editor1.putString("password","1");
                        editor1.putString("email", "1");
                        editor1.commit();
                        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                        startActivity(intent);
                        Toast.makeText(getApplicationContext(), "Account is Successfully Deleted", Toast.LENGTH_SHORT).show();
                        finishAffinity();

                    } else {
                        Toast.makeText(getApplicationContext(), "Account is not Delete because E-mail can't Find in Database.", Toast.LENGTH_SHORT).show();
                    }

                }
            });
            alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });
            alert.show();


        }else if (v.getId()==R.id.part6sqliteeshowAllButtonId){
            Intent intent = new Intent(getApplicationContext(),Part6SqliteShowAllActivity.class);
            startActivity(intent);

        }else if (v.getId()==R.id.part6sqliteeshowAllAccountButtonId){
            AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setTitle("Warning Message");
            alert.setIcon(R.drawable.ic_baseline_warning_24);
            alert.setMessage("Are you Admin?");
            alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Intent intent = new Intent(getApplicationContext(),Part6SqliteShowAllAccountSecurityActivity.class);
                    startActivity(intent);
                }
            });
             alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                   dialog.cancel();
                }
            });
             alert.show();


        }
    }
    public void showAlertDialog(String title,String message){

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setIcon(R.drawable.ic_baseline_verified_user_24);
        builder.show();
    }
    public int loadBackgroundColor(){
        SharedPreferences preferences = getSharedPreferences("background", Context.MODE_PRIVATE);
        return  preferences.getInt("mycolor",getResources().getColor(R.color.background_color));
    }
}