package com.example.piu.studentapp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;

public class NotificationActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*.8),(int)(height*.6) );


    }

    public void notificationClick(View view){
        Class myClass;
        switch (view.getId()) {
            case R.id.linearLayout5:
                myClass = LoginActivity.class;//Quiz
                break;
            case R.id.linearLayout7:
                myClass = ForumActivity.class;
                break;
            case R.id.linearLayout8:
                myClass = LoginActivity.class;//Laborator
                break;
            default:
                myClass = LoginActivity.class;
                break;
        }
        Intent intent = new Intent(this, myClass);
        startActivity(intent);
    }
}
