package com.example.piu.studentapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class CoursesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courses);

        String[] courses ={"Curs 1", "Curs 2","Curs 3","Curs 4","Curs 5","Curs 6","Curs 7",
                "Curs 8","Curs 9","Curs 10","Curs 11","Curs 12","Curs 13","Curs 14"};
        ListAdapter coursesAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,courses);

        ListView coursesList = (ListView) findViewById(R.id.coursesList);

        coursesList.setAdapter(coursesAdapter);

        listview.setOnItemClickListener(new OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?>adapter,View v, int position){
                ItemClicked item = adapter.getItemAtPosition(position);

                Intent intent = new Intent(Activity.this,destinationActivity.class);
                //based on item add info to intent
                startActivity(intent);
            }
        });

        for(int i=1;i<=14;i++){
            if(courses[i-1].isEmpty()){
                Toast.makeText(this, "Cursul nu este disponibil", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void backClick(View view) {
        Intent I=new Intent(CoursesActivity.this, LoginActivity.class);
        startActivity(I);
    }

    public ItemClicked getItem(int position){
        return items.get(position);
    }
}
