package com.example.piu.studentapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class FinishQuiz extends AppCompatActivity {

    TextView score;
    TextView totalPoints;
    TextView moneyWon;

    int money;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish_quiz);

        score = (TextView) findViewById(R.id.score);
        totalPoints = (TextView) findViewById(R.id.totalPoints);
        moneyWon = (TextView) findViewById(R.id.moneyWon);

        Quiz1Activity score1 = new Quiz1Activity();
        Quiz2Activity score2 = new Quiz2Activity();
        Quiz3Activity score3 = new Quiz3Activity();

        int s = score1.questionScore() + score2.questionScore() + score3.questionScore();
        score.setText(String.format("%d", s));
        totalPoints.setText("3");

        money = s*200;
        moneyWon.setText(String.format("%d", money));

        String oponentName = getIntent().getStringExtra("oponentName");
        System.out.println("***********************" + oponentName);
        if (oponentName != null) {
            Store.setSold(oponentName, -money);
        }

        Store.setSold(Store.sold + money);
    }

    public void finishQuizClick(View view) {
        String oponentName = getIntent().getStringExtra("oponentName");
        Intent I;
        if (oponentName == null) {
            I = new Intent(FinishQuiz.this, StudentMenuActivity.class);
        }
        else {
            I = new Intent(FinishQuiz.this, LeaderboardActivity.class);
        }
        I.putExtra("role","student");
        startActivity(I);
    }
}
