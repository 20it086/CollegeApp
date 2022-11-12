package com.krish.collageapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.github.chrisbanes.photoview.PhotoView;

public class FullImageView extends AppCompatActivity {

    private com.github.chrisbanes.photoview.PhotoView PhotoView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_image_view);

        PhotoView = findViewById(R.id.fullImageView);
        String image = getIntent().getStringExtra("image");

        Glide.with(this).load(image).into(PhotoView);
    }
}