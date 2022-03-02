
package com.pbilbd.dto.responses.error401;


import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Error401Response implements Parcelable
{

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("message")
    @Expose
    private String message;
    public final static Creator<Error401Response> CREATOR = new Creator<Error401Response>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Error401Response createFromParcel(android.os.Parcel in) {
            return new Error401Response(in);
        }

        public Error401Response[] newArray(int size) {
            return (new Error401Response[size]);
        }

    }
    ;

    protected Error401Response(android.os.Parcel in) {
        this.status = ((String) in.readValue((String.class.getClassLoader())));
        this.message = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Error401Response() {
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeValue(status);
        dest.writeValue(message);
    }

    public int describeContents() {
        return  0;
    }

}
