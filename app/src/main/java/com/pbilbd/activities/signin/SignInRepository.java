package com.pbilbd.activities.signin;


import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.google.gson.Gson;
import com.pbilbd.constants.BaseConstants;
import com.pbilbd.dto.responses.error401.Error401Response;
import com.pbilbd.dto.responses.loginresponse.LoginResponse;
import com.pbilbd.network.NetworkClient;
import com.pbilbd.network.NetworkInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignInRepository {

    private NetworkInterface networkInterface;
    private MutableLiveData<Integer> errorLiveData;
    private MutableLiveData<LoginResponse> loginResponseLiveData;
    private MutableLiveData<String> error401LiveData;

    public SignInRepository(String userId, String password) {
        networkInterface = NetworkClient.getNetworkService();
        errorLiveData = new MutableLiveData<>();
        loginResponseLiveData = new MutableLiveData<>();
        error401LiveData = new MutableLiveData<>();

        //login user
        loginUser(userId, password);
    }

    //api call
    private void loginUser(String userId, String password) {

        Call<LoginResponse> loginCall = networkInterface.loginUser(userId, password);

        loginCall.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(@NonNull Call<LoginResponse> call, @NonNull Response<LoginResponse> response) {

                if (response.code() == 200){
                    LoginResponse loginResponse = response.body();
                    loginResponseLiveData.postValue(loginResponse);
                    errorLiveData.postValue(response.code());
                }else if (response.code() == 401){
                    Gson gson = new Gson();
                    try {
                        Error401Response error401Response = gson.fromJson(response.errorBody().string(), Error401Response.class);
                        if (error401Response.getMessage() != null){
                            error401LiveData.postValue(error401Response.getMessage());
                            errorLiveData.postValue(response.code());
                        }else {
                            error401LiveData.postValue("Invalid credentials.");
                            errorLiveData.postValue(response.code());
                        }
                    } catch (Exception exception) {
                        error401LiveData.postValue("Invalid credentials.");
                        errorLiveData.postValue(response.code());
                    }
                }else {
                    errorLiveData.postValue(BaseConstants.UNKNOWN_ERROR);
                }

            }

            @Override
            public void onFailure(@NonNull Call<LoginResponse> call, @NonNull Throwable t) {
                errorLiveData.postValue(BaseConstants.FAILURE_ERROR);
            }
        });

    }

    public MutableLiveData<Integer> getErrorLiveData() {
        return errorLiveData;
    }

    public MutableLiveData<LoginResponse> getLoginResponseLiveData() {
        return loginResponseLiveData;
    }

    public MutableLiveData<String> getError401LiveData() {
        return error401LiveData;
    }
}
