package com.example.optionmenu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class FeedbackActivity extends AppCompatActivity implements View.OnClickListener {
    private Button clearButton,sendButton;
    private EditText nametext,messagetext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        nametext = findViewById(R.id.nameEditTextId);
        messagetext = findViewById(R.id.messageEditTextId);
        clearButton = findViewById(R.id.clearButtonId);
        sendButton = findViewById(R.id.sendButtonId);
        clearButton.setOnClickListener(this);
        sendButton.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.clearButtonId) {
            nametext.setText("");
            messagetext.setText("");
        }else if (v.getId()==R.id.sendButtonId){
            String name = nametext.getText().toString().trim();
            String message = messagetext.getText().toString().trim();
            if (name.isEmpty()||message.isEmpty()){
                if (name.isEmpty()){
                    nametext.setError("Please fill up this Field");
                    nametext.requestFocus();
                    return;
                }else if (message.isEmpty()){
                    messagetext.setError("Please fill up this Field");
                    messagetext.requestFocus();
                    return; }
            }else {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/email");
                String subject = "C programing Apps";
                String body ="Name : "+name+"\nMessage : "+message;
                intent.putExtra(Intent.EXTRA_EMAIL,new String[] {"rahatul.ice.09.pust@gmail.com","rahatul.190609@s.pust.ac.bd"});
                intent.putExtra(Intent.EXTRA_SUBJECT,subject);
                intent.putExtra(Intent.EXTRA_TEXT,body);
                startActivity(Intent.createChooser(intent,"Feedback with"));
            }
        }
    }
}