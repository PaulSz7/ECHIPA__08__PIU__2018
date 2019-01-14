package com.example.piu.studentapp;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import static java.lang.Thread.sleep;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void loginClick(View view) {
        EditText username = findViewById(R.id.username);
        EditText password = findViewById(R.id.password);

        TextView usernameError = (TextView) findViewById(R.id.usernameError);
        TextView passwordError = (TextView) findViewById(R.id.passwordError);

        boolean letLogin = true;

        if (username.getText().length() == 0) {
            usernameError.setText("Campul nume utilizator nu poate fi gol!");
            letLogin = false;
        }
        else if (username.getText().length() < 3 && username.getText().length() != 0) {
            usernameError.setText("Numele de utilizator este prea scurt!");
            letLogin = false;
        }
        else {
            usernameError.setText("");
        }

        if (password.getText().length() == 0) {
            passwordError.setText("Campul parola nu poate fi gol!");
            letLogin = false;
        }
        else if (password.getText().length() < 3 && password.getText().length() != 0) {
            passwordError.setText("Parola este prea scurta!");
            letLogin = false;
        }
        else {
            passwordError.setText("");
        }

        TextView resultMsg = (TextView) findViewById(R.id.resultMsg);
        if (!letLogin) return;

        if (username.getText().toString().equals("profesor") && password.getText().toString().equals("parola")) {
            resultMsg.setText("Autentificare reusita (PROFESOR)!");
            resultMsg.setTextColor(Color.GREEN);

            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Intent intent = new Intent(this, MainMenu.class);
            intent.putExtra("role", "profesor");
            startActivity(intent);
        }
        else if (username.getText().toString().equals("student") && password.getText().toString().equals("parola")) {
            resultMsg.setText("Autentificare reusita (STUDENT)!");
            resultMsg.setTextColor(Color.GREEN);

            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Intent intent = new Intent(this, MainMenu.class);
            intent.putExtra("role", "student");
            startActivity(intent);

        }
        else {
            resultMsg.setText("Autentificare esuata\nNume de utilizator sau parola gresita!");
            resultMsg.setTextColor(Color.RED);
        }
    }
}
