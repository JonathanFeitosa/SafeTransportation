
package br.com.safetransportation.safetransportation.modeluber;

import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ClientUber implements Parcelable
{

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("client")
    @Expose
    private Object client;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("tokenState")
    @Expose
    private String tokenState;
    @SerializedName("tokenStateUpdatedAt")
    @Expose
    private String tokenStateUpdatedAt;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("beginTripTime")
    @Expose
    private Object beginTripTime;
    @SerializedName("eta")
    @Expose
    private Object eta;
    @SerializedName("isPoolJob")
    @Expose
    private Object isPoolJob;
    @SerializedName("waypointIds")
    @Expose
    private List<String> waypointIds = null;
    @SerializedName("waypointInfo")
    @Expose
    private WaypointInfo waypointInfo;
    public final static Parcelable.Creator<ClientUber> CREATOR = new Creator<ClientUber>() {


        @SuppressWarnings({
            "unchecked"
        })
        public ClientUber createFromParcel(Parcel in) {
            return new ClientUber(in);
        }

        public ClientUber[] newArray(int size) {
            return (new ClientUber[size]);
        }

    }
    ;

    protected ClientUber(Parcel in) {
        this.id = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.client = ((Object) in.readValue((Object.class.getClassLoader())));
        this.status = ((String) in.readValue((String.class.getClassLoader())));
        this.tokenState = ((String) in.readValue((String.class.getClassLoader())));
        this.tokenStateUpdatedAt = ((String) in.readValue((String.class.getClassLoader())));
        this.type = ((String) in.readValue((String.class.getClassLoader())));
        this.beginTripTime = ((Object) in.readValue((Object.class.getClassLoader())));
        this.eta = ((Object) in.readValue((Object.class.getClassLoader())));
        this.isPoolJob = ((Object) in.readValue((Object.class.getClassLoader())));
        in.readList(this.waypointIds, (java.lang.String.class.getClassLoader()));
        this.waypointInfo = ((WaypointInfo) in.readValue((WaypointInfo.class.getClassLoader())));
    }

    public ClientUber() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Object getClient() {
        return client;
    }

    public void setClient(Object client) {
        this.client = client;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTokenState() {
        return tokenState;
    }

    public void setTokenState(String tokenState) {
        this.tokenState = tokenState;
    }

    public String getTokenStateUpdatedAt() {
        return tokenStateUpdatedAt;
    }

    public void setTokenStateUpdatedAt(String tokenStateUpdatedAt) {
        this.tokenStateUpdatedAt = tokenStateUpdatedAt;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Object getBeginTripTime() {
        return beginTripTime;
    }

    public void setBeginTripTime(Object beginTripTime) {
        this.beginTripTime = beginTripTime;
    }

    public Object getEta() {
        return eta;
    }

    public void setEta(Object eta) {
        this.eta = eta;
    }

    public Object getIsPoolJob() {
        return isPoolJob;
    }

    public void setIsPoolJob(Object isPoolJob) {
        this.isPoolJob = isPoolJob;
    }

    public List<String> getWaypointIds() {
        return waypointIds;
    }

    public void setWaypointIds(List<String> waypointIds) {
        this.waypointIds = waypointIds;
    }

    public WaypointInfo getWaypointInfo() {
        return waypointInfo;
    }

    public void setWaypointInfo(WaypointInfo waypointInfo) {
        this.waypointInfo = waypointInfo;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(client);
        dest.writeValue(status);
        dest.writeValue(tokenState);
        dest.writeValue(tokenStateUpdatedAt);
        dest.writeValue(type);
        dest.writeValue(beginTripTime);
        dest.writeValue(eta);
        dest.writeValue(isPoolJob);
        dest.writeList(waypointIds);
        dest.writeValue(waypointInfo);
    }

    public int describeContents() {
        return  0;
    }

}
