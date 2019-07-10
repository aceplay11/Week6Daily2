package com.example.week6daily2.model.datasource.remote;

import android.util.Log;

import com.example.week6daily2.model.flickr.FlickrResponse;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class FlickrObserver implements Observer<FlickrResponse> {
    CallBack callBack;
    FlickrResponse flickrResponse;

    public FlickrObserver(CallBack callBack) {
        this.callBack = callBack;
    }

    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onNext(FlickrResponse flickrResponse) {
    this.flickrResponse = flickrResponse;
    }

    @Override
    public void onError(Throwable e) {
        Log.e("TAG", "onError: Flickr has Failed", e);
    }

    @Override
    public void onComplete() {
    callBack.onFlickrResult(flickrResponse);
    }
}
