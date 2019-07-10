package com.example.week6daily2.view.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.week6daily2.R;

public class FullImageActivity extends AppCompatActivity {
    ImageView fullScreen;
    String imageLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_image);
        fullScreen = findViewById(R.id.imgFullImage);
        imageLink = getIntent().getStringExtra("image");
        Glide.with(fullScreen).load(imageLink).into(fullScreen);

    }
}
