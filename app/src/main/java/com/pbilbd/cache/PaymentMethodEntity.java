package com.pbilbd.cache;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "payment_method_entity")
public class PaymentMethodEntity {

    @PrimaryKey
    @ColumnInfo(name = "method_id")
    int methodId;

    @ColumnInfo(name = "method_name")
    String methodName;

    @ColumnInfo(name = "method_logo")
    String methodLogo;

    @ColumnInfo(name = "method_account")
    String methodAccount;

    @ColumnInfo(name = "method_type")
    String methodType;

    public PaymentMethodEntity(int methodId, String methodName, String methodLogo, String methodAccount, String methodType) {
        this.methodId = methodId;
        this.methodName = methodName;
        this.methodLogo = methodLogo;
        this.methodAccount = methodAccount;
        this.methodType = methodType;
    }

    public int getMethodId() {
        return methodId;
    }

    public void setMethodId(int methodId) {
        this.methodId = methodId;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String getMethodLogo() {
        return methodLogo;
    }

    public void setMethodLogo(String methodLogo) {
        this.methodLogo = methodLogo;
    }

    public String getMethodAccount() {
        return methodAccount;
    }

    public void setMethodAccount(String methodAccount) {
        this.methodAccount = methodAccount;
    }

    public String getMethodType() {
        return methodType;
    }

    public void setMethodType(String methodType) {
        this.methodType = methodType;
    }


    @Override
    public String toString() {
        return "PaymentMethodEntity{" +
                "methodId=" + methodId +
                ", methodName='" + methodName + '\'' +
                ", methodLogo='" + methodLogo + '\'' +
                ", methodAccount='" + methodAccount + '\'' +
                ", methodType='" + methodType + '\'' +
                '}';
    }
}
