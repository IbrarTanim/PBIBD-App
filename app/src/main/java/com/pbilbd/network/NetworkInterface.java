package com.pbilbd.network;

import org.json.JSONObject;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

public interface NetworkInterface {

    /**
     * Registration
     * Api
     * */
    @POST("register")
    Call<JSONObject> registerUser(@QueryMap HashMap<String, String> registrationParams);
}
