package com.example.piu.studentapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Quiz2Activity extends AppCompatActivity {

    private CountDownTimer countDownTimer;
    long timeLeft = 6100;
    RadioGroup rg;
    RadioButton answer1;
    RadioButton answer2;
    RadioButton answer3;
    RadioButton answer4;
    static int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // boolean next= false;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_2);

        final TextView timer = (TextView) findViewById(R.id.timeCounter);

        TextView pageN1 = (TextView) findViewById(R.id.pageNumber1);
        TextView pageN2 = (TextView) findViewById(R.id.pageNumber2);

        TextView question = (TextView) findViewById(R.id.question);

        answer1 = findViewById(R.id.answer1);
        answer2 = findViewById(R.id.answer2);
        answer3 = findViewById(R.id.answer3);
        answer4 = findViewById(R.id.answer4);

        rg  = (RadioGroup) findViewById(R.id.rg);

        countDownTimer = new CountDownTimer(timeLeft,1000){
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeft = millisUntilFinished;
                int seconds = (int) (timeLeft / 1000);
                int minutes = seconds / 60;
                seconds = seconds % 60;

                String count = minutes + " : " + seconds;

                timer.setText(String.format("%02d:%02d", minutes, seconds));
            }

            @Override
            public void onFinish() {
                if(answer1.isChecked()){
                    score = 1;
                }
                else
                {
                    score = 0;
                }
                Intent I=new Intent(Quiz2Activity.this, Quiz3Activity.class);
                startActivity(I);
            }
        }.start();

        pageN1.setText("2");
        pageN2.setText("3");
        question.setText("Daca Ana are mere, atunci cine are pere?");
        answer1.setText("Nimeni, ca e criza");
        answer2.setText("Maria");
        answer3.setText("Denisa");
        answer4.setText("Florina");
    }

    public void nextPageClick(View view) {
        if(answer1.isChecked()){
            score = 1;
        }
        else
        {
            score = 0;
        }
        if(!answer1.isChecked() && !answer2.isChecked() && !answer3.isChecked() && !answer4.isChecked()){
            Toast.makeText(this, "Selecteaza un raspuns !", Toast.LENGTH_SHORT).show();
        }
        else {
            Intent I = new Intent(Quiz2Activity.this, Quiz3Activity.class);
            startActivity(I);
            countDownTimer.cancel();
        }
    }

    public void rbclick(View view){
        int rbId = rg.getCheckedRadioButtonId();
        RadioButton rb = (RadioButton) findViewById(rbId);
    }

    public int questionScore(){
        return score;
    }

}
