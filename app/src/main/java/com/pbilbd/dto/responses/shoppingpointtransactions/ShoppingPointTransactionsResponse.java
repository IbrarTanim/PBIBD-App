
package com.pbilbd.dto.responses.shoppingpointtransactions;


import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class ShoppingPointTransactionsResponse implements Parcelable
{

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("data")
    @Expose
    private Data data;
    public final static Creator<ShoppingPointTransactionsResponse> CREATOR = new Creator<ShoppingPointTransactionsResponse>() {


        @SuppressWarnings({
            "unchecked"
        })
        public ShoppingPointTransactionsResponse createFromParcel(android.os.Parcel in) {
            return new ShoppingPointTransactionsResponse(in);
        }

        public ShoppingPointTransactionsResponse[] newArray(int size) {
            return (new ShoppingPointTransactionsResponse[size]);
        }

    }
    ;

    protected ShoppingPointTransactionsResponse(android.os.Parcel in) {
        this.status = ((String) in.readValue((String.class.getClassLoader())));
        this.data = ((Data) in.readValue((Data.class.getClassLoader())));
    }

    public ShoppingPointTransactionsResponse() {
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
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
