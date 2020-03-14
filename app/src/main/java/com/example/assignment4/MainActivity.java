package com.example.assignment4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void register(View v){
        Intent intent = new Intent(this, register.class);
        startActivity(intent);
    }
    public void login (View v){
        Intent intent = new Intent(this, login.class);
        startActivity(intent);
    }
}
