package com.example.sqlitedatabase;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Path;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    private EditText idEditText,passwordEditText1,passwordEditText2;
    private ImageButton visiblityButton;
    private LinearLayout frameLayot1,frameLayot2;
    private FrameLayout frameLayout;
    int i =0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        passwordEditText1 = findViewById(R.id.passwordEditText1Id);
        passwordEditText2 = findViewById(R.id.passwordEditText2Id);
        frameLayout = findViewById(R.id.frameLayotId);
        frameLayot1 = findViewById(R.id.frameLayot1Id);
        frameLayot2 = findViewById(R.id.frameLayot2Id);
        idEditText = findViewById(R.id.idEditTextId);
        frameLayout.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                /*i++;
                if(i%2==0){
                    i++;*/
                    //String password1 = passwordEditText1.getText().toString().trim();
                    frameLayot1.setVisibility(View.GONE);

                   // passwordEditText2.setText(password1);
                    frameLayot2.setVisibility(View.VISIBLE);

               /* }else {
                    i++;
                    //String password2 = passwordEditText2.getText().toString().trim();
                    frameLayot2.setVisibility(View.GONE);
                  //  passwordEditText1.setText(password2);
                    frameLayot1.setVisibility(View.VISIBLE);
                }*/



                return false;
            }
        });
    }
}