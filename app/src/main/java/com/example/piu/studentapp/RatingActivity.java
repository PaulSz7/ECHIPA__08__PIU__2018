package com.example.piu.studentapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class RatingActivity extends AppCompatActivity {

    private TextView tvRateTitle = null;
    private TextView tvProfessor = null;
    private ImageView ivProfessor = null;
    private TextView tvRatingResult = null;
    private RatingBar ratingBar = null;
    private Button btnSubmit = null;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rating_activity);

        tvRateTitle = findViewById(R.id.tv_rate_title);
        tvProfessor = findViewById(R.id.tv_rate_professor);
        ivProfessor = findViewById(R.id.iv_prof_picture);

        addListenerOnRatingBar();
        addListenerOnButton();
    }

    public void addListenerOnRatingBar() {

        ratingBar = findViewById(R.id.ratingBar);
        tvRatingResult = findViewById(R.id.txtRatingValue);

        //if rating value is changed,
        //display the current rating value in the result (textview) automatically
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            public void onRatingChanged(RatingBar ratingBar, float rating,
                                        boolean fromUser) {

                tvRatingResult.setText(String.valueOf(rating));

            }
        });
    }


    public void addListenerOnButton() {

        ratingBar = findViewById(R.id.ratingBar);
        btnSubmit = findViewById(R.id.btnSubmit);

        //if click on me, then display the current rating value.
        btnSubmit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Toast.makeText(RatingActivity.this,
                        String.valueOf(ratingBar.getRating()),
                        Toast.LENGTH_SHORT).show();

            }

        });

    }



}
