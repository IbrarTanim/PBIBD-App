
package com.pbilbd.dto.responses.reg422error;

import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class Message implements Parcelable
{

    @SerializedName("email")
    @Expose
    private List<String> email = null;
    @SerializedName("username")
    @Expose
    private List<String> username = null;
    @SerializedName("phone")
    @Expose
    private List<String> phone = null;
    @SerializedName("password")
    @Expose
    private List<String> password = null;
    @SerializedName("referred_by")
    @Expose
    private List<String> referredBy = null;
    public final static Creator<Message> CREATOR = new Creator<Message>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Message createFromParcel(android.os.Parcel in) {
            return new Message(in);
        }

        public Message[] newArray(int size) {
            return (new Message[size]);
        }

    }
    ;

    protected Message(android.os.Parcel in) {
        in.readList(this.email, (String.class.getClassLoader()));
        in.readList(this.username, (String.class.getClassLoader()));
        in.readList(this.phone, (String.class.getClassLoader()));
        in.readList(this.password, (String.class.getClassLoader()));
        in.readList(this.referredBy, (String.class.getClassLoader()));
    }

    public Message() {
    }

    public List<String> getEmail() {
        return email;
    }

    public void setEmail(List<String> email) {
        this.email = email;
    }

    public List<String> getUsername() {
        return username;
    }

    public void setUsername(List<String> username) {
        this.username = username;
    }

    public List<String> getPhone() {
        return phone;
    }

    public void setPhone(List<String> phone) {
        this.phone = phone;
    }

    public List<String> getPassword() {
        return password;
    }

    public void setPassword(List<String> password) {
        this.password = password;
    }

    public List<String> getReferredBy() {
        return referredBy;
    }

    public void setReferredBy(List<String> referredBy) {
        this.referredBy = referredBy;
    }

    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeList(email);
        dest.writeList(username);
        dest.writeList(phone);
        dest.writeList(password);
        dest.writeList(referredBy);
    }

    public int describeContents() {
        return  0;
    }

}
