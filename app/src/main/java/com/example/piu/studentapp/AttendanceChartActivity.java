package com.example.piu.studentapp;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class AttendanceChartActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance_chart);
        final ImageView a = (ImageView) findViewById(R.id.attendanceImage);

        ReportsActivity nrWeeks1 = new ReportsActivity();
        int nrWeeks = nrWeeks1.weeksNumber();

        switch (nrWeeks){
            case 4 : {
                a.setImageDrawable(getDrawable(R.drawable.prezente_4_saptamani));
                break;
            }
            case 11: {
                a.setImageDrawable(getDrawable(R.drawable.prezente_11_saptamani));
                break;
            }
            default:{
                Toast.makeText(this, "Nu s-a putut efectua graficul", Toast.LENGTH_SHORT).show();
            }
        }

    }

    public void backClick(View view) {
        Intent I=new Intent(AttendanceChartActivity.this, ReportsActivity.class);
        startActivity(I);
    }
}
