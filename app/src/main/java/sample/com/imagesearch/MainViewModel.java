package sample.com.imagesearch;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.OnLifecycleEvent;
import android.databinding.BindingAdapter;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import sample.com.imagesearch.module.GlideProvider;
import sample.com.imagesearch.service.Photo;
import sample.com.imagesearch.service.PhotoProvider;
import sample.com.imagesearch.service.Photos;

public class MainViewModel {

    private List<PhotoItemViewModel> photoItemViewModelList;
    private PhotoAdapter photoAdapter;
    private GlideProvider glideProvider;

    @Inject
    public MainViewModel(PhotoProvider photoProvider, GlideProvider glideProvider) {
        photoItemViewModelList = new ArrayList<>();
        photoAdapter = new PhotoAdapter(this);
        this.glideProvider = glideProvider;
        photoProvider.getPhotos("cat").subscribe(photos -> processImage(photos));
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void setTextField() {

    }

    public PhotoAdapter getAdapter() {
        return photoAdapter;
    }

    public GlideProvider getGlideProvider() {
        return glideProvider;
    }

    private void processImage(Photos photos) {

        //http://farm{farm}.static.flickr.com/{server}/{id}_{secret}.jpg
        if (photos.getPhotos() != null && photos.getPhotos().size() > 0) {
            Photo photo = photos.getPhotos().get(0);

            String url = "http://farm" + photo.getFarm() + ".static.flicker.com/" + photo.getServer() + "/" + photo.getId() + "_" + photo.getSecret() + ".jpg";
            photoItemViewModelList.add(new PhotoItemViewModel(url));
            photoAdapter.setItems(photoItemViewModelList);
        }
    }

    @BindingAdapter({"loadImageUrl", "provider"})
    public static void loadImageUrl(ImageView imageView, String imageUrl, GlideProvider glideProvider) {
        if (imageUrl != null && !imageUrl.isEmpty()) {
            glideProvider.load(imageUrl).into(imageView);
        }
    }
}
