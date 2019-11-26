
package br.com.safetransportation.safetransportation.modeluber;

import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Routelines implements Parcelable
{

    @SerializedName("locations")
    @Expose
    private List<Location> locations = null;
    public final static Parcelable.Creator<Routelines> CREATOR = new Creator<Routelines>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Routelines createFromParcel(Parcel in) {
            return new Routelines(in);
        }

        public Routelines[] newArray(int size) {
            return (new Routelines[size]);
        }

    }
    ;

    protected Routelines(Parcel in) {
        in.readList(this.locations, (br.com.safetransportation.safetransportation.modeluber.Location.class.getClassLoader()));
    }

    public Routelines() {
    }

    public List<Location> getLocations() {
        return locations;
    }

    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(locations);
    }

    public int describeContents() {
        return  0;
    }

}
