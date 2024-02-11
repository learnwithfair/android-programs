package com.example.htmlcontent;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity {
    private WebView webView;
    String text = "<h1>This is Heading -1</h1>"+"\n"+
                    "<h2>This is Heading-2</h2>\n"+
                    "<h3>This is Heading-3</h3>\n"+
                    "<p><u>This is an Underline Text</u></p>\n"+
                    "<p><i>This is an Italic Text</i></p>\n"+
                    "<p><b>This is an Bold Text</b></p>\n\n"+

                    "<p><b>Sub Scrip : </b> (a + b)<sup>2</sup> = a<sup>2</sup> + 2ab + b<sup>2</sup></p>\n"+
                    "<p><b>Sub Scrip : </b> H<sub>2</sub>O</p>\n\n"+
            "<ol type=i><p>Soft Programing language </p>\n"+
                "<li>C</li>\n"+
                "<li>C++</li>\n"+
                "<li>JAVA</li>\n"+
                "<li>JAVA Swing</li>\n"+
            "</ol>"+
            "<ul type = square><p>Web Programing language </p>\n"+
                "<li>HTML</li>\n"+
                "<li>CSS</li>\n"+
                "<li>JAVA Script</li>\n"+
                "<li>Jquery</li>\n"+
            "</ul>";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        webView = findViewById(R.id.webViewId);
        webView.loadDataWithBaseURL(null,text,"text/html","utf-8",null);

    }
}