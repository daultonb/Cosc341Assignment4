package com.example.assignment4;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.ImageView;
import android.widget.TextView;

public class Connections extends AppCompatActivity {

    TextView textView;
    //TODO MIGHT NEED THIS IDK
    //ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connections);

        openMessageActivity();
    }
    public void goback(View view){
        finish();
    }

    public void openMessageActivity(){
        Button button;

        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView = findViewById(R.id.textView);
                String name = textView.getText().toString();

                intentHandler(name);
            }
        });
        button = findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView = findViewById(R.id.textView1);
                String name = textView.getText().toString();

                intentHandler(name);
            }
        });
        button = findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView = findViewById(R.id.textView2);
                String name = textView.getText().toString();

                intentHandler(name);
            }
        });
        button = findViewById(R.id.button3);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView = findViewById(R.id.textView3);
                String name = textView.getText().toString();

                intentHandler(name);
            }
        });
        button = findViewById(R.id.button4);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView = findViewById(R.id.textView4);
                String name = textView.getText().toString();

                intentHandler(name);
            }
        });
        button = findViewById(R.id.button5);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView = findViewById(R.id.textView5);
                String name = textView.getText().toString();

                intentHandler(name);
            }
        });
        button = findViewById(R.id.button6);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView = findViewById(R.id.textView6);
                String name = textView.getText().toString();

                intentHandler(name);
            }
        });
        button = findViewById(R.id.button7);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView = findViewById(R.id.textView7);
                String name = textView.getText().toString();

                intentHandler(name);
            }
        });
        button = findViewById(R.id.button8);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView = findViewById(R.id.textView8);
                String name = textView.getText().toString();

                intentHandler(name);
            }
        });
        button = findViewById(R.id.button9);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView = findViewById(R.id.textView9);
                String name = textView.getText().toString();

                intentHandler(name);
            }
        });
        button = findViewById(R.id.button10);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView = findViewById(R.id.textView10);
                String name = textView.getText().toString();

                intentHandler(name);
            }
        });
        button = findViewById(R.id.button11);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView = findViewById(R.id.textView11);
                String name = textView.getText().toString();

                intentHandler(name);
            }
        });
        button = findViewById(R.id.button12);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView = findViewById(R.id.textView12);
                String name = textView.getText().toString();

                intentHandler(name);
            }
        });

    }

    public void intentHandler(String name) {
        Intent intent = new Intent(this, MessageScreen.class);
        //TODO PASS PICTURE!!
        Bundle bundle = new Bundle();
        bundle.putString("name", name);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
