package com.example.assignment4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileOutputStream;

public class register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }

    public void back(View view){
        finish();
    }
    public void submit(View view){
        EditText e1 = (EditText)this.findViewById(R.id.editText2);
        EditText e2 = (EditText)this.findViewById(R.id.editText4);
        EditText e3 = (EditText)this.findViewById(R.id.editText5);
        EditText e4 = (EditText)this.findViewById(R.id.editText6);
        EditText e5 = (EditText)this.findViewById(R.id.editText7);
        EditText e6 = (EditText)this.findViewById(R.id.editText8);
        EditText e7 = this.findViewById(R.id.editText9);
        String username = e1.getText().toString();
        String password = e2.getText().toString();
        String confirm = e3.getText().toString();
        String hometown = e4.getText().toString();
        String school =e7.getText().toString();
        String major = e5.getText().toString();
        String bio = e6.getText().toString();
        if (username.length() <1) {
            Toast.makeText(this.getApplicationContext(), "Please enter a username", Toast.LENGTH_SHORT).show();
        }else if (!(password.equals(confirm))) {
            Toast.makeText(this.getApplicationContext(), "Your password must match!", Toast.LENGTH_SHORT).show();
        }
        else {

            String writedata = username + "," + password + "," + school + "," + hometown + "," + major + "," + bio + "\n";
            String filename = "data.txt";

            try {
                FileOutputStream outputStream = this.openFileOutput(filename, Context.MODE_APPEND);
                outputStream.write(writedata.getBytes());
                outputStream.close();
                Toast.makeText(this.getApplicationContext(), "Your account has been created!", Toast.LENGTH_SHORT).show();
            } catch (Exception var17) {
                var17.printStackTrace();
            }

            this.finish();
        }

    }
}
