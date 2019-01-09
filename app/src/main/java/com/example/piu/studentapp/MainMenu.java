package com.example.piu.studentapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainMenu extends AppCompatActivity {
    ImageView ivProfile = null;
    ImageView ivChat = null;
    ImageView ivNotif = null;
    ImageView ivPointsIcon = null;
    TextView tvUsername = null;
    TextView tvPoints = null;

    Button subject1 = null;
    Button subject2 = null;
    Button subject3 = null;

    EditText etSearch = null;
    ImageView ivSearch = null;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu);

        ivProfile = findViewById(R.id.iv_profile);
        ivChat = findViewById(R.id.iv_chatIcon);
        ivNotif = findViewById(R.id.iv_notifIcon);
        ivPointsIcon = findViewById(R.id.iv_pointsIcon);
        tvUsername = findViewById(R.id.tv_username);
        tvPoints = findViewById(R.id.tv_points);

        subject1 = findViewById(R.id.sub1);
        subject2 = findViewById(R.id.sub2);
        subject3 = findViewById(R.id.sub3);

        etSearch = findViewById(R.id.et_search);
        ivSearch = findViewById(R.id.iv_search);
    }

    public void onClick(View view) {
        if (view == subject1) {
            Intent intent = new Intent(this, StudentMenuActivity.class);
            startActivity(intent);
        }
    }
}
