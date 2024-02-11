package com.example.mediaplayers;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.TimeUnit;

import static com.example.mediaplayers.R.*;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageButton previousButton,playButton,pauseButton,nextButton;
    private TextView durationTextView,titleTextView;
    private MediaPlayer mediaPlayer;
   int count=0;
    String[] title = {"bidhi_tumi_bole_daw_ami_kar.mp3","jibon_jotodin_thakbe.mp3","thakto_jodi_premer_adalot.mp3"};
    int[] songs = {raw.bidhi_tumi_bole_daw_ami_kar, raw.jibon_jotodin_thakbe, raw.thakto_jodi_premer_adalot};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_main);
        previousButton = findViewById(id.previousButtonId);
        playButton = findViewById(id.playButtonId);
        pauseButton = findViewById(id.pauseButtonId);
        nextButton = findViewById(id.nextButtonId);
        durationTextView = findViewById(id.durationId);
        titleTextView = findViewById(id.titleTextViewId);
        mediaPlayer = MediaPlayer.create(this, songs[count]);
        int n = mediaPlayer.getDuration();
        SetTitle(n,count);
        previousButton.setOnClickListener(this);
        playButton.setOnClickListener(this);
        pauseButton.setOnClickListener(this);
        nextButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
       try {
           if(v.getId()== id.previousButtonId){
               if(mediaPlayer!=null){
                   Toast.makeText(this, "Previous", Toast.LENGTH_SHORT).show();
                   if (count>0) {
                       count--;
                       mediaPlayer.stop();
                       mediaPlayer = MediaPlayer.create(this, songs[count]);
                       mediaPlayer.start();
                       int n = mediaPlayer.getDuration();
                       SetTitle(n,count);
                   }else {
                       count=(songs.length)-1;
                       mediaPlayer.stop();
                       mediaPlayer = MediaPlayer.create(this, songs[count]);
                       mediaPlayer.start();
                       int n = mediaPlayer.getDuration();
                       SetTitle(n,count);
                   }
               }
           }else if(v.getId()== id.playButtonId){
              if(mediaPlayer!=null){

                  if (mediaPlayer.isPlaying()==false){
                      Toast.makeText(this, "Play", Toast.LENGTH_SHORT).show();
                      mediaPlayer.start();
                  }
              }
           }else if(v.getId()== id.pauseButtonId){
              if (mediaPlayer!=null){

                  if (mediaPlayer.isPlaying()){
                      Toast.makeText(this, "Pause", Toast.LENGTH_SHORT).show();
                      mediaPlayer.pause();
                  }
              }
           }else if(v.getId()== id.nextButtonId){

               if(mediaPlayer!=null){
                   Toast.makeText(this, "Next", Toast.LENGTH_SHORT).show();
                   if (count<((songs.length)-1)) {
                       count++;
                       mediaPlayer.stop();
                       mediaPlayer = MediaPlayer.create(this, songs[count]);
                       mediaPlayer.start();
                       int n = mediaPlayer.getDuration();
                       SetTitle(n,count);

                   }else {
                       count=0;
                       mediaPlayer.stop();
                       mediaPlayer = MediaPlayer.create(this, songs[count]);
                       mediaPlayer.start();
                       int n = mediaPlayer.getDuration();
                       SetTitle(n,count);
                   }
               }
           }
       }catch (Exception e){
           Toast.makeText(this, "Exception : "+e, Toast.LENGTH_SHORT).show();
       }
    }

    private void SetTitle(int n,int count) {
        titleTextView.setText(title[count]);
        durationTextView.setText(String.format("%d:%d", TimeUnit.MILLISECONDS.toMinutes(n),
                TimeUnit.MILLISECONDS.toSeconds(n)-TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(n))));
    }

    @Override
    protected void onDestroy() {
        if (mediaPlayer!=null||mediaPlayer.isPlaying()){
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer=null;
        }
        super.onDestroy();
    }
}