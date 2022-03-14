package com.pbilbd.network;

import com.pbilbd.dto.responses.dashboard.DashboardResponse;
import com.pbilbd.dto.responses.defaultsuccess.DefaultSuccessResponse;
import com.pbilbd.dto.responses.loginresponse.LoginResponse;
import com.pbilbd.dto.responses.placementuser.PlacementUserResponse;
import com.pbilbd.dto.responses.positionbyplacement.PositionByPlacementResponse;
import com.pbilbd.dto.responses.regresponse.RegistrationResponse;
import com.pbilbd.dto.responses.shoppingpointtransactions.ShoppingPointTransactionsResponse;

import java.util.HashMap;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface NetworkInterface {

    /**
     * Registration
     * Api
     */
    @POST("register")
    Call<RegistrationResponse> registerUser(@QueryMap HashMap<String, String> registrationParams);

    /**
     * Login
     * Api
     */
    @POST("login")
    Call<LoginResponse> loginUser(@Query("username") String userName,
                                  @Query("password") String password);

    /**
     * Logout
     * */
    @POST("logout")
    Call<DefaultSuccessResponse> logout(@Header("Authorization") String accessToken);

    /**
     * Shopping
     * Point
     * Transactions
     * Api
     */
    @POST("wallet-recharge")
    Call<ShoppingPointTransactionsResponse> getShoppingPointTransactions(@Header("Authorization") String accessToken,
                                                                         @Query("start_date") String startDate,
                                                                         @Query("end_date") String endDate,
                                                                         @Query("page") int pageNumber);

    /**
     * Shopping
     * Point
     * Recharge
     */
    @Multipart
    @POST("wallet-recharge-store")
    Call<DefaultSuccessResponse> saveShoppingPoint(@Header("Authorization") String accessToken,
                                       @Query("payment_method_id") int paymentMethodId,
                                       @Query("sent_from") String sentFrom,
                                       @Query("trxid") String trxId,
                                       @Query("amount") String amount,
                                       @Part MultipartBody.Part attachment);
    @POST("wallet-recharge-store")
    Call<DefaultSuccessResponse> saveShoppingPoint(@Header("Authorization") String accessToken,
                                       @Query("payment_method_id") int paymentMethodId,
                                       @Query("sent_from") String sentFrom,
                                       @Query("trxid") String trxId,
                                       @Query("amount") String amount);

    /**
     * Dashboard
     * Data
     * */
    @POST("dashboard")
    Call<DashboardResponse> dashboardInfo(@Header("Authorization") String accessToken);

    /**
     * Placement
     * User
     * Search
     * */
    @POST("placement")
    Call<PlacementUserResponse> searchPlacementUser(@Header("Authorization") String accessToken, @Query("username") String placementUser);

    /**
     * Position
     * By
     * Placement
     * */
    @POST("position")
    Call<PositionByPlacementResponse> positionByPlacement(@Header("Authorization") String accessToken, @Query("username") String placementUser);
}
