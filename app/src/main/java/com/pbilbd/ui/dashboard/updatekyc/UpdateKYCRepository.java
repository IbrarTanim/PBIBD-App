package com.pbilbd.ui.dashboard.updatekyc;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.pbilbd.constants.BaseConstants;
import com.pbilbd.dto.responses.placementuser.PlacementUserResponse;
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
    private MutableLiveData<Integer> placementErrorLiveData;

    public UpdateKYCRepository(Context context) {
        this.context = context;
        networkInterface = NetworkClient.getNetworkService();
        preffManager = new SharedPreffManager(context);
        ACCESS_TOKEN = "Bearer " + preffManager.getString(BaseConstants.ACCESS_TOKEN);
        placementErrorLiveData = new MutableLiveData<>();
    }

    public MutableLiveData<PlacementUserResponse> searchPlacementUser(String placementUser){

        MutableLiveData<PlacementUserResponse> liveData = new MutableLiveData<>();

        Log.e("KYC Token", ACCESS_TOKEN);

        Call<PlacementUserResponse> pojoCall = networkInterface.searchPlacementUser(ACCESS_TOKEN, placementUser);

        pojoCall.enqueue(new Callback<PlacementUserResponse>() {
            @Override
            public void onResponse(Call<PlacementUserResponse> call, Response<PlacementUserResponse> response) {
                if (response.code() == 200){
                    liveData.postValue(response.body());
                }else if (response.code() == 401){
                    Toasty.warning(context, BaseConstants.ERROR_UNAUTHORIZED).show();
                }else {
                    Toasty.warning(context, "No data found.").show();
                }
            }

            @Override
            public void onFailure(Call<PlacementUserResponse> call, Throwable t) {
                Toasty.warning(context, BaseConstants.ERROR_FAILURE).show();
            }
        });

        return liveData;
    }
}
