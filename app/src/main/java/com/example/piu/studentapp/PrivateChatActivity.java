package com.example.piu.studentapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class PrivateChatActivity extends AppCompatActivity {

    private AlertDialog alertDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_private_chat);
        LinearLayout layoutMesaj = findViewById(R.id.linearLayout4);

        layoutMesaj.setVisibility(View.INVISIBLE);

    }

    public void buttonClick(View view) {
        Intent myIntent = getIntent();
        LinearLayout layoutMesaj = findViewById(R.id.linearLayout4);

        TextView mesaj = (TextView) findViewById(R.id.textViewMesaj);
        EditText messageToSend = (EditText) findViewById(R.id.textMessage);
        mesaj.setText(messageToSend.getText());

        DateFormat df = new SimpleDateFormat("dd MMM yyyy, HH:mm");
        Date currentTime = Calendar.getInstance().getTime();
        TextView data = (TextView) findViewById(R.id.textViewData);
        data.setText(df.format(currentTime));

        layoutMesaj.setVisibility(View.VISIBLE);
        messageToSend.setText("");
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
