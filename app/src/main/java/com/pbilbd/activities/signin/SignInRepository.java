package com.pbilbd.activities.signin;

import android.content.Context;

import androidx.lifecycle.MutableLiveData;

import com.pbilbd.network.NetworkClient;
import com.pbilbd.network.NetworkInterface;

public class SignInRepository {

    private Context context;
    private NetworkInterface networkInterface;
    private MutableLiveData<Integer> errorLiveData;

    public SignInRepository(Context context) {
        this.context = context;
        networkInterface = NetworkClient.getNetworkService();
        errorLiveData = new MutableLiveData<>();
    }

    public MutableLiveData<Integer> getErrorLiveData() {
        return errorLiveData;
    }
}
