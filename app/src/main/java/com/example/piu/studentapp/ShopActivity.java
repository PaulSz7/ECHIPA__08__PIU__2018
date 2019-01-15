package com.example.piu.studentapp;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;

import com.example.piu.studentapp.adapters.ShopListAdapter;
import com.example.piu.studentapp.models.ShopItem;

import java.util.ArrayList;
import java.util.List;

public class ShopActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);

        TextView tvPoints = findViewById(R.id.tv_points);
        tvPoints.setText(Store.sold.toString());

        GridView gv = findViewById(R.id.shop_grid);
        ShopListAdapter shopListAdapter = new ShopListAdapter(this, Store.shopList);

        // Data bind GridView with ArrayAdapter (String Array elements)
        gv.setAdapter(shopListAdapter);

        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {

                TextView soldView = findViewById(R.id.tv_points);
                int sold = Integer.parseInt(soldView.getText().toString());

                if (sold >= Store.shopList.get(position).price) {
                    Store.setSold(Store.sold - Store.shopList.get(position).price);
                    soldView.setText(Store.sold.toString());

                    AlertDialog.Builder builder = new AlertDialog.Builder(parent.getContext());
                    builder
                        .setMessage("Achizitionare efectuata cu succes")
                        .setNeutralButton("OK", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        })
                        .show();
                }
                else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(parent.getContext());
                    builder
                        .setMessage("Credit insuficient")
                        .setNeutralButton("OK", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        })
                        .show();
                }

            }
        });
    }

    public void shopClick(View view) {
        System.out.println("**/**");
    }
}
