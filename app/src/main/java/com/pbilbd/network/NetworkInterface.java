package com.pbilbd.network;

import com.pbilbd.dto.responses.loginresponse.LoginResponse;
import com.pbilbd.dto.responses.regresponse.RegistrationResponse;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface NetworkInterface {

    /**
     * Registration
     * Api
     * */
    @POST("register")
    Call<RegistrationResponse> registerUser(@QueryMap HashMap<String, String> registrationParams);

    /**
     * Login
     * Api
     * */
    @POST("login")
    Call<LoginResponse> loginUser(@Query("username") String userName, @Query("password") String password);
}
