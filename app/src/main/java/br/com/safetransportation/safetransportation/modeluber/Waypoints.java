
package br.com.safetransportation.safetransportation.modeluber;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Waypoints implements Parcelable
{

    @SerializedName("0")
    @Expose
    private br.com.safetransportation.safetransportation.modeluber._0 _0;
    public final static Parcelable.Creator<Waypoints> CREATOR = new Creator<Waypoints>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Waypoints createFromParcel(Parcel in) {
            return new Waypoints(in);
        }

        public Waypoints[] newArray(int size) {
            return (new Waypoints[size]);
        }

    }
    ;

    protected Waypoints(Parcel in) {
        this._0 = ((br.com.safetransportation.safetransportation.modeluber._0) in.readValue((_0.class.getClassLoader())));
    }

    public Waypoints() {
    }

    public br.com.safetransportation.safetransportation.modeluber._0 get0() {
        return _0;
    }

    public void set0(br.com.safetransportation.safetransportation.modeluber._0 _0) {
        this._0 = _0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(_0);
    }

    public int describeContents() {
        return  0;
    }

}
