package com.example.week6daily2.view.activity;


import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.example.week6daily2.R;
import com.example.week6daily2.databinding.ActivityMainBinding;
import com.example.week6daily2.model.datasource.local.OnItemTouch;
import com.example.week6daily2.model.datasource.local.OnItemTouchHelper;
import com.example.week6daily2.model.datasource.remote.FlickrRetroFit;
import com.example.week6daily2.model.flickr.FlickrResponse;
import com.example.week6daily2.view.adapter.FlickerRVAdapter;
import com.example.week6daily2.viewmodel.FlickrViewModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    FlickrViewModel flickrViewModel = new FlickrViewModel();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding activityMainBinding =
                DataBindingUtil.setContentView(this, R.layout.activity_main);
        activityMainBinding.setViewmodel(flickrViewModel);
        flickrViewModel.getFlickData();

//        rvFlicker = findViewById(R.id.rvFlickrRV);
//        rvFlicker.addOnItemTouchListener(new OnItemTouch(getApplicationContext(), rvFlicker, new OnItemTouchHelper() {
//
//
//            @Override
//            public boolean onSingleTapUp(MotionEvent event) {
//                return false;
//            }
//
//            @Override
//            public void onClick(View view, int position) {
//
//            }
//
//            @Override
//            public void onLongClick(View view, int position)

    }

    @BindingAdapter("bind:flickrResponse")
    public static void initFlickrRV(RecyclerView recyclerView, FlickrResponse flickrResponse) {
        if (flickrResponse != null) {
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(recyclerView.getContext());
            FlickerRVAdapter adapter = new FlickerRVAdapter(flickrResponse.getItems());
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setAdapter(adapter);
        }
    }


}

