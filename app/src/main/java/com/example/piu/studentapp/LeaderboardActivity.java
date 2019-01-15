package com.example.piu.studentapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.piu.studentapp.adapters.LeaderboardAdapter;
import com.example.piu.studentapp.models.LeaderboardItem;

import java.util.Collections;
import java.util.Comparator;

public class LeaderboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leaderboard);

        TextView tvPoints = findViewById(R.id.tv_points);
        tvPoints.setText(Store.sold.toString());

        ListView lv = findViewById(R.id.leaderboard);

        Collections.sort(Store.leaderboard, new Comparator<LeaderboardItem>() {
            @Override
            public int compare(LeaderboardItem l, LeaderboardItem r) {
                // -1 - less than, 1 - greater than, 0 - equal, all inversed for descending
                return l.credit > r.credit ? -1 : (l.credit < r.credit) ? 1 : 0;
            }
        });
        LeaderboardAdapter shopListAdapter = new LeaderboardAdapter(this, Store.leaderboard);
        lv.setAdapter(shopListAdapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {

                Intent intent = new Intent(parent.getContext(), LeaderboardActivity.class);
                startActivityForResult(intent, 1);
            }
        });
    }

    public void provoacaClick(View view) {
        System.out.println(view.getId());
        int id = view.getId();

        Intent intent = new Intent(this, Quiz1Activity.class);
        intent.putExtra("oponentName", Store.leaderboard.get(id).name);
        startActivity(intent);
    }
}
