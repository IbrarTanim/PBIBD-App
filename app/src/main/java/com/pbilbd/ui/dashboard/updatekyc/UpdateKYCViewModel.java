package com.pbilbd.ui.dashboard.updatekyc;

import android.content.Context;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.pbilbd.dto.responses.agents.AgentsResponse;
import com.pbilbd.dto.responses.getkyc.GetKYCResponse;
import com.pbilbd.dto.responses.placementuser.PlacementUserResponse;
import com.pbilbd.dto.responses.positionbyplacement.PositionByPlacementResponse;
import com.pbilbd.dto.responses.thana.ThanaResponse;
import com.pbilbd.dto.responses.updateaccount.UpdateAccountResponse;

import java.util.HashMap;

public class UpdateKYCViewModel extends ViewModel {

    private UpdateKYCRepository repository;

    public void initViewModel(Context context) {
        repository = new UpdateKYCRepository(context);
    }

    public MutableLiveData<PlacementUserResponse> searchPlacementUser(String placementUser){
        return repository.searchPlacementUser(placementUser);
    }

    public MutableLiveData<PositionByPlacementResponse> positionByPlacement(String placementUserId){
        return repository.positionByPlacement(placementUserId);
    }

    public void getKYCInformation(){
        repository.getKYCInformation();
    }

    public MutableLiveData<Integer> getErrorKYCLiveData() {
        return repository.getErrorKYCLiveData();
    }

    public MutableLiveData<GetKYCResponse> getKycResponseLiveData() {
        return repository.getKycResponseLiveData();
    }

    public MutableLiveData<AgentsResponse> getAgentList(int districtId, int thanaId){
        return repository.getAgentList(districtId, thanaId);
    }

    public MutableLiveData<ThanaResponse> getThanaList(int districtId){
        return repository.getThanaList(districtId);
    }

    public MutableLiveData<UpdateAccountResponse> updateAccount(HashMap<String, String> params){
        return repository.updateAccount(params);
    }

    public MutableLiveData<Integer> getErrorUpdateAccount() {
        return repository.getErrorUpdateAccount();
    }
}