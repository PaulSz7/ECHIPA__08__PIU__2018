package com.example.piu.studentapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class LabWork extends AppCompatActivity {

    LinearLayout layoutGrade;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_work);

        layoutGrade = findViewById(R.id.linearLayout6);
        layoutGrade.setVisibility(View.INVISIBLE);
    }

    public void buttonEval(View view){
        layoutGrade.setVisibility(View.VISIBLE);
        Store.sold += 800;
    }

    public void buttonBack(View view){
        Intent I = new Intent(LabWork.this, LaboratorActivity.class);
        startActivity(I);
    }
}
