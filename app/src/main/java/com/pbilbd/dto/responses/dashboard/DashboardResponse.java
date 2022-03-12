
package com.pbilbd.dto.responses.dashboard;


import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class DashboardResponse implements Parcelable
{

    @SerializedName("data")
    @Expose
    private Data data;
    public final static Creator<DashboardResponse> CREATOR = new Creator<DashboardResponse>() {


        @SuppressWarnings({
            "unchecked"
        })
        public DashboardResponse createFromParcel(android.os.Parcel in) {
            return new DashboardResponse(in);
        }

        public DashboardResponse[] newArray(int size) {
            return (new DashboardResponse[size]);
        }

    }
    ;

    protected DashboardResponse(android.os.Parcel in) {
        this.data = ((Data) in.readValue((Data.class.getClassLoader())));
    }

    public DashboardResponse() {
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeValue(data);
    }

    public int describeContents() {
        return  0;
    }

}
