
package br.com.safetransportation.safetransportation.modeluber;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class Error implements Parcelable
{

    public final static Parcelable.Creator<Error> CREATOR = new Creator<Error>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Error createFromParcel(Parcel in) {
            return new Error(in);
        }

        public Error[] newArray(int size) {
            return (new Error[size]);
        }

    }
    ;

    protected Error(Parcel in) {
    }

    public Error() {
    }

    public void writeToParcel(Parcel dest, int flags) {
    }

    public int describeContents() {
        return  0;
    }

}
