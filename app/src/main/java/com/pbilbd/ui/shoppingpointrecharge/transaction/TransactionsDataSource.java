package com.pbilbd.ui.shoppingpointrecharge.transaction;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.PageKeyedDataSource;

import com.pbilbd.constants.BaseConstants;
import com.pbilbd.dto.responses.shoppingpointtransactions.Datum;
import com.pbilbd.dto.responses.shoppingpointtransactions.ShoppingPointTransactionsResponse;
import com.pbilbd.network.NetworkClient;
import com.pbilbd.network.NetworkInterface;
import com.pbilbd.utils.SharedPreffManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TransactionsDataSource extends PageKeyedDataSource<Integer, Datum> {

    private String startDate, endDate;
    private NetworkInterface networkInterface;
    private String accessToken;
    private SharedPreffManager manager;
    private int FIRST_PAGE = 1;
    private int LAST_PAGE = 0;
    private MutableLiveData<ShoppingPointTransactionsResponse> allTransactionsResponseLive = new MutableLiveData<>();
    private MutableLiveData<Integer> errorLiveData =  new MutableLiveData<>();


    public TransactionsDataSource(Context context, String startDate, String endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
        networkInterface = NetworkClient.getNetworkService();
        manager = new SharedPreffManager(context);
        accessToken = "Bearer " + manager.getString(BaseConstants.ACCESS_TOKEN);
    }

    @Override
    public void loadInitial(@NonNull LoadInitialParams<Integer> params, @NonNull LoadInitialCallback<Integer, Datum> callback) {

        Call<ShoppingPointTransactionsResponse> responseCall = networkInterface.getShoppingPointTransactions(accessToken, startDate, endDate, FIRST_PAGE);

        responseCall.enqueue(new Callback<ShoppingPointTransactionsResponse>() {
            @Override
            public void onResponse(Call<ShoppingPointTransactionsResponse> call, Response<ShoppingPointTransactionsResponse> response) {
                if (response.code() == 200) {
                    errorLiveData.postValue(response.code());
                    if (response.body().getData() != null) {
                        allTransactionsResponseLive.postValue(response.body());
                        if (response.body().getData().getRecords() != null) {
                            if (response.body().getData().getRecords().getData() != null) {
                                callback.onResult(response.body().getData().getRecords().getData(), null, FIRST_PAGE + 1);
                                LAST_PAGE = response.body().getData().getRecords().getLastPage();
                            }
                        }
                    }
                } else if (response.code() == 401) {
                    errorLiveData.postValue(response.code());
                } else {
                    errorLiveData.postValue(BaseConstants.UNKNOWN_ERROR);
                }
            }

            @Override
            public void onFailure(Call<ShoppingPointTransactionsResponse> call, Throwable t) {
                errorLiveData.postValue(BaseConstants.FAILURE_ERROR);
            }
        });

    }

    @Override
    public void loadBefore(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Integer, Datum> callback) {

        Call<ShoppingPointTransactionsResponse> responseCall = networkInterface.getShoppingPointTransactions(accessToken,startDate, endDate, params.key);

        responseCall.enqueue(new Callback<ShoppingPointTransactionsResponse>() {
            @Override
            public void onResponse(Call<ShoppingPointTransactionsResponse> call, Response<ShoppingPointTransactionsResponse> response) {
                if (response.code() == 200) {
                    if (response.body().getData() != null) {
                        if (response.body().getData().getRecords() != null) {
                            if (response.body().getData().getRecords().getData() != null) {
                                int adjacentKey = (params.key > 1) ? params.key - 1 : params.key;
                                callback.onResult(response.body().getData().getRecords().getData(), adjacentKey);
                            }
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<ShoppingPointTransactionsResponse> call, Throwable t) {

            }
        });

    }

    @Override
    public void loadAfter(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Integer, Datum> callback) {

        Call<ShoppingPointTransactionsResponse> responseCall = networkInterface.getShoppingPointTransactions(accessToken, startDate, endDate, params.key);

        responseCall.enqueue(new Callback<ShoppingPointTransactionsResponse>() {
            @Override
            public void onResponse(Call<ShoppingPointTransactionsResponse> call, Response<ShoppingPointTransactionsResponse> response) {
                if (response.code() == 200) {
                    if (response.body().getData() != null) {
                        if (response.body().getData().getRecords() != null) {
                            if (response.body().getData().getRecords().getData() != null) {
                                int key = (params.key < LAST_PAGE) ? params.key + 1 : params.key;
                                callback.onResult(response.body().getData().getRecords().getData(), key);
                            }
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<ShoppingPointTransactionsResponse> call, Throwable t) {

            }
        });

    }


    public MutableLiveData<ShoppingPointTransactionsResponse> getAllTransactionsResponseLive() {
        return allTransactionsResponseLive;
    }

    public MutableLiveData<Integer> getErrorLiveData() {
        return errorLiveData;
    }
}
