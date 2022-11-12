package com.krish.collageapp.ui.about;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.krish.collageapp.R;

import java.util.ArrayList;
import java.util.List;

public class AboutFragment extends Fragment {

    private ViewPager viewPager;
    private BranchAdapter adapter;
    private List<BranchModel> list;
    private ImageView map;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_about, container, false);

        list = new ArrayList<>();
        list.add(new BranchModel(R.drawable.ic_computer,"Computer Science","Computer Science is the study of computers and computational systems. Unlike electrical and computer engineers, computer scientists deal mostly with software and software systems; this includes their theory, design, development, and application."));
        list.add(new BranchModel(R.drawable.ic_mech,"Mechanical Production","Definition of mechanical (Entry 1 of 2) 1a(1) : of or relating to machinery (see machinery sense 1) or tools mechanical applications of science a mechanical genius mechanical aptitude. (2) : produced or operated by a machine or tool mechanical power a mechanical refrigerator a mechanical saw."));

        adapter = new BranchAdapter(getContext(),list);

        viewPager = view.findViewById(R.id.viewPager);

        viewPager.setAdapter(adapter);

        ImageView imageView = view.findViewById(R.id.collageImage);
        Glide.with(getContext())
                .load("https://firebasestorage.googleapis.com/v0/b/collage-app-8412d.appspot.com/o/Slider%2Fslider1.jpg?alt=media&token=3c0c0d84-4a8d-4801-b174-85600fe5416e")
                .into(imageView);

        map = view.findViewById(R.id.mapabout);
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMap();
            }
        });

        return view;
    }

    private void openMap() {
        Uri uri = Uri.parse("geo:0,0?q=Charotar University of Science and Technology");
        Intent intent = new Intent(Intent.ACTION_VIEW,uri);
        intent.setPackage("com.google.android.apps.maps");
        startActivity(intent);
    }
}