package com.pbilbd.ui.dashboard.updatekyc;

import android.content.Context;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.pbilbd.dto.responses.placementuser.PlacementUserResponse;
import com.pbilbd.dto.responses.positionbyplacement.PositionByPlacementResponse;

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
}