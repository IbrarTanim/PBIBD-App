
package com.pbilbd.dto.responses.shoppingpointtransactions;


import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Datum implements Parcelable
{

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("payment_method_id")
    @Expose
    private String paymentMethodId;
    @SerializedName("sent_from")
    @Expose
    private String sentFrom;
    @SerializedName("trxid")
    @Expose
    private String trxid;
    @SerializedName("attachment")
    @Expose
    private String attachment;
    @SerializedName("note")
    @Expose
    private Object note;
    @SerializedName("amount")
    @Expose
    private String amount;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("user_id")
    @Expose
    private String userId;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("payment_method")
    @Expose
    private PaymentMethod__1 paymentMethod;
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
        this.id = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.paymentMethodId = ((String) in.readValue((String.class.getClassLoader())));
        this.sentFrom = ((String) in.readValue((String.class.getClassLoader())));
        this.trxid = ((String) in.readValue((String.class.getClassLoader())));
        this.attachment = ((String) in.readValue((String.class.getClassLoader())));
        this.note = ((Object) in.readValue((Object.class.getClassLoader())));
        this.amount = ((String) in.readValue((String.class.getClassLoader())));
        this.status = ((String) in.readValue((String.class.getClassLoader())));
        this.userId = ((String) in.readValue((String.class.getClassLoader())));
        this.createdAt = ((String) in.readValue((String.class.getClassLoader())));
        this.updatedAt = ((String) in.readValue((String.class.getClassLoader())));
        this.paymentMethod = ((PaymentMethod__1) in.readValue((PaymentMethod__1.class.getClassLoader())));
    }

    public Datum() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPaymentMethodId() {
        return paymentMethodId;
    }

    public void setPaymentMethodId(String paymentMethodId) {
        this.paymentMethodId = paymentMethodId;
    }

    public String getSentFrom() {
        return sentFrom;
    }

    public void setSentFrom(String sentFrom) {
        this.sentFrom = sentFrom;
    }

    public String getTrxid() {
        return trxid;
    }

    public void setTrxid(String trxid) {
        this.trxid = trxid;
    }

    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }

    public Object getNote() {
        return note;
    }

    public void setNote(Object note) {
        this.note = note;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public PaymentMethod__1 getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod__1 paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(paymentMethodId);
        dest.writeValue(sentFrom);
        dest.writeValue(trxid);
        dest.writeValue(attachment);
        dest.writeValue(note);
        dest.writeValue(amount);
        dest.writeValue(status);
        dest.writeValue(userId);
        dest.writeValue(createdAt);
        dest.writeValue(updatedAt);
        dest.writeValue(paymentMethod);
    }

    public int describeContents() {
        return  0;
    }

}
