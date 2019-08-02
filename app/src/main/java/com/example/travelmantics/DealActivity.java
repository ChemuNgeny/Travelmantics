package com.example.travelmantics;


import android.os.Bundle;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DealActivity extends AppCompatActivity {

    public static FirebaseDatabase firebaseDb;
    public static DatabaseReference dbReference;
    @BindView(R.id.etTitle)
    EditText title;
    @BindView(R.id.etDescription)
    EditText description;
    @BindView(R.id.etPrice)
    EditText price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);
        ButterKnife.bind(this);

        FirebaseUtil.openFbReference("traveldeals");

        firebaseDb = FirebaseUtil.firebaseDb;
        dbReference = FirebaseUtil.dbReference;
    }
}
