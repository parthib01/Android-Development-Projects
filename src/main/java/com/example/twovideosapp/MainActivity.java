package com.example.twovideosapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    SurfaceView surfaceView;
    SeekBar seekBar;
    Button button;
    MediaPlayer mediaPlayer;

    SurfaceView surfaceView2;
    SeekBar seekBar2;
    Button button2;
    MediaPlayer mediaPlayer2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //For First Video :

        surfaceView = findViewById(R.id.surfaceView);
        seekBar = findViewById(R.id.seekBar);
        button = findViewById(R.id.button);

        mediaPlayer = MediaPlayer.create(this,R.raw.vid);
        surfaceView.setKeepScreenOn(true);
        SurfaceHolder surfaceHolder =  surfaceView.getHolder();
        surfaceHolder.addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(@NonNull SurfaceHolder holder) {
                mediaPlayer.setDisplay(surfaceHolder);
            }

            @Override
            public void surfaceChanged(@NonNull SurfaceHolder holder, int format, int width, int height) {

            }

            @Override
            public void surfaceDestroyed(@NonNull SurfaceHolder holder) {

            }
        });

        seekBar.setMax(mediaPlayer.getDuration());
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(fromUser) {
                    mediaPlayer.seekTo(progress);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer.isPlaying()){
                    mediaPlayer.pause();
                    button.setText("Play");
                }
                else{
                    mediaPlayer.start();
                    button.setText("Pause");
                }
                if(mediaPlayer2.isPlaying()){
                    mediaPlayer.pause();
                    Toast.makeText(MainActivity.this, "Can't play the video while another video is running..."
                            , Toast.LENGTH_SHORT).show();
                }

            }
        });



        //For Second Video :

        surfaceView2 = findViewById(R.id.surfaceView2);
        seekBar2 = findViewById(R.id.seekBar2);
        button2 = findViewById(R.id.button2);

        mediaPlayer2 = MediaPlayer.create(this,R.raw.vid2);
        surfaceView2.setKeepScreenOn(true);
        SurfaceHolder surfaceHolder2 =  surfaceView2.getHolder();
        surfaceHolder2.addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(@NonNull SurfaceHolder holder) {
                mediaPlayer2.setDisplay(surfaceHolder2);
            }

            @Override
            public void surfaceChanged(@NonNull SurfaceHolder holder, int format, int width, int height) {

            }

            @Override
            public void surfaceDestroyed(@NonNull SurfaceHolder holder) {

            }
        });

        seekBar2.setMax(mediaPlayer2.getDuration());
        seekBar2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar2, int progress, boolean fromUser) {
                if(fromUser) {
                    mediaPlayer2.seekTo(progress);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar2) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar2) {

            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer2.isPlaying()){
                    mediaPlayer2.pause();
                    button2.setText("Play");
                }
                else{
                    mediaPlayer2.start();
                    button2.setText("Pause");
                }
                if(mediaPlayer.isPlaying()){
                    mediaPlayer2.pause();
                    Toast.makeText(MainActivity.this, "Can't play the video while another video is running...  "
                            , Toast.LENGTH_SHORT).show();
                }

            }
        });


    }
}