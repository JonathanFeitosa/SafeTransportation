
package br.com.safetransportation.safetransportation.modeluber;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Uber implements Parcelable
{

   // @SerializedName("error")
  //  @Expose
  //  private Error error;
    @SerializedName("supply")
    @Expose
    private Supply supply;
    @SerializedName("vehicle")
    @Expose
    private Vehicle vehicle;
    @SerializedName("jobs")
    @Expose
    private Jobs jobs;
    @SerializedName("waypoints")
    @Expose
    private Waypoints waypoints;
    @SerializedName("routelines")
    @Expose
    private Routelines routelines;
   // @SerializedName("bedrock")
   // @Expose
   // private Bedrock bedrock;
    public final static Parcelable.Creator<Uber> CREATOR = new Creator<Uber>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Uber createFromParcel(Parcel in) {
            return new Uber(in);
        }

        public Uber[] newArray(int size) {
            return (new Uber[size]);
        }

    }
    ;

    protected Uber(Parcel in) {
     //   this.error = ((Error) in.readValue((Error.class.getClassLoader())));
        this.supply = ((Supply) in.readValue((Supply.class.getClassLoader())));
        this.vehicle = ((Vehicle) in.readValue((Vehicle.class.getClassLoader())));
        this.jobs = ((Jobs) in.readValue((Jobs.class.getClassLoader())));
        this.waypoints = ((Waypoints) in.readValue((Waypoints.class.getClassLoader())));
        this.routelines = ((Routelines) in.readValue((Routelines.class.getClassLoader())));
      //  this.bedrock = ((Bedrock) in.readValue((Bedrock.class.getClassLoader())));
    }

    public Uber() {
    }

  /*  public Error getError() {
        return error;
    }

    public void setError(Error error) {
        this.error = error;
    } */

    public Supply getSupply() {
        return supply;
    }

    public void setSupply(Supply supply) {
        this.supply = supply;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Jobs getJobs() {
        return jobs;
    }

    public void setJobs(Jobs jobs) {
        this.jobs = jobs;
    }

    public Waypoints getWaypoints() {
        return waypoints;
    }

    public void setWaypoints(Waypoints waypoints) {
        this.waypoints = waypoints;
    }

    public Routelines getRoutelines() {
        return routelines;
    }

    public void setRoutelines(Routelines routelines) {
        this.routelines = routelines;
    }

   // public Bedrock getBedrock() {
    //    return bedrock;
   // }

    //public void setBedrock(Bedrock bedrock) {
      //  this.bedrock = bedrock;
   // }

    public void writeToParcel(Parcel dest, int flags) {
     //   dest.writeValue(error);
        dest.writeValue(supply);
        dest.writeValue(vehicle);
        dest.writeValue(jobs);
        dest.writeValue(waypoints);
        dest.writeValue(routelines);
      //  dest.writeValue(bedrock);
    }

    public int describeContents() {
        return  0;
    }

}
