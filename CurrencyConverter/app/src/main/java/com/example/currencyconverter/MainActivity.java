package com.example.currencyconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    public void convert(View view)
    {
        Log.i("Info","Button Pressed");
        EditText inp = (EditText) findViewById(R.id.editTextNumberDecimal);
        String a= inp.getText().toString();
        double n= Double.parseDouble(a);
        n=n*70;
        String t=String.format("%.2f",n);
        Toast.makeText(this,"$ "+ a+" is Ruppees "+t, Toast.LENGTH_LONG).show();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}