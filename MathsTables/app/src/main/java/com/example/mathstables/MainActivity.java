package com.example.mathstables;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    ListView myList;
    public void display(int n)
    {
        ArrayList<String> table = new ArrayList<String>();

        for (int j=1;j<=10;j++)
        {
            String t=Integer.toString(n)+" x "+ Integer.toString(j) + " = "+Integer.toString(j*n);
            table.add(t);
        }
        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,table);

        myList.setAdapter(myAdapter);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final SeekBar mySeekBar= findViewById(R.id.seekBar);
        myList = findViewById(R.id.listView);

        mySeekBar.setMax(20);
        mySeekBar.setProgress(10);
        display(10);

        mySeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                int min=1;
                int n;
                if(i<min)
                {
                    n=min;
                    mySeekBar.setProgress(min);
                }
                else
                {
                    n=i;
                }
                display(n);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }
}