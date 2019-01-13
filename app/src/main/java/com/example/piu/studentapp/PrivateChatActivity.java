package com.example.piu.studentapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class PrivateChatActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_private_chat);

        Intent myIntent = getIntent();

        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText(myIntent.getStringExtra("name"));
    }
}
