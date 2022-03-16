
package com.pbilbd.dto.responses.getkyc;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;


public class Statuses implements Serializable
{

    @SerializedName("Active")
    @Expose
    private String active;
    @SerializedName("Banned")
    @Expose
    private String banned;
    @SerializedName("Unconfirmed")
    @Expose
    private String unconfirmed;

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getBanned() {
        return banned;
    }

    public void setBanned(String banned) {
        this.banned = banned;
    }

    public String getUnconfirmed() {
        return unconfirmed;
    }

    public void setUnconfirmed(String unconfirmed) {
        this.unconfirmed = unconfirmed;
    }

}
