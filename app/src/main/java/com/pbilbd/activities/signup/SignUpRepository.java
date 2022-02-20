package com.pbilbd.activities.signup;

import android.content.Context;

import androidx.lifecycle.MutableLiveData;

import com.pbilbd.network.NetworkClient;
import com.pbilbd.network.NetworkInterface;

public class SignUpRepository {

    private Context context;
    private NetworkClient networkClient;
    private NetworkInterface networkInterface;
    private MutableLiveData<Integer> errorLiveData;

    public SignUpRepository(Context context) {
        this.context = context;
        networkClient = new NetworkClient(context);
        networkInterface = networkClient.getClient().create(NetworkInterface.class);
        errorLiveData = new MutableLiveData<>();
    }

    public MutableLiveData<Integer> getErrorLiveData() {
        return errorLiveData;
    }
}
