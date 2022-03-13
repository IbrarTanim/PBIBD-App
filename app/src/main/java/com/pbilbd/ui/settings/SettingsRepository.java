package com.pbilbd.ui.settings;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.pbilbd.constants.BaseConstants;
import com.pbilbd.dto.responses.defaultsuccess.DefaultSuccessResponse;
import com.pbilbd.network.NetworkClient;
import com.pbilbd.network.NetworkInterface;
import com.pbilbd.utils.SharedPreffManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SettingsRepository {

    private Context context;
    private NetworkInterface networkInterface;
    private SharedPreffManager preffManager;
    private MutableLiveData<Integer> errorLiveData;
    private MutableLiveData<String> responseLiveData;

    public SettingsRepository(Context context) {
        this.context = context;
        networkInterface = NetworkClient.getNetworkService();
        preffManager = new SharedPreffManager(context);
        errorLiveData = new MutableLiveData<>();
        responseLiveData = new MutableLiveData<>();
    }

    public void logout(){

        String accessToken = "Bearer " + preffManager.getString(BaseConstants.ACCESS_TOKEN);
        Log.e("Logout", accessToken);

        Call<DefaultSuccessResponse> pojoCall = networkInterface.logout(accessToken);

        pojoCall.enqueue(new Callback<DefaultSuccessResponse>() {
            @Override
            public void onResponse(Call<DefaultSuccessResponse> call, Response<DefaultSuccessResponse> response) {
                Log.e("Logout Code", String.valueOf(response.code()));
                if (response.code() == 200){
                    preffManager.clearAll();
                    errorLiveData.postValue(200);
                    if (response.body().getData() != null){
                        responseLiveData.postValue(response.body().getData());
                    }
                }else if (response.code() == 401){
                    preffManager.clearAll();
                    errorLiveData.postValue(401);
                }else {
                    errorLiveData.postValue(BaseConstants.UNKNOWN_ERROR);
                }
            }

            @Override
            public void onFailure(Call<DefaultSuccessResponse> call, Throwable t) {
                errorLiveData.postValue(BaseConstants.FAILURE_ERROR);
            }
        });
    }

    public MutableLiveData<Integer> getErrorLiveData() {
        return errorLiveData;
    }

    public MutableLiveData<String> getResponseLiveData() {
        return responseLiveData;
    }
}
