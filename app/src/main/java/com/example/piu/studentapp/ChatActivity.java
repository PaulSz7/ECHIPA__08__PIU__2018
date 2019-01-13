package com.example.piu.studentapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.List;

public class ChatActivity extends AppCompatActivity {

    ChatListAdapter adapter;

    List<String> arrayList= new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        arrayList.add("Alina Pop");
        arrayList.add("Florin Coman");

        ListView list = (ListView) findViewById(R.id.listView);
        adapter= new ChatListAdapter(arrayList);
        list.setAdapter(adapter);

        SearchView searchView = findViewById(R.id.searchContact);
        searchView.setActivated(true);
        searchView.setQueryHint("Search contact");
        searchView.onActionViewExpanded();
        searchView.setIconified(false);
        searchView.clearFocus();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                adapter.getFilter().filter(newText);

                return false;
            }
        });

        registerForContextMenu(list);
        final Intent intent = new	Intent(this, PrivateChatActivity.class);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                intent.putExtra("name", adapter.getItem(position));
                startActivity(intent);
            }
        });
    }
}
