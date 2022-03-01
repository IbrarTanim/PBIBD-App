
package com.pbilbd.dto.responses.reg422error;

import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Reg422ErrorResponse implements Parcelable
{

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("message")
    @Expose
    private Message message;
    public final static Creator<Reg422ErrorResponse> CREATOR = new Creator<Reg422ErrorResponse>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Reg422ErrorResponse createFromParcel(android.os.Parcel in) {
            return new Reg422ErrorResponse(in);
        }

        public Reg422ErrorResponse[] newArray(int size) {
            return (new Reg422ErrorResponse[size]);
        }

    }
    ;

    protected Reg422ErrorResponse(android.os.Parcel in) {
        this.status = ((String) in.readValue((String.class.getClassLoader())));
        this.message = ((Message) in.readValue((Message.class.getClassLoader())));
    }

    public Reg422ErrorResponse() {
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
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
