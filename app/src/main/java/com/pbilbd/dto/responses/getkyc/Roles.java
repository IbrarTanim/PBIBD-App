
package com.pbilbd.dto.responses.getkyc;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;


public class Roles implements Serializable
{

    @SerializedName("2")
    @Expose
    private String _2;

    public String get2() {
        return _2;
    }

    public void set2(String _2) {
        this._2 = _2;
    }

}
