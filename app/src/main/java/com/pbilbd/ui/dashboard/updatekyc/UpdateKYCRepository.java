package com.pbilbd.ui.dashboard.updatekyc;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.pbilbd.constants.BaseConstants;
import com.pbilbd.dto.responses.agents.AgentsResponse;
import com.pbilbd.dto.responses.getkyc.GetKYCResponse;
import com.pbilbd.dto.responses.placementuser.PlacementUserResponse;
import com.pbilbd.dto.responses.positionbyplacement.PositionByPlacementResponse;
import com.pbilbd.dto.responses.thana.ThanaResponse;
import com.pbilbd.network.NetworkClient;
import com.pbilbd.network.NetworkInterface;
import com.pbilbd.utils.SharedPreffManager;

import es.dmoral.toasty.Toasty;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UpdateKYCRepository {

    private Context context;
    private NetworkInterface networkInterface;
    private SharedPreffManager preffManager;
    private String ACCESS_TOKEN;
    private MutableLiveData<Integer> errorKYCLiveData;
    private MutableLiveData<GetKYCResponse> kycResponseLiveData;

    public UpdateKYCRepository(Context context) {
        this.context = context;
        networkInterface = NetworkClient.getNetworkService();
        preffManager = new SharedPreffManager(context);
        ACCESS_TOKEN = "Bearer " + preffManager.getString(BaseConstants.ACCESS_TOKEN);
        errorKYCLiveData = new MutableLiveData<>();
        kycResponseLiveData = new MutableLiveData<>();
    }

    //search placement api implementation
    public MutableLiveData<PlacementUserResponse> searchPlacementUser(String placementUser){

        MutableLiveData<PlacementUserResponse> liveData = new MutableLiveData<>();

        Log.e("KYC Token", ACCESS_TOKEN);

        Call<PlacementUserResponse> pojoCall = networkInterface.searchPlacementUser(ACCESS_TOKEN, placementUser);

        pojoCall.enqueue(new Callback<PlacementUserResponse>() {
            @Override
            public void onResponse(@NonNull Call<PlacementUserResponse> call, @NonNull Response<PlacementUserResponse> response) {
                if (response.code() == 200){
                    liveData.postValue(response.body());
                }else if (response.code() == 401){
                    Toasty.warning(context, BaseConstants.ERROR_UNAUTHORIZED).show();
                }else {
                    Toasty.warning(context, "No data found.").show();
                }
            }

            @Override
            public void onFailure(@NonNull Call<PlacementUserResponse> call, @NonNull Throwable t) {
                Toasty.warning(context, BaseConstants.ERROR_FAILURE).show();
            }
        });

        return liveData;
    }

    //get position by placement api implementation
    public MutableLiveData<PositionByPlacementResponse> positionByPlacement(String placementUserId){

        MutableLiveData<PositionByPlacementResponse> liveData = new MutableLiveData<>();

        Log.e("KYC Token", ACCESS_TOKEN);

        Call<PositionByPlacementResponse> pojoCall = networkInterface.positionByPlacement(ACCESS_TOKEN, placementUserId);

        pojoCall.enqueue(new Callback<PositionByPlacementResponse>() {
            @Override
            public void onResponse(@NonNull Call<PositionByPlacementResponse> call, @NonNull Response<PositionByPlacementResponse> response) {
                if (response.code() == 200){
                    liveData.postValue(response.body());
                }else if (response.code() == 401){
                    Toasty.warning(context, BaseConstants.ERROR_UNAUTHORIZED).show();
                }else {
                    Toasty.warning(context, "No data found.").show();
                }
            }

            @Override
            public void onFailure(@NonNull Call<PositionByPlacementResponse> call, @NonNull Throwable t) {
                Toasty.warning(context, BaseConstants.ERROR_FAILURE).show();
            }
        });

        return liveData;
    }

    //get all kyc information api implementation
    public void getKYCInformation(){

        Call<GetKYCResponse> pojoCall = networkInterface.kycResponse(ACCESS_TOKEN);

        pojoCall.enqueue(new Callback<GetKYCResponse>() {
            @Override
            public void onResponse(@NonNull Call<GetKYCResponse> call, @NonNull Response<GetKYCResponse> response) {
                if (response.code() == 200){
                    errorKYCLiveData.postValue(200);
                    kycResponseLiveData.postValue(response.body());
                }else if (response.code() == 401){
                    errorKYCLiveData.postValue(401);
                }else {
                    errorKYCLiveData.postValue(BaseConstants.UNKNOWN_ERROR);
                }
            }

            @Override
            public void onFailure(@NonNull Call<GetKYCResponse> call, @NonNull Throwable t) {
                errorKYCLiveData.postValue(BaseConstants.FAILURE_ERROR);
            }
        });

    }

    //get Thana list api implementation
    public MutableLiveData<ThanaResponse> getThanaList(int districtId){

        MutableLiveData<ThanaResponse> responseLiveData = new MutableLiveData<>();

        Call<ThanaResponse> pojoCall = networkInterface.thanaList(ACCESS_TOKEN, districtId);

        pojoCall.enqueue(new Callback<ThanaResponse>() {
            @Override
            public void onResponse(@NonNull Call<ThanaResponse> call, @NonNull Response<ThanaResponse> response) {
                if (response.code() == 200){
                    responseLiveData.postValue(response.body());
                }else if (response.code() == 401){
                    Toasty.warning(context, BaseConstants.ERROR_UNAUTHORIZED).show();
                }else {
                    Toasty.warning(context, BaseConstants.ERROR_UNKNOWN).show();
                }
            }

            @Override
            public void onFailure(@NonNull Call<ThanaResponse> call, @NonNull Throwable t) {
                Toasty.warning(context, BaseConstants.ERROR_FAILURE).show();
            }
        });

        return  responseLiveData;
    }

    //get Agent list api implementation
    public MutableLiveData<AgentsResponse> getAgentList(int districtId, int thanaId){

        MutableLiveData<AgentsResponse> responseLiveData = new MutableLiveData<>();

        Call<AgentsResponse> pojoCall = networkInterface.agentList(ACCESS_TOKEN, districtId, thanaId);

        pojoCall.enqueue(new Callback<AgentsResponse>() {
            @Override
            public void onResponse(@NonNull Call<AgentsResponse> call, @NonNull Response<AgentsResponse> response) {
                if (response.code() == 200){
                    responseLiveData.postValue(response.body());
                }else if (response.code() == 401){
                    Toasty.warning(context, BaseConstants.ERROR_UNAUTHORIZED).show();
                }else {
                    Toasty.warning(context, BaseConstants.ERROR_UNKNOWN).show();
                }
            }

            @Override
            public void onFailure(@NonNull Call<AgentsResponse> call, @NonNull Throwable t) {
                Toasty.warning(context, BaseConstants.ERROR_FAILURE).show();
            }
        });

        return  responseLiveData;
    }

    public MutableLiveData<Integer> getErrorKYCLiveData() {
        return errorKYCLiveData;
    }

    public MutableLiveData<GetKYCResponse> getKycResponseLiveData() {
        return kycResponseLiveData;
    }
}
