package com.example.piu.studentapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class StudentMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_menu);
    }

    public void onClick(View view) {
        Class myClass;
        switch (view.getId()) {
            case R.id.sub_harta:
                myClass = CheckInActivity.class;
                break;
            case R.id.sub_feedback:
                myClass = RatingActivity.class;
                break;
            default:
                myClass = LoginActivity.class;
                break;
        }

        Intent intent = new Intent(this, myClass);
        startActivity(intent);
    }
}
