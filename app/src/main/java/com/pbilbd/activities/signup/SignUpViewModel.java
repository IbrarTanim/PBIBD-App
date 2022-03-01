package com.pbilbd.activities.signup;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.pbilbd.dto.responses.reg422error.Message;

import java.util.HashMap;

public class SignUpViewModel extends ViewModel {

    private SignUpRepository repository;

    public void initViewModel(HashMap<String, String> registerParams) {
        repository = new SignUpRepository(registerParams);
    }

    public LiveData<Integer> getErrorsLiveData() {
        return repository.getErrorsLiveData();
    }

    public LiveData<Message> getErrorResponseLiveData() {
        return repository.getErrorResponseLiveData();
    }

    public LiveData<String> getResponseMessageLiveData() {
        return repository.getResponseMessageLiveData();
    }
}
