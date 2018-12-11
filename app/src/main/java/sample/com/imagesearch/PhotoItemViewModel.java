package sample.com.imagesearch;

import android.databinding.BaseObservable;
import android.support.annotation.DrawableRes;

public class PhotoItemViewModel extends BaseObservable {

    @DrawableRes
    private int productImage;

    public PhotoItemViewModel(int productImage) {
        this.productImage = productImage;
    }

    public int getProductImage() {
        return productImage;
    }

    public void setProductImage(int productImage) {
        this.productImage = productImage;
    }
}
