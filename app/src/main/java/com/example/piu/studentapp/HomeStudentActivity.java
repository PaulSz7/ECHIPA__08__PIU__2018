package com.example.piu.studentapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;

public class HomeStudentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_student);

        String[] options ={"Cursuri", "Laboratoare","Quiz","Forum","Leaderboard","Magazin","Harta","Recenzie"};
        ListAdapter optionsAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,options);

        ListView optionsList = (ListView) findViewById(R.id.optionsList);

        optionsList.setAdapter(optionsAdapter);

        EditText moneyAmount = (EditText) findViewById(R.id.moneyAmount);
        moneyAmount.setText("6250");
    }

}
