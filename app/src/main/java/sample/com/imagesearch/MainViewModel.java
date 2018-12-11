package sample.com.imagesearch;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.OnLifecycleEvent;
import android.databinding.ObservableField;

import javax.inject.Inject;

public class MainViewModel {

    public ObservableField<String> textField = new ObservableField<>();

    @Inject
    public MainViewModel() {
        textField.set("HI!!!!!!");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void setTextField() {

    }
}
