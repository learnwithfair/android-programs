package com.example.gridview;

import android.content.Context;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import java.util.concurrent.TimeUnit;

public class Part4MediaPlayerActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageButton previousButton,playButton,pauseButton,nextButton;
    private TextView durationTextView,titleTextView;
    private MediaPlayer mediaPlayer;
    int count=0;
    String[] title = {"bidhi_tumi_bole_daw_ami.mp3","jibon_jotodin_thakbe.mp3","thakto_jodi_premer_adalot.mp3"};
    int[] songs = {R.raw.bidhi_tumi_bole_daw_ami_kar, R.raw.jibon_jotodin_thakbe, R.raw.thakto_jodi_premer_adalot};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part4_media_player);
        this.setTitle("Audio Player");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.ic_baseline_audiotrack_24);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        LinearLayout linearLayout = findViewById(R.id.Part4MediaPlayerActivityId);
        if (loadBackgroundColor()!=getResources().getColor(R.color.background_color)){
            linearLayout.setBackgroundColor(loadBackgroundColor());
        }
        previousButton = findViewById(R.id.part4MediaPlayerpreviousButtonId);
        playButton = findViewById(R.id.part4MediaPlayerplayButtonId);
        pauseButton = findViewById(R.id.part4MediaPlayerpauseButtonId);
        nextButton = findViewById(R.id.part4MediaPlayernextButtonId);
        durationTextView = findViewById(R.id.part4MediaPlayerdurationId);
        titleTextView = findViewById(R.id.part4MediaPlayertitleTextViewId);
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
            if(v.getId()== R.id.part4MediaPlayerpreviousButtonId){
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
            }else if(v.getId()== R.id.part4MediaPlayerplayButtonId){
                if(mediaPlayer!=null){

                    if (mediaPlayer.isPlaying()==false){
                        Toast.makeText(this, "Play", Toast.LENGTH_SHORT).show();
                        mediaPlayer.start();
                    }
                }
            }else if(v.getId()== R.id.part4MediaPlayerpauseButtonId){
                if (mediaPlayer!=null){

                    if (mediaPlayer.isPlaying()){
                        Toast.makeText(this, "Pause", Toast.LENGTH_SHORT).show();
                        mediaPlayer.pause();
                    }
                }
            }else if(v.getId()== R.id.part4MediaPlayernextButtonId){

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
