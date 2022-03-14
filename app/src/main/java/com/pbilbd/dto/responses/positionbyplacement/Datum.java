
package com.pbilbd.dto.responses.positionbyplacement;


import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Datum implements Parcelable
{

    @SerializedName("position")
    @Expose
    private String position;
    @SerializedName("team")
    @Expose
    private String team;
    public final static Creator<Datum> CREATOR = new Creator<Datum>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Datum createFromParcel(android.os.Parcel in) {
            return new Datum(in);
        }

        public Datum[] newArray(int size) {
            return (new Datum[size]);
        }

    }
    ;

    protected Datum(android.os.Parcel in) {
        this.position = ((String) in.readValue((String.class.getClassLoader())));
        this.team = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Datum() {
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeValue(position);
        dest.writeValue(team);
    }

    public int describeContents() {
        return  0;
    }

    @Override
    public String toString() {
        return team;
    }
}
