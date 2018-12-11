package sample.com.imagesearch;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.OnLifecycleEvent;
import android.databinding.ObservableField;

import javax.inject.Inject;

import sample.com.imagesearch.service.PhotoProvider;

public class MainViewModel {

    public ObservableField<String> textField = new ObservableField<>();

    @Inject
    public MainViewModel(PhotoProvider photoProvider) {
        textField.set("HI!!!!!!");
        photoProvider.getPhotos("kittens").subscribe(result -> System.out.println(result));
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void setTextField() {

    }

    public PhotoAdapter getAdapter() {
        return new PhotoAdapter(this);
    }
}
