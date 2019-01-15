package com.example.piu.studentapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.piu.studentapp.models.ShopItem;

public class NewShopItemActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_shop_item);
    }

    public void addClick(View view) {
        EditText bonusName = findViewById(R.id.bonusName);
        EditText price = findViewById(R.id.price);

        if(price.getText().toString().equals("")){
            Toast.makeText(this, "Campul pret nu poate fi gol !", Toast.LENGTH_SHORT).show();
        }

        if(bonusName.getText().toString().equals("")){
            Toast.makeText(this, "Campul nume bonus nu poate fi gol !", Toast.LENGTH_SHORT).show();
        }

        if(!price.getText().toString().equals("") && !bonusName.getText().toString().equals("")){
            Store.shopList.add(new ShopItem(bonusName.getText().toString(), Integer.parseInt(price.getText().toString())));

            Intent intent = new Intent(this, ProfesorShopActivity.class);
            startActivity(intent);
        }
    }

}
