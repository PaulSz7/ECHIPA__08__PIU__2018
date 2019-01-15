package com.example.piu.studentapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class ProfesorMenuActivity extends AppCompatActivity {

    String role;
    private AlertDialog alertDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profesor_menu);

        role = getIntent().getStringExtra("role");
        TextView username = (TextView) findViewById(R.id.tv_username);
        username.setText(role);

    }

    public void onClick(View view) {
        Class myClass;
        switch (view.getId()) {
            case R.id.prof_raport : {
                myClass = ReportsActivity.class;
                break;
            }
            case R.id.tv_forum : {
                myClass = ForumActivity.class;
                break;
            }
            case R.id.prof_forum : {
                myClass = ForumActivity.class;
                break;
            }
            case R.id.tv_leaderboard : {
                myClass = LeaderboardActivity.class;
                break;
            }
            case R.id.prof_leaderboard : {
                myClass = LeaderboardActivity.class;
                break;
            }
            case R.id.prof_cursuri : {
                myClass = CoursesActivity.class;
                break;
            }
            case R.id.prof_shop : {
                myClass = ProfesorShopActivity.class;
                break;
            }
            default:
                myClass = ProfesorMenuActivity.class;
                break;
        }

        Intent intent = new Intent(this, myClass);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_bar, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.sign_out) {
            showSignOutDialog();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void showSignOutDialog() {
        alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setMessage("Esti sigur ca vrei sa te deconectezi?");
        alertDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "Nu", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                alertDialog.dismiss();
            }
        });
        alertDialog.setButton(DialogInterface.BUTTON_POSITIVE, "Da", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                finish();
            }
        });
        alertDialog.show();
    }
}
