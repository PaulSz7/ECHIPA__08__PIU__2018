package com.example.piu.studentapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class ReportsActivity extends AppCompatActivity {
    RadioGroup rg1;
    RadioButton answer1;
    RadioButton answer2;
    int nrWeeks = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reports);

        answer1 = findViewById(R.id.answer1);
        answer2 = findViewById(R.id.answer2);
        rg1  = (RadioGroup) findViewById(R.id.rgroup);

        EditText weeks = (EditText) findViewById(R.id.weeks);
        nrWeeks = Integer.parseInt(weeks.getText().toString());

    }

    public void rbclick(View view){
        int rbId = rg1.getCheckedRadioButtonId();
        RadioButton rb = (RadioButton) findViewById(rbId);
    }

    public void generateClick(View view) {
        if(answer1.isChecked()){
            Intent I = new Intent(ReportsActivity.this, LoginActivity.class);
            startActivity(I);
        }

        if(answer2.isChecked()){
            Intent I = new Intent(ReportsActivity.this, FinishQuiz.class);
            startActivity(I);
        }

        if(!answer1.isChecked() && !answer2.isChecked()){
            Toast.makeText(this, "Selecteaza graficul pentru raport !", Toast.LENGTH_SHORT).show();
        }

    }
}
