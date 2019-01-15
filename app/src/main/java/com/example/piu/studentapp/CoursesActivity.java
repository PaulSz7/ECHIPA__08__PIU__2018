package com.example.piu.studentapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

public class CoursesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courses);

        String[] courses ={"Curs 1", "Curs 2","Curs 3","Curs 4","Curs 5","Curs 6","Curs 7",
                "Curs 8","Curs 9","Curs 10","Curs 11","Curs 12","Curs 13","Curs 14"};
        ListAdapter coursesAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,courses);

        final ListView coursesList = (ListView) findViewById(R.id.coursesList);

        coursesList.setAdapter(coursesAdapter);

        coursesList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent I = new Intent(CoursesActivity.this, CourseActivity.class);
                I.putExtra("CourseNr",position);
                startActivity(I);
            }
        });
    }

    public void backClick(View view) {
        Class myClass;
        if (Store.role.equals("profesor")) {
            myClass = ProfesorMenuActivity.class;
        }
        else {
            myClass = StudentMenuActivity.class;
        }

        Intent I=new Intent(CoursesActivity.this, myClass);
        I.putExtra("role",Store.role);
        startActivity(I);
    }
}
