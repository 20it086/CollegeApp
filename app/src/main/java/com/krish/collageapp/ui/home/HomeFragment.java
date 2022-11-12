package com.krish.collageapp.ui.home;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.krish.collageapp.R;
import com.smarteist.autoimageslider.DefaultSliderView;
import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderLayout;
import com.smarteist.autoimageslider.SliderView;

import kotlin.random.Random;

public class HomeFragment extends Fragment {

    private SliderLayout sliderLayout;
    private ImageView map;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        sliderLayout = view.findViewById(R.id.slider);

        sliderLayout.setIndicatorAnimation(IndicatorAnimations.FILL);
        sliderLayout.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        sliderLayout.setScrollTimeInSec(1);

        setSliderImage();

        map = view.findViewById(R.id.map);
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

    private void setSliderImage() {
        for (int i=0;i<5;i++){
            DefaultSliderView sliderView = new DefaultSliderView(getContext());
            switch (i){
                case 0:
                    sliderView.setImageUrl("https://firebasestorage.googleapis.com/v0/b/collage-app-8412d.appspot.com/o/Slider%2Fslider1.jpg?alt=media&token=3c0c0d84-4a8d-4801-b174-85600fe5416e");
                break;
                case 1:
                    sliderView.setImageUrl("https://firebasestorage.googleapis.com/v0/b/collage-app-8412d.appspot.com/o/Slider%2Fslider2.jpg?alt=media&token=a1c31a9c-aad0-4cbb-b0b6-a8a9cc86e275");
                break;
                case 2:
                    sliderView.setImageUrl("https://firebasestorage.googleapis.com/v0/b/collage-app-8412d.appspot.com/o/Slider%2Fslider3.jpeg?alt=media&token=ccaf0454-8e44-40cc-b57f-c7c442199df9");
                break;
                case 3:
                    sliderView.setImageUrl("https://firebasestorage.googleapis.com/v0/b/collage-app-8412d.appspot.com/o/Slider%2Fslider4.jpg?alt=media&token=51cd882a-f49b-455e-893f-628bfb59160c");
                    break;
                case 4:
                    sliderView.setImageUrl("https://firebasestorage.googleapis.com/v0/b/collage-app-8412d.appspot.com/o/Slider%2Fslider5.jpg?alt=media&token=66749c2d-216e-4cd3-8c02-2d139f89a08c");
                    break;
            }
            sliderView.setImageScaleType(ImageView.ScaleType.FIT_XY);

            sliderLayout.addSliderView(sliderView);
        }
    }
}