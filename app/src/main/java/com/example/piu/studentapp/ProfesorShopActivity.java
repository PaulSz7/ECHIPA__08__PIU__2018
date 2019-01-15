package com.example.piu.studentapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;

import com.example.piu.studentapp.adapters.ShopListAdapter;
import com.example.piu.studentapp.models.ShopItem;

import java.util.ArrayList;
import java.util.List;

public class ProfesorShopActivity extends AppCompatActivity {

    private AlertDialog alertDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profesor_shop);

        TextView username = (TextView) findViewById(R.id.tv_username);
        username.setText(Store.role);

        List<ShopItem> shopList = new ArrayList<ShopItem>(Store.shopList);
        shopList.add(new ShopItem("Adauga bonus", 0));

        GridView gv = findViewById(R.id.shop_grid);
        ShopListAdapter shopListAdapter = new ShopListAdapter(this, shopList);

        // Data bind GridView with ArrayAdapter (String Array elements)
        gv.setAdapter(shopListAdapter);

        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {

                if (position == Store.shopList.size()) {
                    Intent intent = new Intent(parent.getContext(), NewShopItemActivity.class);
                    startActivity(intent);
                }
            }
        });
    }

    public void shopClick(View view) {
        System.out.println("**/**");
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
