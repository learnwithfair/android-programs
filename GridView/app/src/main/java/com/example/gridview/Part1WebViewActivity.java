package com.example.gridview;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

public class Part1WebViewActivity extends AppCompatActivity {
    private WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part1_web_view);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().hide();
        webView = findViewById(R.id.part1WebViewId);
        webView.loadUrl("http://www.pust.ac.bd");
        webView.setWebViewClient(new WebViewClient());
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);

    }

    @Override
    public void onBackPressed() {
       if (webView.canGoBack()){
           webView.goBack();
       }else {
           super.onBackPressed();
       }

    }
    public int loadBackgroundColor(){
        SharedPreferences preferences = getSharedPreferences("background", Context.MODE_PRIVATE);
        return  preferences.getInt("mycolor",getResources().getColor(R.color.background_color));
    }
}