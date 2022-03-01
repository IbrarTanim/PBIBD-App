package com.pbilbd.activities.signup;


import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.google.gson.Gson;
import com.pbilbd.constants.BaseConstants;
import com.pbilbd.dto.responses.reg422error.Message;
import com.pbilbd.dto.responses.reg422error.Reg422ErrorResponse;
import com.pbilbd.network.NetworkClient;
import com.pbilbd.network.NetworkInterface;

import org.json.JSONObject;

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

        Call<JSONObject> registerCall = networkInterface.registerUser(registerParams);

        registerCall.enqueue(new Callback<JSONObject>() {
            @Override
            public void onResponse(Call<JSONObject> call, Response<JSONObject> response) {

                Log.e("Code", String.valueOf(response.code()));
                if (response.code() == 200){
                    try {
                        JSONObject responseJSON = new JSONObject(String.valueOf(response.body()));
                        String responseMessage = responseJSON.getString("message");
                        if (responseMessage != null && !responseMessage.isEmpty()){
                            errorsLiveData.postValue(response.code());
                            responseMessageLiveData.postValue(responseMessage);
                        }else {
                            errorsLiveData.postValue(response.code());
                            responseMessageLiveData.postValue("Registration successful");
                        }
                    } catch (Exception e) {
                        errorsLiveData.postValue(BaseConstants.UNKNOWN_ERROR);
                    }
                }else if (response.code() == 422){
                    Gson gson = new Gson();
                    try {
                        Reg422ErrorResponse reg422Response = gson.fromJson(response.errorBody().string(), Reg422ErrorResponse.class);
                        errorResponseLiveData.postValue(reg422Response.getMessage());
                        errorsLiveData.postValue(response.code());
                    } catch (IOException ioException) {
                        //ioException.printStackTrace();
                        errorsLiveData.postValue(BaseConstants.UNKNOWN_ERROR);
                    }
                }else {
                    errorsLiveData.postValue(BaseConstants.UNKNOWN_ERROR);
                }

            }

            @Override
            public void onFailure(Call<JSONObject> call, Throwable t) {
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
