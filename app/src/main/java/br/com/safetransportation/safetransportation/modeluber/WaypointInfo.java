
package br.com.safetransportation.safetransportation.modeluber;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WaypointInfo implements Parcelable
{

    @SerializedName("legsCompleted")
    @Expose
    private String legsCompleted;
    @SerializedName("totalLegs")
    @Expose
    private String totalLegs;
    public final static Parcelable.Creator<WaypointInfo> CREATOR = new Creator<WaypointInfo>() {


        @SuppressWarnings({
            "unchecked"
        })
        public WaypointInfo createFromParcel(Parcel in) {
            return new WaypointInfo(in);
        }

        public WaypointInfo[] newArray(int size) {
            return (new WaypointInfo[size]);
        }

    }
    ;

    protected WaypointInfo(Parcel in) {
        this.legsCompleted = ((String) in.readValue((String.class.getClassLoader())));
        this.totalLegs = ((String) in.readValue((String.class.getClassLoader())));
    }

    public WaypointInfo() {
    }

    public String getLegsCompleted() {
        return legsCompleted;
    }

    public void setLegsCompleted(String legsCompleted) {
        this.legsCompleted = legsCompleted;
    }

    public String getTotalLegs() {
        return totalLegs;
    }

    public void setTotalLegs(String totalLegs) {
        this.totalLegs = totalLegs;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(legsCompleted);
        dest.writeValue(totalLegs);
    }

    public int describeContents() {
        return  0;
    }

}
