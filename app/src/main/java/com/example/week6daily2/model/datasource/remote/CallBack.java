package com.example.week6daily2.model.datasource.remote;

import com.example.week6daily2.model.flickr.FlickrResponse;

public interface CallBack {
    void onFlickrResult(FlickrResponse flickrResponse);
}
