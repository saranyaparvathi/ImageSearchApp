package sample.com.imagesearch.service;

import javax.inject.Inject;

import io.reactivex.Maybe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class PhotoProvider {

    RepoService repoService;

    @Inject
    public PhotoProvider(RepoService repoService) {
        this.repoService = repoService;
    }

    public Maybe<PhotosList> getPhotos(String searchText) {
        return repoService
                .getSearch("flickr.photos.search", "3e7cc266ae2b0e0d78e279ce8e361736", "json", "1", "1", searchText)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io());
    }
}
