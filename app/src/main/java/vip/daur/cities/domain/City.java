package vip.daur.cities.domain;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.DrawableRes;
import androidx.annotation.StringRes;

public class City implements Parcelable {

    @StringRes
    private int title;

    @DrawableRes
    private int image;

    protected City(Parcel in) {
        title = in.readInt();
        image = in.readInt();
    }

    public static final Creator<City> CREATOR = new Creator<City>() {
        @Override
        public City createFromParcel(Parcel in) {
            return new City(in);
        }

        @Override
        public City[] newArray(int size) {
            return new City[size];
        }
    };

    public int getTitle() {
        return title;
    }

    public int getImage() {
        return image;
    }

    public City(int title, int image) {
        this.title = title;
        this.image = image;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(title);
        dest.writeInt(image);
    }
}
