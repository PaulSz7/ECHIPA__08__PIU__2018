package com.example.piu.studentapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.piu.studentapp.R;
import com.example.piu.studentapp.models.ShopItem;

import java.util.List;

public class ShopListAdapter extends ArrayAdapter<ShopItem> {

    Context context;
    List<ShopItem> shopList;

    public	ShopListAdapter(Context context, List<ShopItem> shopList) {
        super(context,	0,	shopList);
        this.context = context;
        this.shopList = shopList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View myRow = (convertView == null) ? inflater.inflate(R.layout.shop_item,	parent, false) : convertView;

        TextView name = (TextView) myRow.findViewById(R.id.shop_item_name);
        name.setText(shopList.get(position).name);

        TextView price = (TextView) myRow.findViewById(R.id.shop_item_price);
        price.setText(new Integer(shopList.get(position).price).toString());
        return	myRow;
    }
}
