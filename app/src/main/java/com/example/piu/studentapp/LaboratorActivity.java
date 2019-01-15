package com.example.piu.studentapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class LaboratorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laborator);
    }

    public void onClick(View view) {
        Class myClass;
        switch (view.getId()) {
            case R.id.tv_indrumatorL:
                myClass = LabGuide.class;
                break;
            case R.id.tv_cerinteL:
                myClass = LabRequirements.class;
                break;
            case R.id.tv_activitateL:
                myClass = LabWork.class;
                break;
            default:
                myClass = LoginActivity.class;
                break;
        }
        Intent intent = new Intent(this, myClass);
        startActivity(intent);
    }

    public void backButton(View view){
        Intent I = new Intent(LaboratorActivity.this, StudentMenuActivity.class);
        I.putExtra("role","student");
        startActivity(I);
    }
}
