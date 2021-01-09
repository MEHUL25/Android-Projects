package com.example.smartytimer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView timerTextView;
    SeekBar timerSeekBar;
    Boolean active=false;
    CountDownTimer countDownTimer;
    Button go;


    public void reset()
    {
        timerTextView.setText("0:30");
        timerSeekBar.setProgress(30);
        timerSeekBar.setEnabled(true);
        countDownTimer.cancel();
        go.setText("Go");
        active=false;
    }

    public void kick(View view)
    {
        if(active)
        {
            reset();
        }
        else {

            active = true;
            timerSeekBar.setEnabled(false);
            go.setText("STOP !");

            countDownTimer = new CountDownTimer(timerSeekBar.getProgress() * 1000 + 100, 1000) {
                @Override
                public void onTick(long l) {
                    update_Timer((int) l / 1000);
                }

                @Override
                public void onFinish() {
                    MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.airhorn);
                    mp.start();
                    reset();
                }
            }.start();
        }
    }

    public void update_Timer(int secondsLeft)
    {
        int min=secondsLeft/60;
        int seconds= secondsLeft-(min*60);

        String secondString=Integer.toString(seconds);

        if(secondString.length()==1)
        {
            secondString="0"+secondString;
        }

        timerTextView.setText(Integer.toString(min)+":"+secondString);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timerSeekBar = findViewById(R.id.seekBar1);
        timerTextView = findViewById(R.id.counter);
        go= findViewById(R.id.button);


        timerSeekBar.setMax(600);
        timerSeekBar.setProgress(30);

        timerSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
            @Override
            public void onProgressChanged(SeekBar seekBar,int i,boolean b){
                update_Timer(i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekbar){

            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar){

            }

        });

    }
}