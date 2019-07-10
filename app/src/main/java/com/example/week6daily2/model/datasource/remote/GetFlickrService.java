package com.example.week6daily2.model.datasource.remote;

import com.example.week6daily2.model.flickr.FlickrResponse;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface GetFlickrService {
    @GET
    Observable<FlickrResponse> getFlickrResponse(@Url String url);
}
