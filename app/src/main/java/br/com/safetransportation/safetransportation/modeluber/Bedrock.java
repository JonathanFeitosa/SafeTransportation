
package br.com.safetransportation.safetransportation.modeluber;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class Bedrock implements Parcelable
{

    public final static Parcelable.Creator<Bedrock> CREATOR = new Creator<Bedrock>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Bedrock createFromParcel(Parcel in) {
            return new Bedrock(in);
        }

        public Bedrock[] newArray(int size) {
            return (new Bedrock[size]);
        }

    }
    ;

    protected Bedrock(Parcel in) {
    }

    public Bedrock() {
    }

    public void writeToParcel(Parcel dest, int flags) {
    }

    public int describeContents() {
        return  0;
    }

}
