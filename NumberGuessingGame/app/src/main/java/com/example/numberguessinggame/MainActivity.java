package com.example.numberguessinggame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int ran;

    public void generate()
    {
        Random rand = new Random();
        ran = rand.nextInt(100)+1;
        Toast.makeText(this,"New number Generated !!",Toast.LENGTH_LONG).show();
    }
    public void generateB(View view)
    {
        generate();
    }
    public void check(View view)
    {
        EditText s = (EditText) findViewById(R.id.editTextNumber);
        int n= Integer.parseInt(s.getText().toString());
        String fina;
        if(n>ran)
        {
            fina="The number to be guessed is smaller";
        }
        else if(n<ran)
        {
            fina="The number to be guessed is greater";
        }
        else
        {
            fina="You Won !! Play Again !!";
            generate();
        }

        Toast.makeText(this, fina,Toast.LENGTH_LONG).show();


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        generate();
    }
}