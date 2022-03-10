package com.pbilbd.ui.shoppingpointrecharge.recharge;

import android.content.Context;

import androidx.lifecycle.MutableLiveData;

import com.pbilbd.cache.PBIRoomDatabase;
import com.pbilbd.cache.PaymentMethodEntity;

import java.util.List;

public class AddShoppingPointRepository {

    private Context context;
    private MutableLiveData<List<PaymentMethodEntity>> methodsLiveData;

    public AddShoppingPointRepository(Context context) {
        this.context = context;
        methodsLiveData = new MutableLiveData<>();
        getPaymentMethods(context);
    }

    private void getPaymentMethods(Context context) {
        PBIRoomDatabase database = PBIRoomDatabase.getInstance(context);
        List<PaymentMethodEntity> allMethods = database.paymentMethodDao().getAllPaymentMethod();
        methodsLiveData.postValue(allMethods);
    }

    public MutableLiveData<List<PaymentMethodEntity>> getMethodsLiveData() {
        return methodsLiveData;
    }
}
