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
    static int nrWeeks = 0;
    EditText weeks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reports);

        answer1 = findViewById(R.id.answer1);
        answer2 = findViewById(R.id.answer2);
        rg1  = (RadioGroup) findViewById(R.id.rgroup);

         weeks = (EditText) findViewById(R.id.weeks);
    }

    public void rbclick(View view){
        int rbId = rg1.getCheckedRadioButtonId();
        RadioButton rb = (RadioButton) findViewById(rbId);
    }

    public void generateClick(View view) {
        nrWeeks = Integer.parseInt(weeks.getText().toString());

        if(answer1.isChecked()){
            if(nrWeeks > 0) {
                Intent I = new Intent(ReportsActivity.this, AttendanceChartActivity.class);
                startActivity(I);
            }
            else{
                Toast.makeText(this, "Selecteaza numarul de saptamani !", Toast.LENGTH_SHORT).show();
            }
        }

        if(answer2.isChecked() ){
            if(nrWeeks > 0){
                Intent I = new Intent(ReportsActivity.this, AverageChartActivity.class);
                startActivity(I);
            }
            else{
                Toast.makeText(this, "Selecteaza numarul de saptamani !", Toast.LENGTH_SHORT).show();
            }
        }

        if(!answer1.isChecked() && !answer2.isChecked()){
            Toast.makeText(this, "Selecteaza graficul pentru raport !", Toast.LENGTH_SHORT).show();
        }
    }

    public int weeksNumber(){
        return nrWeeks;
    }

    public void backClick(View view) {
        Intent I=new Intent(ReportsActivity.this, ProfesorMenuActivity.class);
        I.putExtra("role","profesor");
        startActivity(I);
    }
}
