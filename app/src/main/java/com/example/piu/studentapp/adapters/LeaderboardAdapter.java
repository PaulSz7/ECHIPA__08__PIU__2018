package com.example.piu.studentapp.adapters;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.piu.studentapp.R;
import com.example.piu.studentapp.Store;
import com.example.piu.studentapp.models.LeaderboardItem;
import com.example.piu.studentapp.models.ShopItem;

import org.w3c.dom.Text;

import java.util.List;

public class LeaderboardAdapter extends ArrayAdapter<LeaderboardItem> {

    Context context;
    List<LeaderboardItem> leaderboard;

    public LeaderboardAdapter(Context context, List<LeaderboardItem> leaderboard) {
        super(context,	0,	leaderboard);
        this.context = context;
        this.leaderboard = leaderboard;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View myRow = (convertView == null) ? inflater.inflate(R.layout.leaderboard_item,	parent, false) : convertView;

        TextView pos = (TextView) myRow.findViewById(R.id.leaderboard_pos);
        pos.setText(new Integer(position + 1).toString());

        TextView name = (TextView) myRow.findViewById(R.id.leaderboard_name);
        name.setText(leaderboard.get(position).name);

        TextView credit = (TextView) myRow.findViewById(R.id.leaderboard_credit);
        credit.setText(leaderboard.get(position).credit.toString());

        Button btn = (Button) myRow.findViewById(R.id.leaderboard_provoaca);
        btn.setId(position);
        if (Store.sold >= leaderboard.get(position).credit) {
            btn.setVisibility(View.INVISIBLE);
        }

        if (Store.role.equals("profesor")) {
            btn.setVisibility(View.INVISIBLE);
        }

        if (Store.numeStudent.equals((leaderboard.get(position).name))) {
            pos.setTypeface(null, Typeface.BOLD);
            name.setTypeface(null, Typeface.BOLD);
            credit.setTypeface(null, Typeface.BOLD);
        }

        return	myRow;
    }
}
