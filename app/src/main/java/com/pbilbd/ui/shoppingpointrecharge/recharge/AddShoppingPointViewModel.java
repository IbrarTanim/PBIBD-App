package com.pbilbd.ui.shoppingpointrecharge.recharge;

import android.content.Context;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.pbilbd.cache.PaymentMethodEntity;

import java.util.List;

public class AddShoppingPointViewModel extends ViewModel {

    private MutableLiveData<List<PaymentMethodEntity>> allPaymentMethods;

    public void initViewModel(Context context){
        AddShoppingPointRepository repository = new AddShoppingPointRepository(context);
        allPaymentMethods = repository.getMethodsLiveData();
    }

    public MutableLiveData<List<PaymentMethodEntity>> getAllPaymentMethods() {
        return allPaymentMethods;
    }
}