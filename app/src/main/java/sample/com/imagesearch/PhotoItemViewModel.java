package sample.com.imagesearch;

import android.databinding.BaseObservable;
import android.databinding.BindingAdapter;
import android.support.annotation.DrawableRes;
import android.widget.ImageView;

import sample.com.imagesearch.module.GlideProvider;

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

    @BindingAdapter({"loadImageUrl", "provider"})
    public static void setImageViewResource(ImageView imageView, String imageUrl, GlideProvider glideProvider) {
        if (imageUrl != null && !imageUrl.isEmpty()) {
            glideProvider.load(imageUrl).into(imageView);
        }
    }
}
