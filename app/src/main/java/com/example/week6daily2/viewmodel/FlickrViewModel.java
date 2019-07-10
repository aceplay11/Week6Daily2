package com.example.week6daily2.viewmodel;

import androidx.databinding.Bindable;
import androidx.databinding.Observable;
import androidx.databinding.PropertyChangeRegistry;
import androidx.lifecycle.ViewModel;

import com.example.week6daily2.model.datasource.remote.CallBack;
import com.example.week6daily2.model.datasource.remote.FlickrObserver;
import com.example.week6daily2.model.datasource.remote.FlickrRetroFit;
import com.example.week6daily2.model.flickr.FlickrResponse;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

import static com.example.week6daily2.model.datasource.remote.UrlConstants.ACTUAL_URL;

public class FlickrViewModel extends ViewModel implements CallBack, Observable {

    PropertyChangeRegistry propertyChangeRegistry = new PropertyChangeRegistry();

    @Bindable
    FlickrResponse flickrResponse;

    public PropertyChangeRegistry getPropertyChangeRegistry() {
        return propertyChangeRegistry;
    }

    public void setPropertyChangeRegistry(PropertyChangeRegistry propertyChangeRegistry) {
        this.propertyChangeRegistry = propertyChangeRegistry;
    }

    public void getFlickData(){
        FlickrRetroFit flickrRetroFit = new FlickrRetroFit();
        flickrRetroFit.getService().getFlickrResponse(ACTUAL_URL)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new FlickrObserver(this));
    }

    @Override
    public void addOnPropertyChangedCallback(OnPropertyChangedCallback callback) {
        propertyChangeRegistry.add(callback);

    }

    @Override
    public void removeOnPropertyChangedCallback(OnPropertyChangedCallback callback) {
    propertyChangeRegistry.remove(callback);
    }

    @Override
    public void onFlickrResult(FlickrResponse flickrResponse) {
        this.flickrResponse = flickrResponse;
        notifyOfAllPropertyChanged();

    }

    public void notifyOfAllPropertyChanged(){
        propertyChangeRegistry.notifyChange(this,0);
    }

    public FlickrResponse getFlickrResponse() {
        return flickrResponse;
    }

    public void setFlickrResponse(FlickrResponse flickrResponse) {
        this.flickrResponse = flickrResponse;
    }
}
