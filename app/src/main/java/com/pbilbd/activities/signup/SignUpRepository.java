package com.pbilbd.activities.signup;


import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.google.gson.Gson;
import com.pbilbd.constants.BaseConstants;
import com.pbilbd.dto.responses.reg422error.Message;
import com.pbilbd.dto.responses.reg422error.Reg422ErrorResponse;
import com.pbilbd.dto.responses.regresponse.RegistrationResponse;
import com.pbilbd.network.NetworkClient;
import com.pbilbd.network.NetworkInterface;

import java.io.IOException;
import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignUpRepository {

    private NetworkInterface networkInterface;
    private MutableLiveData<Integer> errorsLiveData;
    private MutableLiveData<Message> errorResponseLiveData;
    private MutableLiveData<String> responseMessageLiveData;

    public SignUpRepository(HashMap<String, String> registrationParams) {
        networkInterface = NetworkClient.getNetworkService();
        errorsLiveData = new MutableLiveData<>();
        errorResponseLiveData = new MutableLiveData<>();
        responseMessageLiveData = new MutableLiveData<>();

        //call for register user
        registerUser(registrationParams);
    }

    //Network Call
    private void registerUser(HashMap<String, String> registerParams){

        Call<RegistrationResponse> registerCall = networkInterface.registerUser(registerParams);

        registerCall.enqueue(new Callback<RegistrationResponse>() {
            @Override
            public void onResponse(@NonNull Call<RegistrationResponse> call, @NonNull Response<RegistrationResponse> response) {
                if (response.code() == 200){
                    if (response.body().getMessage() != null){
                        errorsLiveData.postValue(response.code());
                        responseMessageLiveData.postValue(response.body().getMessage());
                    }else {
                        errorsLiveData.postValue(response.code());
                        responseMessageLiveData.postValue("Registration successful.");
                    }
                }else if (response.code() == 422){
                    Gson gson = new Gson();
                    try {
                        Reg422ErrorResponse reg422Response = gson.fromJson(response.errorBody().string(), Reg422ErrorResponse.class);
                        errorResponseLiveData.postValue(reg422Response.getMessage());
                        errorsLiveData.postValue(response.code());
                    } catch (IOException ioException) {
                        errorsLiveData.postValue(BaseConstants.UNKNOWN_ERROR);
                    }
                }else {
                    errorsLiveData.postValue(BaseConstants.UNKNOWN_ERROR);
                }

            }
            @Override
            public void onFailure(@NonNull Call<RegistrationResponse> call, @NonNull Throwable t) {
                errorsLiveData.postValue(BaseConstants.FAILURE_ERROR);
            }
        });

    }

    public MutableLiveData<Integer> getErrorsLiveData() {
        return errorsLiveData;
    }

    public MutableLiveData<Message> getErrorResponseLiveData() {
        return errorResponseLiveData;
    }

    public MutableLiveData<String> getResponseMessageLiveData() {
        return responseMessageLiveData;
    }
}
