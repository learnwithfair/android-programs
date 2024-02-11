package com.example.gridview;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.webkit.WebView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class Part4HTMLContentActivity extends AppCompatActivity {
    private WebView webView;
    private String text = "<h1>This is Heading -1</h1>"+"\n"+
            "<h2>This is Heading-2</h2>\n"+
            "<h3>This is Heading-3</h3>\n"+
            "<p><u>This is an Underline Text</u></p>\n"+
            "<p><i>This is an Italic Text</i></p>\n"+
            "<p><b>This is an Bold Text</b></p>\n\n"+

            "<p><b>Superscript : </b> (a + b)<sup>2</sup> = a<sup>2</sup> + 2ab + b<sup>2</sup></p>\n"+
            "<p><b>Sub Script : </b> H<sub>2</sub>O</p>\n\n"+
            "<ol type=i><p><b>\nSoftware Programing language : </b></p>\n"+
            "<li>C</li>\n"+
            "<li>C++</li>\n"+
            "<li>JAVA</li>\n"+
            "<li>JAVA Swing</li>\n"+
            "</ol>"+
            "<ul type = square><p><b>\nWeb Programing language :</b></p>\n"+
            "<li>HTML</li>\n"+
            "<li>CSS</li>\n"+
            "<li>JAVA Script</li>\n"+
            "<li>Jquery</li>\n"+
            "</ul>";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part4_h_t_m_l_content);
        this.setTitle("HTML Content");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        LinearLayout linearLayout = findViewById(R.id.Part4HTMLContentActivityId);
        if (loadBackgroundColor()!=getResources().getColor(R.color.background_color)){
            linearLayout.setBackgroundColor(loadBackgroundColor());
        }
        webView = findViewById(R.id.part4htmlcontentWebViewId);
        webView.loadDataWithBaseURL(null,text,"text/html","utf-8",null);

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