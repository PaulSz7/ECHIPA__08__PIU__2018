package com.example.piu.studentapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

public class LabGuide extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_guide);

        TextView content = (TextView) findViewById(R.id.textView11);
        content.setMovementMethod(new ScrollingMovementMethod());
    }
}
