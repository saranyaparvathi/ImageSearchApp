package sample.com.imagesearch.service;

import com.google.gson.annotations.Expose;

public class PhotoResponse {
    @Expose
    private Photos photos;
    @Expose
    private String stat;

    public Photos getPhotosObject() {
        return photos;
    }

    public void setPhotosObject(Photos photos) {
        this.photos = photos;
    }

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }

}
