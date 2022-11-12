 package com.krish.collageapp.ebook;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.facebook.shimmer.Shimmer;
import com.facebook.shimmer.ShimmerFrameLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.krish.collageapp.R;

import java.util.ArrayList;
import java.util.List;

 public class EbookActivity extends AppCompatActivity {

     private RecyclerView ebookRecycler;
     private DatabaseReference reference;
     private List<EbookData> list;
     private EbookAdpter adpter;

     private ShimmerFrameLayout shimmer_view_container;
     private LinearLayout shimmer_layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ebook);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Ebooks");

        ebookRecycler = findViewById(R.id.ebookRecycler);
        shimmer_view_container = findViewById(R.id.shimmer_view_container);
        shimmer_layout = findViewById(R.id.shimmer_layout);
        reference = FirebaseDatabase.getInstance().getReference().child("pdf");

        getData();
    }

     private void getData() {
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list = new ArrayList<>();
                for (DataSnapshot dataSnapshot:snapshot.getChildren() ){
                    EbookData data = dataSnapshot.getValue(EbookData.class);
                    list.add(data);
                }
                adpter = new EbookAdpter(EbookActivity.this,list);
                ebookRecycler.setLayoutManager(new LinearLayoutManager(EbookActivity.this));
                ebookRecycler.setAdapter(adpter);
                shimmer_view_container.stopShimmer();
                shimmer_layout.setVisibility(View.GONE);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(EbookActivity.this, error.getMessage() , Toast.LENGTH_SHORT).show();
            }
        });
     }

     @Override
     protected void onPause() {
         shimmer_view_container.stopShimmer();
         super.onPause();
     }

     @Override
     protected void onResume() {
        shimmer_view_container.startShimmer();
         super.onResume();
     }
 }