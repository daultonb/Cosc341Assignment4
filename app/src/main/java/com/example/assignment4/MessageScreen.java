package com.example.assignment4;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import android.content.Intent;

import android.os.Message;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;
import java.util.Calendar;

public class MessageScreen extends AppCompatActivity {
    int msgnum = 0;
    String name;
    LinearLayout lin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_screen);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        name = bundle.getString("name");
        lin = (LinearLayout) findViewById(R.id.messageBox);
        lin.removeAllViews();
        loadInformation();
        buttonHandler();
    }
    //load Information from connections class
    private void loadInformation() {
        TextView textView = findViewById(R.id.txtConnectionsName);
        textView.setText(name);
    }

    private void buttonHandler() {
        Button button = findViewById(R.id.btnBackToConnections);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intentHandler();
            }
        });

        button = findViewById(R.id.btnSend);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getMessage();
            }
        });
    }
    //Retrieve Message
    private  void getMessage() {
        TextView textView = findViewById(R.id.txtMsgInput);
        String msg = textView.getText().toString();

        if (!(msg.length() <= 0)) {
            System.out.println(msg);
            sendMessageToConversation(msg);
        }else {
            Toast.makeText(getApplicationContext(),"You Must Enter A Message First",Toast.LENGTH_SHORT).show();
        }
    }
    //Pushes message to conversation
    private void sendMessageToConversation(String msg){
        msgnum++;
        TextView timestamp =  new TextView(MessageScreen.this);
        timestamp.setId(msgnum*100);
        timestamp.setText(Calendar.getInstance().getTime().toString());
        timestamp.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        timestamp.setTextColor(Color.GRAY);
        TextView tv =  new TextView(MessageScreen.this);
        tv.setId(msgnum);
        tv.setText(msg);
        tv.setTextColor(Color.BLACK);
        tv.setTextAlignment(View.TEXT_ALIGNMENT_VIEW_END);
        tv.setTextAppearance(this, android.R.style.TextAppearance_Large);
        lin.addView(timestamp);
        lin.addView(tv);


    }
    //Return to previous activity(Connections.class)
    private void intentHandler() {
        finish();
    }
}
