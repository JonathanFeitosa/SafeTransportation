
package br.com.safetransportation.safetransportation.modeluber;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Supply implements Parcelable
{

    @SerializedName("uuid")
    @Expose
    private String uuid;
    @SerializedName("firstName")
    @Expose
    private String firstName;
    @SerializedName("pictureUrl")
    @Expose
    private String pictureUrl;
    @SerializedName("rating")
    @Expose
    private Object rating;
    public final static Parcelable.Creator<Supply> CREATOR = new Creator<Supply>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Supply createFromParcel(Parcel in) {
            return new Supply(in);
        }

        public Supply[] newArray(int size) {
            return (new Supply[size]);
        }

    }
    ;

    protected Supply(Parcel in) {
        this.uuid = ((String) in.readValue((String.class.getClassLoader())));
        this.firstName = ((String) in.readValue((String.class.getClassLoader())));
        this.pictureUrl = ((String) in.readValue((String.class.getClassLoader())));
        this.rating = ((Object) in.readValue((Object.class.getClassLoader())));
    }

    public Supply() {
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public Object getRating() {
        return rating;
    }

    public void setRating(Object rating) {
        this.rating = rating;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(uuid);
        dest.writeValue(firstName);
        dest.writeValue(pictureUrl);
        dest.writeValue(rating);
    }

    public int describeContents() {
        return  0;
    }

}
