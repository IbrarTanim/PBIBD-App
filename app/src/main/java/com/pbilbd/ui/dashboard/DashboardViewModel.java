package com.pbilbd.ui.dashboard;

import android.content.Context;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.pbilbd.dto.responses.dashboard.DashboardResponse;

public class DashboardViewModel extends ViewModel {

    DashboardRepository repository;

    public void initViewModel(Context context){
        repository = new DashboardRepository(context);
    }

    public void getDashboardInfo(){
        repository.getDashboardInfo();
    }

    public MutableLiveData<Integer> getErrorLiveData() {
        return repository.getErrorLiveData();
    }

    public MutableLiveData<DashboardResponse> getResponseLiveData() {
        return repository.getResponseLiveData();
    }
}