package com.pbilbd.activities.signup;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SignUpViewModel extends ViewModel {

    private SignUpRepository repository;
    private LiveData<Integer> errorLiveData;

    public void initViewModel(Context context) {
        repository = new SignUpRepository(context);
        errorLiveData = new MutableLiveData<>();
    }

    public LiveData<Integer> getErrorLiveData() {
        return repository.getErrorLiveData();
    }
}
