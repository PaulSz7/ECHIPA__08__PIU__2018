package com.example.piu.studentapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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

    TextView subject1 = null;
    TextView subject2 = null;
    TextView subject3 = null;

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
        tvUsername.setText("Julia Pop");
        tvPoints = findViewById(R.id.tv_points);
        tvPoints.setText("37.50");

        subject1 = findViewById(R.id.sub1);
        subject2 = findViewById(R.id.sub2);
        subject3 = findViewById(R.id.sub3);

        etSearch = findViewById(R.id.et_search);
        ivSearch = findViewById(R.id.iv_search);





    }
}
