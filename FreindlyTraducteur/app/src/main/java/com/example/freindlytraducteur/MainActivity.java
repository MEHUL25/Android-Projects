package com.example.freindlytraducteur;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;




public class MainActivity extends AppCompatActivity
{
    public void playPhrase(View view)
    {
        Button buttonPressed = (Button) view;
        Log.i("Button Pressed",buttonPressed.getTag().toString());
        String var=buttonPressed.getTag().toString();
        MediaPlayer mediaPlayer = MediaPlayer.create(this, getResources().getIdentifier(var,"raw",getPackageName()));
        mediaPlayer.start();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}