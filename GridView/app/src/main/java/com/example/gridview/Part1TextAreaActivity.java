package com.example.gridview;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Part1TextAreaActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText text;
    private Button clearButton,saveButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part1_text_area);
        this.setTitle("Text Area");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        LinearLayout linearLayout = findViewById(R.id.Part1TextAreaActivityId);
        if (loadBackgroundColor()!=getResources().getColor(R.color.background_color)){
            linearLayout.setBackgroundColor(loadBackgroundColor());
        }
        text = findViewById(R.id.part1EditTextAreaId);
        clearButton = findViewById(R.id.part1EditTextAreaclearButonId);
        saveButton = findViewById(R.id.part1EditTextAreasaveButonId);
        saveButton.setOnClickListener(this);
        clearButton.setOnClickListener(this);
        showData();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.share_menu_item,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()==android.R.id.home){
            finish();
        }else if (item.getItemId()==R.id.part1EditTextShareId){
            String body = text.getText().toString().trim();
            if (body.isEmpty()){
                text.setError("Please Insert Text then try again.");
                text.requestFocus();
            }else {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_TEXT,body);
                startActivity(Intent.createChooser(intent,"Share With"));
            }

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.part1EditTextAreaclearButonId){
            text.setText("");
        }else if(v.getId()==R.id.part1EditTextAreasaveButonId){
            String value = text.getText().toString().trim();
            WriteData(value);

        }
    }
    public void WriteData(String value){
        try {
            FileOutputStream fileOutputStream = openFileOutput("dairy.txt", Context.MODE_PRIVATE);
            fileOutputStream.write(value.getBytes());
            fileOutputStream.close();
            Toast.makeText(this, "Saved Data", Toast.LENGTH_SHORT).show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void showData(){
        try {
            FileInputStream fileInputStream = openFileInput("dairy.txt");
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String line;
            StringBuffer stringBuffer= new StringBuffer();
            while ((line = bufferedReader.readLine())!=null){
                stringBuffer.append(line+"\n");
            }
            text.setText(stringBuffer.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public int loadBackgroundColor(){
        SharedPreferences preferences = getSharedPreferences("background", Context.MODE_PRIVATE);
        return  preferences.getInt("mycolor",getResources().getColor(R.color.background_color));
    }
}