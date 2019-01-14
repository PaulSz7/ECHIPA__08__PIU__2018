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
            usernameError.setText("Username cannot be empty!");
            letLogin = false;
        }
        else if (username.getText().length() < 3 && username.getText().length() != 0) {
            usernameError.setText("Username is too short!");
            letLogin = false;
        }
        else {
            usernameError.setText("");
        }

        if (password.getText().length() == 0) {
            passwordError.setText("Password cannot be empty!");
            letLogin = false;
        }
        else if (password.getText().length() < 3 && password.getText().length() != 0) {
            passwordError.setText("Password is too short!");
            letLogin = false;
        }
        else {
            passwordError.setText("");
        }

        TextView resultMsg = (TextView) findViewById(R.id.resultMsg);
        if (!letLogin) return;

        if (username.getText().toString().equals("profesor") && password.getText().toString().equals("password")) {
            resultMsg.setText("Login successful (profesor)!");
            resultMsg.setTextColor(Color.GREEN);

            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//            Intent intent = new Intent(this, MainMenu.class);
//            startActivity(intent);
        }
        else if (username.getText().toString().equals("student") && password.getText().toString().equals("password")) {
            resultMsg.setText("Login successful (student)!");
            resultMsg.setTextColor(Color.GREEN);

            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Intent intent = new Intent(this, MainMenu.class);
            startActivity(intent);
        }
        else {
            resultMsg.setText("Login failed\nUsername or password is incorrect!");
            resultMsg.setTextColor(Color.RED);
        }
    }
}
