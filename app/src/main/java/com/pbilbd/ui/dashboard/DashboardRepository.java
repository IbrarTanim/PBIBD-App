package com.pbilbd.ui.dashboard;

import android.content.Context;

import androidx.lifecycle.MutableLiveData;

import com.pbilbd.constants.BaseConstants;
import com.pbilbd.dto.responses.dashboard.DashboardResponse;
import com.pbilbd.network.NetworkClient;
import com.pbilbd.network.NetworkInterface;
import com.pbilbd.utils.SharedPreffManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DashboardRepository {

    private Context context;
    private SharedPreffManager preffManager;
    private NetworkInterface networkInterface;
    private MutableLiveData<Integer> errorLiveData;
    private MutableLiveData<DashboardResponse> responseLiveData;

    public DashboardRepository(Context context) {
        this.context = context;
        preffManager = new SharedPreffManager(context);
        networkInterface = NetworkClient.getNetworkService();
        errorLiveData = new MutableLiveData<>();
        responseLiveData = new MutableLiveData<>();
    }

    public void getDashboardInfo(){

        String accessToken = "Bearer " + preffManager.getString(BaseConstants.ACCESS_TOKEN);

        Call<DashboardResponse> pojoCall = networkInterface.dashboardInfo(accessToken);

        pojoCall.enqueue(new Callback<DashboardResponse>() {
            @Override
            public void onResponse(Call<DashboardResponse> call, Response<DashboardResponse> response) {
                if (response.code() == 200){
                    errorLiveData.postValue(200);
                    responseLiveData.postValue(response.body());
                }else if (response.code() == 401){
                    errorLiveData.postValue(401);
                }else{
                    errorLiveData.postValue(BaseConstants.UNKNOWN_ERROR);
                }
            }

            @Override
            public void onFailure(Call<DashboardResponse> call, Throwable t) {
                errorLiveData.postValue(BaseConstants.FAILURE_ERROR);
            }
        });
    }

    public MutableLiveData<Integer> getErrorLiveData() {
        return errorLiveData;
    }

    public MutableLiveData<DashboardResponse> getResponseLiveData() {
        return responseLiveData;
    }
}
