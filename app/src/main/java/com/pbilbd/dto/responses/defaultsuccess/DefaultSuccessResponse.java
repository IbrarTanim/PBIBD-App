
package com.pbilbd.dto.responses.defaultsuccess;


import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class DefaultSuccessResponse implements Parcelable
{

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("data")
    @Expose
    private String data;
    public final static Creator<DefaultSuccessResponse> CREATOR = new Creator<DefaultSuccessResponse>() {


        @SuppressWarnings({
            "unchecked"
        })
        public DefaultSuccessResponse createFromParcel(android.os.Parcel in) {
            return new DefaultSuccessResponse(in);
        }

        public DefaultSuccessResponse[] newArray(int size) {
            return (new DefaultSuccessResponse[size]);
        }

    }
    ;

    protected DefaultSuccessResponse(android.os.Parcel in) {
        this.status = ((String) in.readValue((String.class.getClassLoader())));
        this.data = ((String) in.readValue((String.class.getClassLoader())));
    }

    public DefaultSuccessResponse() {
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeValue(status);
        dest.writeValue(data);
    }

    public int describeContents() {
        return  0;
    }

}
