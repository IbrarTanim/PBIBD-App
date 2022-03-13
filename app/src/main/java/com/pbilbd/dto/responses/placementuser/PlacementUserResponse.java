
package com.pbilbd.dto.responses.placementuser;

import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class PlacementUserResponse implements Parcelable
{

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("data")
    @Expose
    private List<Datum> data = null;
    public final static Creator<PlacementUserResponse> CREATOR = new Creator<PlacementUserResponse>() {


        @SuppressWarnings({
            "unchecked"
        })
        public PlacementUserResponse createFromParcel(android.os.Parcel in) {
            return new PlacementUserResponse(in);
        }

        public PlacementUserResponse[] newArray(int size) {
            return (new PlacementUserResponse[size]);
        }

    }
    ;

    protected PlacementUserResponse(android.os.Parcel in) {
        this.status = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.data, (Datum.class.getClassLoader()));
    }

    public PlacementUserResponse() {
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Datum> getData() {
        return data;
    }

    public void setData(List<Datum> data) {
        this.data = data;
    }

    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeValue(status);
        dest.writeList(data);
    }

    public int describeContents() {
        return  0;
    }

}
