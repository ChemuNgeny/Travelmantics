package com.example.travelmantics;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

import butterknife.BindView;

public class DealAdapter extends RecyclerView.Adapter<DealAdapter.DealViewholder>{

    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference dbReference;
    private ChildEventListener childEventListener;
    private ArrayList<TravelDeal> travelDeals;

    public DealAdapter() {
        FirebaseUtil.openFbReference("traveldeals");

        firebaseDatabase = FirebaseUtil.firebaseDb;
        dbReference = FirebaseUtil.dbReference;

        travelDeals = FirebaseUtil.travelDeals;

        dbReference.addChildEventListener(childEventListener);
        childEventListener = new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                TravelDeal td = dataSnapshot.getValue(TravelDeal.class);
//                td.setText(travelDeals.getText() + "\n" + td.getTitle());
                Log.d("Deal", td.getTitle());
                td.setId(dataSnapshot.getKey());
                travelDeals.add(td);

                notifyItemInserted(travelDeals.size()-1);
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        };
    }

    @NonNull
    @Override
    public DealViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View itemView = LayoutInflater.from(context).inflate(R.layout.rv_row, parent, false);
        return new DealViewholder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull DealViewholder holder, int position) {
        TravelDeal deal = travelDeals.get(position);
        holder.bind(deal);//binding to the viewholder
    }

    @Override
    public int getItemCount() {
        return travelDeals.size();
    }

    //viewholder describes a view of the recycler view and sends data in to the db

    public class DealViewholder extends RecyclerView.ViewHolder{

        @BindView(R.id.tvTitle)
        TextView title;
        public DealViewholder(@NonNull View itemView) {
            super(itemView);
//            title = itemView.findViewById(R.id.tvTitle);
        }

        public void bind(TravelDeal deal){
            title.setText(deal.getTitle());
        }
    }
}
