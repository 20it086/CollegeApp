package com.krish.collageapp.ui.faculty;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.krish.collageapp.R;

import java.util.ArrayList;
import java.util.List;

public class FacultyFragment extends Fragment {

    private RecyclerView csDepartment,meDepartment,civilDepartment,computerDepartment;
    private LinearLayout csNoData,meNoData,civilNoData,computerNoData;
    private List<TeacherData> list1,list2,list3,list4;
    private DatabaseReference reference,dbRef;
    private TeacherAdapter adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_faculty, container, false);
        csDepartment = view.findViewById(R.id.csDepartment);
        meDepartment = view.findViewById(R.id.meDepartment);
        civilDepartment = view.findViewById(R.id.civilDepartment);
        computerDepartment = view.findViewById(R.id.computerDepartment);

        csNoData = view.findViewById(R.id.csNoData);
        meNoData = view.findViewById(R.id.meNoData);
        civilNoData = view.findViewById(R.id.civilNoData);
        computerNoData = view.findViewById(R.id.computerNoData);

        reference = FirebaseDatabase.getInstance().getReference().child("teacher");

        csDepartment();
        meDepartment();
        civilDepartment();
        computerDepartment();

        return view;
    }

    private void csDepartment() {
        dbRef = reference.child("Computer Science");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list1 = new ArrayList<TeacherData>();
                if (!snapshot.exists()){
                    csNoData.setVisibility(View.VISIBLE);
                    csDepartment.setVisibility(View.GONE);
                }else {
                    csNoData.setVisibility(View.GONE);
                    csDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot1: snapshot.getChildren()){
                        TeacherData data = snapshot1.getValue(TeacherData.class);
                        list1.add(data);
                    }
                    csDepartment.setHasFixedSize(true);
                    csDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(list1,getContext());
                    csDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(),error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void meDepartment() {
        dbRef = reference.child("Mechanical");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list2 = new ArrayList<TeacherData>();
                if (!snapshot.exists()){
                    meNoData.setVisibility(View.VISIBLE);
                    meDepartment.setVisibility(View.GONE);
                }else {
                    meNoData.setVisibility(View.GONE);
                    meDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot1: snapshot.getChildren()){
                        TeacherData data = snapshot1.getValue(TeacherData.class);
                        list2.add(data);
                    }
                    meDepartment.setHasFixedSize(true);
                    meDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(list2,getContext());
                    meDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(),error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void civilDepartment() {
        dbRef = reference.child("Civil");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list3 = new ArrayList<TeacherData>();
                if (!snapshot.exists()){
                    civilNoData.setVisibility(View.VISIBLE);
                    civilDepartment.setVisibility(View.GONE);
                }else {
                    civilNoData.setVisibility(View.GONE);
                    civilDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot1: snapshot.getChildren()){
                        TeacherData data = snapshot1.getValue(TeacherData.class);
                        list3.add(data);
                    }
                    civilDepartment.setHasFixedSize(true);
                    civilDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(list3,getContext());
                    civilDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(),error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void computerDepartment() {
        dbRef = reference.child("Computer Engineering");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list4 = new ArrayList<TeacherData>();
                if (!snapshot.exists()){
                    computerNoData.setVisibility(View.VISIBLE);
                    computerDepartment.setVisibility(View.GONE);
                }else {
                    computerNoData.setVisibility(View.GONE);
                    computerDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot1: snapshot.getChildren()){
                        TeacherData data = snapshot1.getValue(TeacherData.class);
                        list4.add(data);
                    }
                    computerDepartment.setHasFixedSize(true);
                    computerDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(list4,getContext());
                    computerDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(),error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}