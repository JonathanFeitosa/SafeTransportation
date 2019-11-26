
package br.com.safetransportation.safetransportation.modeluber;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class _0 implements Parcelable
{

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("jobId")
    @Expose
    private Integer jobId;
    @SerializedName("dynamicRadiusMeters")
    @Expose
    private Object dynamicRadiusMeters;
    @SerializedName("location")
    @Expose
    private Location location;
    @SerializedName("eta")
    @Expose
    private Object eta;
    public final static Parcelable.Creator<_0> CREATOR = new Creator<_0>() {


        @SuppressWarnings({
            "unchecked"
        })
        public _0 createFromParcel(Parcel in) {
            return new _0(in);
        }

        public _0 [] newArray(int size) {
            return (new _0[size]);
        }

    }
    ;

    protected _0(Parcel in) {
        this.id = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.type = ((String) in.readValue((String.class.getClassLoader())));
        this.jobId = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.dynamicRadiusMeters = ((Object) in.readValue((Object.class.getClassLoader())));
        this.location = ((Location) in.readValue((Location.class.getClassLoader())));
        this.eta = ((Object) in.readValue((Object.class.getClassLoader())));
    }

    public _0() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getJobId() {
        return jobId;
    }

    public void setJobId(Integer jobId) {
        this.jobId = jobId;
    }

    public Object getDynamicRadiusMeters() {
        return dynamicRadiusMeters;
    }

    public void setDynamicRadiusMeters(Object dynamicRadiusMeters) {
        this.dynamicRadiusMeters = dynamicRadiusMeters;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Object getEta() {
        return eta;
    }

    public void setEta(Object eta) {
        this.eta = eta;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(type);
        dest.writeValue(jobId);
        dest.writeValue(dynamicRadiusMeters);
        dest.writeValue(location);
        dest.writeValue(eta);
    }

    public int describeContents() {
        return  0;
    }

}
