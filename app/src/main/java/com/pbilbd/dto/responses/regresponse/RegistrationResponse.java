
package com.pbilbd.dto.responses.regresponse;

import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class RegistrationResponse implements Parcelable
{

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("token")
    @Expose
    private String token;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("user")
    @Expose
    private User user;
    public final static Creator<RegistrationResponse> CREATOR = new Creator<RegistrationResponse>() {


        @SuppressWarnings({
            "unchecked"
        })
        public RegistrationResponse createFromParcel(android.os.Parcel in) {
            return new RegistrationResponse(in);
        }

        public RegistrationResponse[] newArray(int size) {
            return (new RegistrationResponse[size]);
        }

    }
    ;

    protected RegistrationResponse(android.os.Parcel in) {
        this.status = ((String) in.readValue((String.class.getClassLoader())));
        this.token = ((String) in.readValue((String.class.getClassLoader())));
        this.message = ((String) in.readValue((String.class.getClassLoader())));
        this.user = ((User) in.readValue((User.class.getClassLoader())));
    }

    public RegistrationResponse() {
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeValue(status);
        dest.writeValue(token);
        dest.writeValue(message);
        dest.writeValue(user);
    }

    public int describeContents() {
        return  0;
    }

}
