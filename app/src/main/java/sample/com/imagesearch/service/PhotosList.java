package sample.com.imagesearch.service;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class PhotosList implements Parcelable {

    @SerializedName("photos")
    Photos photo;

    public Photos getPhoto() {
        return photo;
    }

    protected PhotosList(Parcel in) {
        photo = in.readParcelable(Photos.class.getClassLoader());
    }

    public static final Creator<PhotosList> CREATOR = new Creator<PhotosList>() {
        @Override
        public PhotosList createFromParcel(Parcel in) {
            return new PhotosList(in);
        }

        @Override
        public PhotosList[] newArray(int size) {
            return new PhotosList[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(photo, flags);
    }
}
