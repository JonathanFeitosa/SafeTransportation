
package br.com.safetransportation.safetransportation.modeluber;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Location implements Parcelable
{

    @SerializedName("course")
    @Expose
    private Double course;
    @SerializedName("epoch")
    @Expose
    private Integer epoch;
    @SerializedName("latitude")
    @Expose
    private Double latitude;
    @SerializedName("longitude")
    @Expose
    private Double longitude;
    @SerializedName("speed")
    @Expose
    private Integer speed;
    public final static Parcelable.Creator<Location> CREATOR = new Creator<Location>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Location createFromParcel(Parcel in) {
            return new Location(in);
        }

        public Location[] newArray(int size) {
            return (new Location[size]);
        }

    }
    ;

    protected Location(Parcel in) {
        this.course = ((Double) in.readValue((Double.class.getClassLoader())));
        this.epoch = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.latitude = ((Double) in.readValue((Double.class.getClassLoader())));
        this.longitude = ((Double) in.readValue((Double.class.getClassLoader())));
        this.speed = ((Integer) in.readValue((Integer.class.getClassLoader())));
    }

    public Location() {
    }

    public Double getCourse() {
        return course;
    }

    public void setCourse(Double course) {
        this.course = course;
    }

    public Integer getEpoch() {
        return epoch;
    }

    public void setEpoch(Integer epoch) {
        this.epoch = epoch;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Integer getSpeed() {
        return speed;
    }

    public void setSpeed(Integer speed) {
        this.speed = speed;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(course);
        dest.writeValue(epoch);
        dest.writeValue(latitude);
        dest.writeValue(longitude);
        dest.writeValue(speed);
    }

    public int describeContents() {
        return  0;
    }

}
