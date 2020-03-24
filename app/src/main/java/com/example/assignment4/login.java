package com.example.assignment4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
    public void back(View view){
        finish();
    }
    public void submit(View view){

        EditText e1 = (EditText)this.findViewById(R.id.editText);
        EditText e2 = (EditText)this.findViewById(R.id.editText3);
        String username = e1.getText().toString();
        String password = e2.getText().toString();
        String line;
        try {
            FileInputStream fis = this.openFileInput("data.txt");
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            line = "";
            while((line = br.readLine()) != null) {

                String userinfo = line;
                String dbusername = line.substring(0, line.indexOf(","));
                line = line.substring(line.indexOf(",") + 1, line.length());
                String dbpassword = line.substring(0, line.indexOf(","));
                if((username.equals(dbusername))&&(password.equals(dbpassword))){
                    Intent myin = new Intent(this, MyProfile.class);
                    myin.putExtra("userinfo",userinfo);
                    finish();
                    startActivity(myin);
                    return;



                }




            }
            br.close();
            isr.close();
            fis.close();
        } catch (IOException var8) {
            var8.printStackTrace();
            Toast.makeText(this.getApplicationContext(), "Error: User not found. Please make sure info is correct.", Toast.LENGTH_SHORT).show();
            return;
        }


        Toast.makeText(this.getApplicationContext(), "User not found. Please make sure info is correct."+line, Toast.LENGTH_SHORT).show();
        return;
        //Intent intent = new Intent(this, myprofile.class);
        //startActivity(intent);
    }
}

