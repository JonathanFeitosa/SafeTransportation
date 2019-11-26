
package br.com.safetransportation.safetransportation.modeluber;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Jobs implements Parcelable
{

    @SerializedName("1")
    @Expose
    private ClientUber _1;
    public final static Parcelable.Creator<Jobs> CREATOR = new Creator<Jobs>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Jobs createFromParcel(Parcel in) {
            return new Jobs(in);
        }

        public Jobs[] newArray(int size) {
            return (new Jobs[size]);
        }

    }
    ;

    protected Jobs(Parcel in) {
        this._1 = ((ClientUber) in.readValue((ClientUber.class.getClassLoader())));
    }

    public Jobs() {
    }

    public ClientUber get1() {
        return _1;
    }

    public void set1(ClientUber _1) {
        this._1 = _1;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(_1);
    }

    public int describeContents() {
        return  0;
    }

}
