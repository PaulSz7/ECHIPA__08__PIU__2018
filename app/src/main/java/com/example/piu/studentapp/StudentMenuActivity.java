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

public class StudentMenuActivity extends AppCompatActivity {

    private AlertDialog alertDialog;
    String role;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_menu);

        TextView tvPoints = findViewById(R.id.tv_points);
        tvPoints.setText(Store.sold.toString());

        role = getIntent().getStringExtra("role");
        TextView username = (TextView) findViewById(R.id.tv_username);
        username.setText(role);
    }

    public void onClick(View view) {
        if (view.getId() == R.id.sub_shop) {
            Intent intent = new Intent(this, ShopActivity.class);
            startActivityForResult(intent, 0);
            return;
        }

        Class myClass;
        switch (view.getId()) {
            case R.id.sub_harta:
                myClass = CheckInActivity.class;
                break;
            case R.id.sub_feedback:
                myClass = RatingActivity.class;
                break;
            case R.id.tv_forum:
                myClass = ForumActivity.class;
                break;
            case R.id.sub_forum:
                myClass = ForumActivity.class;
                break;
            case R.id.iv_chatIcon:
                myClass = ChatActivity.class;
                break;
            case R.id.iv_notifIcon:
                myClass = NotificationActivity.class;
                break;
            case R.id.sub_cursuri:
                myClass = CoursesActivity.class;
                break;
            case R.id.sub_quiz:
                myClass = Quiz1Activity.class;
                break;
            case R.id.sub_laboratoare:
                myClass = LaboratorActivity.class;
                break;
            default:
                myClass = LoginActivity.class;
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
        alertDialog.setMessage("You sure you wanna sign out?");
        alertDialog.setButton(DialogInterface.BUTTON_POSITIVE, "YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                finish();
            }
        });
        alertDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                alertDialog.dismiss();
            }
        });
        alertDialog.show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        TextView tvPoints = findViewById(R.id.tv_points);
        tvPoints.setText(Store.sold.toString());
    }
}
