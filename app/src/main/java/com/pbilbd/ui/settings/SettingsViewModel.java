package com.pbilbd.ui.settings;

import android.content.Context;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SettingsViewModel extends ViewModel {

    private SettingsRepository repository;

    public void initViewModel(Context context){
        repository = new SettingsRepository(context);
    }

    public void logout(){
        repository.logout();
    }

    public MutableLiveData<Integer> getErrorLiveData() {
        return repository.getErrorLiveData();
    }

    public MutableLiveData<String> getResponseLiveData() {
        return repository.getResponseLiveData();
    }
}