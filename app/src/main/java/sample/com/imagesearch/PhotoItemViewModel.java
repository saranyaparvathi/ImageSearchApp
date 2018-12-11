package sample.com.imagesearch;

import android.databinding.BaseObservable;
import android.support.annotation.DrawableRes;

public class PhotoItemViewModel extends BaseObservable {

    @DrawableRes
    private int productImage;

    private String imageUrl;

    public PhotoItemViewModel(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getProductImage() {
        return productImage;
    }

    public void setProductImage(int productImage) {
        this.productImage = productImage;
    }
}
