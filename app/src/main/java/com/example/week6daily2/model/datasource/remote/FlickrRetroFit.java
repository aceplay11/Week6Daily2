package com.example.week6daily2.model.datasource.remote;



import com.example.week6daily2.model.flickr.FlickrResponse;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Url;

import static com.example.week6daily2.model.datasource.remote.UrlConstants.BASE_URL;

public class FlickrRetroFit {


    private Retrofit getRetrofitInstance(){
        return new Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

    }

    public GetFlickrService getService(){
        return getRetrofitInstance().create(GetFlickrService.class);
    }

}
