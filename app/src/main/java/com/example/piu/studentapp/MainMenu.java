package com.example.piu.studentapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
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

    private AlertDialog alertDialog;

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
        tvPoints.setText(Store.sold.toString());

        subject1 = findViewById(R.id.sub1);
        subject2 = findViewById(R.id.sub2);
        subject3 = findViewById(R.id.sub3);

        etSearch = findViewById(R.id.et_search);
        ivSearch = findViewById(R.id.iv_search);
    }

    public void onClick(View view) {
        Class myClass;
        switch (view.getId()) {
            case R.id.sub1:
                myClass = StudentMenuActivity.class;
                break;
            case R.id.iv_chatIcon:
                myClass = ChatActivity.class;
                break;
            case R.id.iv_notifIcon:
                myClass = NotificationActivity.class;
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

    /** NEW **/
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

}
