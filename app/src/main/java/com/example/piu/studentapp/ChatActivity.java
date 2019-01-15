package com.example.piu.studentapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.List;

public class ChatActivity extends AppCompatActivity {

    private AlertDialog alertDialog;
    ChatListAdapter adapter;
    List<String> arrayList= new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        arrayList.add("Alina Pop");
        arrayList.add("Florin Coman");
        arrayList.add("Alex Socaci");
        arrayList.add("Julia Pop");
        arrayList.add("Attila Szekely");
        arrayList.add("Paul Szabo");
        arrayList.add("Cristiano Ronaldo");
        arrayList.add("Teodor Stefanut");

        ListView list = (ListView) findViewById(R.id.listView);
        adapter= new ChatListAdapter(arrayList);
        list.setAdapter(adapter);

        SearchView searchView = findViewById(R.id.searchContact);
        searchView.setActivated(true);
        searchView.setQueryHint("Cauta utilizator");
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
                ImageView notification = (ImageView) findViewById(R.id.imageViewNotification);
                notification.setVisibility(View.INVISIBLE);
                intent.putExtra("name", adapter.getItem(position));
                startActivity(intent);
            }
        });
    }

    public void chatClick(View view) {
        final Intent intent = new	Intent(this, PrivateChatActivity.class);
        ImageView notification = (ImageView) findViewById(R.id.imageViewNotification);
        notification.setVisibility(View.INVISIBLE);
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
