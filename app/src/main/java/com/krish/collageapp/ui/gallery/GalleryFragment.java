package com.krish.collageapp.ui.gallery;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.krish.collageapp.R;

import java.util.ArrayList;
import java.util.List;

public class GalleryFragment extends Fragment {

    RecyclerView convoRecyclerview,indepenRecycler,otherRecycler;
    GalleryAdapter adapter;

    DatabaseReference reference;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_gallery, container, false);
        convoRecyclerview = view.findViewById(R.id.convoRecyclerview);
        indepenRecycler = view.findViewById(R.id.indepenRecycler);
        otherRecycler = view.findViewById(R.id.otherRecycler);

        reference = FirebaseDatabase.getInstance().getReference().child("Gallery");
        getConvoImage();
        getIndepenImage();
        getOtherImage();

        return view;
    }

    private void getOtherImage() {
        reference.child("Others Events").addValueEventListener(new ValueEventListener() {
            List<String> imageList = new ArrayList<>();
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot: snapshot.getChildren()){
                    String data = (String) dataSnapshot.getValue();
                    imageList.add(data);
                }
                adapter = new GalleryAdapter(getContext(),imageList);
                otherRecycler.setLayoutManager(new GridLayoutManager(getContext(),3));
                otherRecycler.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void getIndepenImage() {
    }

    private void getConvoImage() {
        reference.child("Convocation").addValueEventListener(new ValueEventListener() {
            List<String> imageList = new ArrayList<>();
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot: snapshot.getChildren()){
                    String data = (String) dataSnapshot.getValue();
                    imageList.add(data);
                }
                adapter = new GalleryAdapter(getContext(),imageList);
                convoRecyclerview.setLayoutManager(new GridLayoutManager(getContext(),3));
                convoRecyclerview.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}