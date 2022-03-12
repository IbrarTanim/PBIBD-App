package com.pbilbd.ui.shoppingpointrecharge.recharge;

import android.content.Context;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.pbilbd.cache.PaymentMethodEntity;

import java.util.List;

public class AddShoppingPointViewModel extends ViewModel {

    private MutableLiveData<List<PaymentMethodEntity>> allPaymentMethods;
    private AddShoppingPointRepository repository;

    public void initViewModel(Context context){
        repository = new AddShoppingPointRepository(context);
        allPaymentMethods = repository.getMethodsLiveData();
    }

    public void saveShoppingPoint(int paymentMethodId,
                                   String sentFrom,
                                   String trxId,
                                   String amount,
                                   String fileName){
        repository.saveShoppingPoint(paymentMethodId, sentFrom, trxId, amount, fileName);
    }

    public MutableLiveData<List<PaymentMethodEntity>> getAllPaymentMethods() {
        return allPaymentMethods;
    }

    public MutableLiveData<Integer> getErrorLiveData() {
        return repository.getErrorLiveData();
    }

    public MutableLiveData<String> getResponseLiveData() {
        return repository.getResponseLiveData();
    }
}