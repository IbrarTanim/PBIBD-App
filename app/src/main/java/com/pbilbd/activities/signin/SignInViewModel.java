package com.pbilbd.activities.signin;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SignInViewModel extends ViewModel {

    private SignInRepository repository;
    private LiveData<Integer> errorLiveData;

    public void initViewModel(Context context) {
        repository = new SignInRepository(context);
        errorLiveData = new MutableLiveData<>();
    }

    public LiveData<Integer> getErrorLiveData() {
        return repository.getErrorLiveData();
    }
}
