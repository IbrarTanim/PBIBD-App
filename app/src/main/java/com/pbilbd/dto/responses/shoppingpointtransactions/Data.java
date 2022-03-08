
package com.pbilbd.dto.responses.shoppingpointtransactions;

import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class Data implements Parcelable
{

    @SerializedName("paymentMethods")
    @Expose
    private List<PaymentMethod> paymentMethods = null;
    @SerializedName("records")
    @Expose
    private Records records;
    @SerializedName("total")
    @Expose
    private String total;
    @SerializedName("start_date")
    @Expose
    private Object startDate;
    @SerializedName("end_date")
    @Expose
    private Object endDate;
    @SerializedName("shopping_wallet")
    @Expose
    private String shoppingWallet;
    public final static Creator<Data> CREATOR = new Creator<Data>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Data createFromParcel(android.os.Parcel in) {
            return new Data(in);
        }

        public Data[] newArray(int size) {
            return (new Data[size]);
        }

    }
    ;

    protected Data(android.os.Parcel in) {
        in.readList(this.paymentMethods, (PaymentMethod.class.getClassLoader()));
        this.records = ((Records) in.readValue((Records.class.getClassLoader())));
        this.total = ((String) in.readValue((String.class.getClassLoader())));
        this.startDate = ((Object) in.readValue((Object.class.getClassLoader())));
        this.endDate = ((Object) in.readValue((Object.class.getClassLoader())));
        this.shoppingWallet = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Data() {
    }

    public List<PaymentMethod> getPaymentMethods() {
        return paymentMethods;
    }

    public void setPaymentMethods(List<PaymentMethod> paymentMethods) {
        this.paymentMethods = paymentMethods;
    }

    public Records getRecords() {
        return records;
    }

    public void setRecords(Records records) {
        this.records = records;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public Object getStartDate() {
        return startDate;
    }

    public void setStartDate(Object startDate) {
        this.startDate = startDate;
    }

    public Object getEndDate() {
        return endDate;
    }

    public void setEndDate(Object endDate) {
        this.endDate = endDate;
    }

    public String getShoppingWallet() {
        return shoppingWallet;
    }

    public void setShoppingWallet(String shoppingWallet) {
        this.shoppingWallet = shoppingWallet;
    }

    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeList(paymentMethods);
        dest.writeValue(records);
        dest.writeValue(total);
        dest.writeValue(startDate);
        dest.writeValue(endDate);
        dest.writeValue(shoppingWallet);
    }

    public int describeContents() {
        return  0;
    }

}
