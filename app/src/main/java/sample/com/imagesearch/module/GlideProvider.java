package sample.com.imagesearch.module;

import android.content.Context;

import com.bumptech.glide.DrawableTypeRequest;
import com.bumptech.glide.Glide;

public class GlideProvider {

    private final Context mContext;

    public GlideProvider(@ForApplication Context context) {
        mContext = context;
    }

    public DrawableTypeRequest load(String url) {
        return Glide.with(mContext).load(url);
    }
}
