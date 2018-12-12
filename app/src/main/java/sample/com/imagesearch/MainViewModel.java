package sample.com.imagesearch;

import android.arch.lifecycle.LifecycleObserver;
import android.databinding.ObservableField;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import sample.com.imagesearch.module.GlideProvider;
import sample.com.imagesearch.service.Photo;
import sample.com.imagesearch.service.PhotoProvider;
import sample.com.imagesearch.service.Photos;
import sample.com.imagesearch.service.PhotosList;

public class MainViewModel implements LifecycleObserver {

    public ObservableField<String> searchText = new ObservableField<>();

    private List<PhotoItemViewModel> photoItemViewModelList;
    private PhotoAdapter photoAdapter;
    private GlideProvider glideProvider;
    private PhotoProvider photoProvider;

    @Inject
    public MainViewModel(PhotoProvider photoProvider, GlideProvider glideProvider) {
        photoItemViewModelList = new ArrayList<>();
        photoAdapter = new PhotoAdapter(this);
        this.photoProvider = photoProvider;
        this.glideProvider = glideProvider;
    }

    public void searchImages() {
        photoProvider.getPhotos(searchText.get()).subscribe(photos -> processImage(photos), throwable -> {
        });
    }

    public void clearSearchText() {
        searchText.set("");
    }

    public PhotoAdapter getAdapter() {
        return photoAdapter;
    }

    public GlideProvider getGlideProvider() {
        return glideProvider;
    }

    private void processImage(PhotosList photosList) {
        photoItemViewModelList.clear();
        Photos photos = photosList.getPhoto();
        if (photos.getPhotos() != null && photos.getPhotos().size() > 0) {
            for (Photo photo : photos.getPhotos()) {
                String url = "http://farm" + photo.getFarm() + ".static.flickr.com/" + photo.getServer() + "/" + photo.getId() + "_" + photo.getSecret() + ".jpg";
                System.out.println("URL:  " + url);
                photoItemViewModelList.add(new PhotoItemViewModel(url));
            }
            photoAdapter.setItems(photoItemViewModelList);
        }
    }
}
