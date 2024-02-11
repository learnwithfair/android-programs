package com.example.sharedpreference;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText usernameEditTextView, passwordEditTextView;
    private Button save,load;
    private TextView textView;
    private LinearLayout linearLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        usernameEditTextView = findViewById(R.id.usernameEditTextId);
        passwordEditTextView = findViewById(R.id.passwordEditTextId);
        linearLayout = findViewById(R.id.linearLayoutId);
        save = findViewById(R.id.saveButtonId);
        load = findViewById(R.id.loadButtonId);
        textView = findViewById(R.id.textViewId);
        save.setOnClickListener(this);
        load.setOnClickListener(this);
        if (showColor()!=getResources().getColor(R.color.pink)){
            showColor();
        }
    }
    @Override
    public void onClick(View v) {
        String userName = usernameEditTextView.getText().toString().trim();
        String password = passwordEditTextView.getText().toString().trim();
        if (v.getId()==R.id.saveButtonId){
            if (userName.isEmpty()||password.isEmpty()){
                    if(userName.isEmpty()){
                        usernameEditTextView.setError("Please fill up this field");
                        usernameEditTextView.requestFocus();
                        return;
                    }else {
                        passwordEditTextView.setError("Please fill up this field");
                        passwordEditTextView.requestFocus();
                        return;
                    }
            }
            else {
                SharedPreferences sharedPreferences = getSharedPreferences("student_details", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("usernameKey",userName);
                editor.putString("passwordKey",password);
                editor.commit();
                usernameEditTextView.setText("");
                passwordEditTextView.setText("");
                Toast.makeText(this, "Data is successfully stored", Toast.LENGTH_SHORT).show();
            }
        }
        else if(v.getId()==R.id.loadButtonId){
            SharedPreferences sharedPreferences = getSharedPreferences("student_details",Context.MODE_PRIVATE);
            if (sharedPreferences.contains("usernameKey")&&sharedPreferences.contains("passwordKey")) {
                String name = sharedPreferences.getString("usernameKey", "No Data available");
                String pass = sharedPreferences.getString("passwordKey", "No Data available");
                textView.setText("Username : " + name + "\nPassword : " + pass);

            }else {
                Toast.makeText(this, "Can't find your Data", Toast.LENGTH_SHORT).show();
            }
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_item,menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()==R.id.greenId){
            linearLayout.setBackgroundColor(getResources().getColor(R.color.green));
            savecolor(getResources().getColor(R.color.green));
        }if (item.getItemId()==R.id.blueId){
            linearLayout.setBackgroundColor(getResources().getColor(R.color.blue));
            savecolor(getResources().getColor(R.color.blue));
        }if (item.getItemId()==R.id.pinkId){
            linearLayout.setBackgroundColor(getResources().getColor(R.color.pink));
            savecolor(getResources().getColor(R.color.pink));
        }if (item.getItemId()==R.id.purpleId){
            linearLayout.setBackgroundColor(getResources().getColor(R.color.purple));
            savecolor(getResources().getColor(R.color.purple));
        }
        return super.onOptionsItemSelected(item);
    }
    public void savecolor(int n){
        SharedPreferences sharedPreferences = getSharedPreferences("bgcolor",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("color",n);
        editor.commit();
    }
    public int showColor(){
        SharedPreferences sharedPreferences = getSharedPreferences("bgcolor",Context.MODE_PRIVATE);
        int Color = sharedPreferences.getInt("color",getResources().getColor(R.color.pink));
        linearLayout.setBackgroundColor(Color);
        return Color;
    }
}