package com.pbilbd.ui.selfregistration;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SelfRegistrationViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public SelfRegistrationViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is gallery fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}