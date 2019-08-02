package com.example.travelmantics;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class FirebaseUtil {
    public static FirebaseDatabase firebaseDb;
    public static DatabaseReference dbReference;
    private static FirebaseUtil firebaseUtil;
    public static ArrayList<TravelDeal> travelDeals;

    private FirebaseUtil(){}

    public static void openFbReference (String reference){
        if (firebaseUtil == null){
            firebaseUtil = new FirebaseUtil();
            firebaseDb = FirebaseDatabase.getInstance();
            travelDeals = new ArrayList<TravelDeal>();
        }

        dbReference = firebaseDb.getReference().child(reference);
    }
}


