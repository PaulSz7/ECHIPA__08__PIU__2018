package com.example.piu.studentapp;

import com.example.piu.studentapp.models.LeaderboardItem;
import com.example.piu.studentapp.models.ShopItem;

import java.util.ArrayList;
import java.util.List;

public class Store {
    public static Integer sold = 1050;
    public static String numeStudent = "student";
    public static String role = "";

    public static List<LeaderboardItem> leaderboard = new ArrayList<LeaderboardItem>();
    public static List<ShopItem> shopList = new ArrayList<>();

    public static void populateLeaderboard() {
        if (leaderboard.size() < 1) {
            LeaderboardItem item1 = new LeaderboardItem("Cosmin Gordon", 1400);
            LeaderboardItem item2 = new LeaderboardItem("George Fertea", 3200);
            LeaderboardItem item3 = new LeaderboardItem("Ana Chiorean", 3300);
            LeaderboardItem item4 = new LeaderboardItem(numeStudent, sold);
            LeaderboardItem item5 = new LeaderboardItem("Daria Palacean", 900);

            leaderboard.add(item1);
            leaderboard.add(item2);
            leaderboard.add(item3);
            leaderboard.add(item4);
            leaderboard.add(item5);
        }
    }

    public static void populateShopList() {
        if (shopList.size() < 1) {
            shopList.add(new ShopItem("+ 1 Punct la examen", 5000));
            shopList.add(new ShopItem("+ 1 Prezenta la curs", 1000));
            shopList.add(new ShopItem("+ 1 Punct la colocviu", 3000));
            shopList.add(new ShopItem("+ 1 Saptamana la tema 3", 1800));
        }
    }

    public static void setSold(int new_credit) {
        for (LeaderboardItem item : leaderboard) {
            if (item.name.equals(numeStudent)) {
                sold = new_credit;
                item.credit = new_credit;
            }
        }
    }

    public static void setSold(String name, int new_credit) {
        for (LeaderboardItem item : leaderboard) {
            if (item.name.equals(name)) {
                item.credit += new_credit;
            }
        }
    }
}
