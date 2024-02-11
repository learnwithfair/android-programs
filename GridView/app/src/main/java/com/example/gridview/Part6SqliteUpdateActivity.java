package com.example.gridview;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Patterns;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class Part6SqliteUpdateActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText idEditText,passwordEditText,nameEditText,ageEditText,genderEditText,emailEditText;
    private Button submitButton,clearButton;
    private ProgressBar bar;
    private MyDatabase mydatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part6_sqlite_update);
        this.setTitle("Update Account");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        LinearLayout linearLayout = findViewById(R.id.Part6SqliteUpdateActivityId);
        if (loadBackgroundColor()!=getResources().getColor(R.color.background_color)){
            linearLayout.setBackgroundColor(loadBackgroundColor());
        }
        idEditText = findViewById(R.id.Part6SqliteUpdateidEditTextId);
        passwordEditText = findViewById(R.id.Part6SqliteUpdatepasswordEditTextId);
        nameEditText = findViewById(R.id.Part6SqliteUpdatenameEditTextId);
        ageEditText = findViewById(R.id.Part6SqliteUpdateageEditTextId);
        genderEditText = findViewById(R.id.Part6SqliteUpdategenderEditTextId);
        emailEditText = findViewById(R.id.Part6SqliteUpdateemailEditTextId);
        submitButton = findViewById(R.id.Part6SqliteUpdatesbmitButtonId);
        clearButton = findViewById(R.id.Part6SqliteUpdateclearButonId);
        bar = findViewById(R.id.Part6SqliteUpdateprogressId);
        mydatabase = new MyDatabase(this);
        final SQLiteDatabase sqLiteDatabase = mydatabase.getWritableDatabase();
        SharedPreferences sharedPreferences = getSharedPreferences("account_info", Context.MODE_PRIVATE);
        String Email = sharedPreferences.getString("email","null");
        String pass = sharedPreferences.getString("password","null");
        Cursor cursor =  mydatabase.displayAllData();
        while (cursor.moveToNext()){
                String p = cursor.getString(2);
                String e = cursor.getString(6);
                if (pass.equals(p)&&Email.equals(e)){
                   idEditText.setText(cursor.getString(1));
                   passwordEditText.setText(cursor.getString(2));
                   nameEditText.setText(cursor.getString(3));
                   ageEditText.setText(cursor.getString(4));
                   genderEditText.setText(cursor.getString(5));
                   emailEditText.setText(cursor.getString(6));
                    break;
                }
        }
        passwordEditText.setOnLongClickListener(new View.OnLongClickListener() {
            int i = 2;
            @Override
            public boolean onLongClick(View v) {
                int type = nameEditText.getInputType();
                if (i==2){
                    passwordEditText.setInputType(type);
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
        submitButton.setOnClickListener(this);
        clearButton.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.Part6SqliteUpdatesbmitButtonId){

            String id = idEditText.getText().toString().trim();
            String password = passwordEditText.getText().toString().trim();
            String name = nameEditText.getText().toString().trim();
            String age = ageEditText.getText().toString().trim();
            String gender = genderEditText.getText().toString().trim();
            String email = emailEditText.getText().toString().trim();
            if (id.isEmpty()||password.isEmpty()||name.isEmpty()||age.isEmpty()||gender.isEmpty()||email.isEmpty()){
                if (id.isEmpty()){
                    idEditText.setError("Please fill up this Field");
                    idEditText.requestFocus();
                    return;
                }else if (password.isEmpty()){
                    passwordEditText.setError("Please fill up this Field");
                    passwordEditText.requestFocus();
                    return;
                }else if (name.isEmpty()){
                    nameEditText.setError("Please fill up this Field");
                    nameEditText.requestFocus();
                    return;
                }else if (age.isEmpty()){
                    ageEditText.setError("Please fill up this Field");
                    ageEditText.requestFocus();
                    return;
                }else if (gender.isEmpty()){
                    genderEditText.setError("Please fill up this Field");
                    genderEditText.requestFocus();
                    return;
                }else if (email.isEmpty()){
                    emailEditText.setError("Please fill up this Field");
                    emailEditText.requestFocus();
                    return;
                }

            }else if(password.length()<6){
                passwordEditText.setError("Please insert valid password limit grater then 6");
                passwordEditText.requestFocus();
                return;
            }else if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                emailEditText.setError("Please insert a valid Email address");
                emailEditText.requestFocus();
                return;
            }
            else {
                SharedPreferences sharedPreferences = getSharedPreferences("account_info", Context.MODE_PRIVATE);
                String Email = sharedPreferences.getString("email","null");
                if (Email.equals(email)){
                    int code = mydatabase.updateData(id,password,name,age,gender,email);
                    if (code==1){
                        emptyData();
                        SharedPreferences updatevalue = getSharedPreferences("account_info", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = updatevalue.edit();
                        editor.putString("email",email);
                        editor.putString("password",password);
                        editor.commit();
                        Toast.makeText(getApplicationContext(), "Account Updated Successfully", Toast.LENGTH_SHORT).show();
                    }else {
                        Toast.makeText(getApplicationContext(), "Account Update Unsuccessful", Toast.LENGTH_SHORT).show();
                    }


                }else {
                    emailEditText.setError("Please insert a Correct Email address.");
                    emailEditText.requestFocus();
                    return;
                }
            }
        }else if (v.getId()==R.id.Part6SqliteUpdateclearButonId){
            emptyData();
        }
    }

    private void emptyData() {
        idEditText.setText("");
        passwordEditText.setText("");
        nameEditText.setText("");
        ageEditText.setText("");
        genderEditText.setText("");
        emailEditText.setText("");
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


