package com.pbilbd.activities.signin;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.pbilbd.dto.responses.loginresponse.LoginResponse;

public class SignInViewModel extends ViewModel {

    private SignInRepository repository;

    public void initViewModel(String userId, String password) {
        repository = new SignInRepository(userId, password);
    }

    public MutableLiveData<Integer> getErrorLiveData() {
        return repository.getErrorLiveData();
    }

    public MutableLiveData<LoginResponse> getLoginResponseLiveData() {
        return repository.getLoginResponseLiveData();
    }

    public MutableLiveData<String> getError401LiveData() {
        return repository.getError401LiveData();
    }


}
