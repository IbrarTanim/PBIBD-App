package com.pbilbd.network;

import com.pbilbd.dto.responses.loginresponse.LoginResponse;
import com.pbilbd.dto.responses.regresponse.RegistrationResponse;
import com.pbilbd.dto.responses.shoppingpointtransactions.ShoppingPointTransactionsResponse;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.Header;
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

    /**
     * Shopping
     * Point
     * Transactions
     * Api
     * */
    @POST("wallet-recharge")
    Call<ShoppingPointTransactionsResponse> getShoppingPointTransactions(@Header("Authorization") String accessToken, @Query("start_date") String startDate, @Query("end_date") String endDate, @Query("page") int pageNumber);
}
