package com.pbilbd.activities.signin;

import android.content.Context;

import androidx.lifecycle.MutableLiveData;

import com.pbilbd.network.NetworkClient;
import com.pbilbd.network.NetworkInterface;

public class SignInRepository {

    private Context context;
    private NetworkClient networkClient;
    private NetworkInterface networkInterface;
    private MutableLiveData<Integer> errorLiveData;

    public SignInRepository(Context context) {
        this.context = context;
        networkClient = new NetworkClient(context);
        networkInterface = networkClient.getClient().create(NetworkInterface.class);
        errorLiveData = new MutableLiveData<>();
    }

    public MutableLiveData<Integer> getErrorLiveData() {
        return errorLiveData;
    }
}
