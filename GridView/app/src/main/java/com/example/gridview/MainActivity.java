package com.example.gridview;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText emailEditText,passwordEditText;
    private Button signinbutton,signupbutton,forgotbutton;
    private MyDatabase myDatabase ;
    private LinearLayout linearLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setTitle("Login From");
        this.setTitleColor(R.color.black);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        linearLayout = findViewById(R.id.mainActivityLinearLayoutId);
        if (loadBackgroundColor()!=getResources().getColor(R.color.background_color)){
            linearLayout.setBackgroundColor(loadBackgroundColor());
        }
       emailEditText = findViewById(R.id.emailEditTextId);
       passwordEditText = findViewById(R.id.passwordEditTextId);
       signinbutton = findViewById(R.id.signInbuttonId);
       signupbutton = findViewById(R.id.signupbuttonId);
       forgotbutton = findViewById(R.id.forgotbuttonId);
       if (showPassword().equals("11")){
           emptydata();

       }else {
           showPassword();
       }

       signinbutton.setOnClickListener(this);
       signupbutton.setOnClickListener(this);
       forgotbutton.setOnClickListener(this);
       passwordEditText.setOnLongClickListener(new View.OnLongClickListener() {
           int i=2;
           @Override
           public boolean onLongClick(View v) {
               if (i==2){
                   passwordEditText.setInputType(145);
                   passwordEditText.requestFocus();
                   i=0;
                   return true;

               }else if (i==0){
                   passwordEditText.setInputType(129);
                   passwordEditText.requestFocus();
                   i=2;
                   return true;
               }else {
                   return true;
               }

           }
       });
    }



    @Override
    public void onClick(View v) {

        if (v.getId()==R.id.signInbuttonId){
            String email = emailEditText.getText().toString().trim();
            String password = passwordEditText.getText().toString().trim();
            if (email.isEmpty()||password.isEmpty()){
                if (email.isEmpty()){
                    emailEditText.setError("Please Fill up this filed.");
                    emailEditText.requestFocus();
                    return;
                }else if (password.isEmpty()){
                    passwordEditText.setError("Please Fill up this filed.");
                    passwordEditText.requestFocus();
                    return;
                }
            }else if (password.length()<6){
                passwordEditText.setError("Please insert valid input limit grater then 6.");
                passwordEditText.requestFocus();
                return;
            }else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                emailEditText.setError("Please insert a valid E-mail address.");
                emailEditText.requestFocus();
                return;
            }
            else {
               myDatabase = new MyDatabase(this);
               int checked = myDatabase.showData(password,email);
               if (checked==1){
                   SharedPreferences account_info = getSharedPreferences("account_info", Context.MODE_PRIVATE);
                   SharedPreferences.Editor edit = account_info.edit();
                   edit.putString("email",email);
                   edit.putString("password",password);
                   edit.commit();

                   SharedPreferences sharedPreferences = getSharedPreferences("student_details",Context.MODE_PRIVATE);
                   String ema = sharedPreferences.getString("email","1");
                   String pass = sharedPreferences.getString("password","1");

                   SharedPreferences sharedPreferences2 = getSharedPreferences("logoutdemo", Context.MODE_PRIVATE);
                   SharedPreferences.Editor editor = sharedPreferences2.edit();
                   editor.putInt("logout",1);
                   editor.commit();
                   if(ema.equals(email)&&pass.equals(password)){
                       homeActivity();
                   }else {
                       alertShow();
                   }
               }else {
                   Toast.makeText(this, "E-mail & Password does't matched. Please create account then try again", Toast.LENGTH_LONG).show();
               }


            }

        }else if (v.getId()==R.id.signupbuttonId){
            Intent intent = new Intent(getApplicationContext(),SignUpActivity.class);
            startActivity(intent);
        }else if (v.getId()==R.id.forgotbuttonId){
            Intent intent = new Intent(getApplicationContext(),ForgotActivity.class);
            startActivity(intent);
        }
    }

    private void alertShow() {
        AlertDialog.Builder builder= new AlertDialog.Builder(this);
        builder.setCancelable(false);
        builder.setTitle("Warning Message");
        builder.setIcon(R.drawable.ic_baseline_warning_24);
        builder.setMessage("Do you want to save ID & Password?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                savePassword();
                Toast.makeText(MainActivity.this, "Password is saved", Toast.LENGTH_SHORT).show();
                homeActivity();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                homeActivity();
            }
        });
        builder.show();
    }

    private void savePassword() {
        String Email = emailEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString().trim();
        SharedPreferences sharedPreferences = getSharedPreferences("student_details", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("password",password);
        editor.putString("email", Email);
        editor.commit();
    }

    public String showPassword() {
        SharedPreferences sharedPreferences = getSharedPreferences("student_details", Context.MODE_PRIVATE);
        String Email = sharedPreferences.getString("email","1");
        String password = sharedPreferences.getString("password","1");
        emailEditText.setText(Email);
        passwordEditText.setText(password);
        return (Email +password);
    }

    private void emptydata() {
        passwordEditText.setText("");
        emailEditText.setText("");
    }private void homeActivity() {
       Intent intent = new Intent(getApplicationContext(),HomeActivity.class);
       startActivity(intent);
       finish();
    }

    @Override
    public void onBackPressed() {
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
    public int loadBackgroundColor(){
        SharedPreferences preferences = getSharedPreferences("background", Context.MODE_PRIVATE);
        return  preferences.getInt("mycolor",getResources().getColor(R.color.background_color));
    }
}