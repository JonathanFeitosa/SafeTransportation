
package br.com.safetransportation.safetransportation.modeluber;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Vehicle implements Parcelable
{

    @SerializedName("uuid")
    @Expose
    private String uuid;
    @SerializedName("licensePlate")
    @Expose
    private String licensePlate;
    @SerializedName("make")
    @Expose
    private String make;
    @SerializedName("model")
    @Expose
    private String model;
    @SerializedName("carType")
    @Expose
    private Object carType;
    @SerializedName("imageUrl")
    @Expose
    private String imageUrl;
    @SerializedName("color")
    @Expose
    private Color color;
    @SerializedName("vehicleUrl")
    @Expose
    private String vehicleUrl;
    public final static Parcelable.Creator<Vehicle> CREATOR = new Creator<Vehicle>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Vehicle createFromParcel(Parcel in) {
            return new Vehicle(in);
        }

        public Vehicle[] newArray(int size) {
            return (new Vehicle[size]);
        }

    }
    ;

    protected Vehicle(Parcel in) {
        this.uuid = ((String) in.readValue((String.class.getClassLoader())));
        this.licensePlate = ((String) in.readValue((String.class.getClassLoader())));
        this.make = ((String) in.readValue((String.class.getClassLoader())));
        this.model = ((String) in.readValue((String.class.getClassLoader())));
        this.carType = ((Object) in.readValue((Object.class.getClassLoader())));
        this.imageUrl = ((String) in.readValue((String.class.getClassLoader())));
        this.color = ((Color) in.readValue((Color.class.getClassLoader())));
        this.vehicleUrl = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Vehicle() {
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Object getCarType() {
        return carType;
    }

    public void setCarType(Object carType) {
        this.carType = carType;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public String getVehicleUrl() {
        return vehicleUrl;
    }

    public void setVehicleUrl(String vehicleUrl) {
        this.vehicleUrl = vehicleUrl;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(uuid);
        dest.writeValue(licensePlate);
        dest.writeValue(make);
        dest.writeValue(model);
        dest.writeValue(carType);
        dest.writeValue(imageUrl);
        dest.writeValue(color);
        dest.writeValue(vehicleUrl);
    }

    public int describeContents() {
        return  0;
    }

}
