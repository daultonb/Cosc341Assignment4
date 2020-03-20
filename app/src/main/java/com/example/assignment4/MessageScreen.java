package com.example.assignment4;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import android.content.Intent;

import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;

public class MessageScreen extends AppCompatActivity {

    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_screen);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        name = bundle.getString("name");

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
        //TODO PUSH MESSAGE
    }
    //Return to previous activity(Connections.class)
    private void intentHandler() {
        finish();
    }
}
