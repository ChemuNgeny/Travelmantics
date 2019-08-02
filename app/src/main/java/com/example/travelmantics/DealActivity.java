package com.example.travelmantics;


import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
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
    TravelDeal deal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);
        ButterKnife.bind(this);

        FirebaseUtil.openFbReference("traveldeals");

        firebaseDb = FirebaseUtil.firebaseDb;
        dbReference = FirebaseUtil.dbReference;

        Intent intent = getIntent();
        TravelDeal deal = (TravelDeal) intent.getSerializableExtra("Deal");
        if (deal == null){
            deal = new TravelDeal();
        }
        this.deal = deal;
        title.setText(deal.getTitle());
        price.setText(deal.getPrice());
        description.setText(deal.getDescription());//3.40minutes
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
//            case R.id.save_menu:

        }
        return super.onOptionsItemSelected(item);
    }
}
