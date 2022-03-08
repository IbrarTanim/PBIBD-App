package com.pbilbd.ui.shoppingpointrecharge.transaction;

import android.content.Context;

import androidx.annotation.NonNull;
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

    private Context context;
    private NetworkInterface networkInterface;
    private String accessToken;
    private SharedPreffManager manager;
    private int FIRST_PAGE = 1;
    private int LAST_PAGE = 0;

    public TransactionsDataSource(Context context) {
        this.context = context;
        networkInterface = NetworkClient.getNetworkService();
        manager = new SharedPreffManager(context);
        accessToken = "Bearer " + manager.getString(BaseConstants.ACCESS_TOKEN);
    }

    @Override
    public void loadInitial(@NonNull LoadInitialParams<Integer> params, @NonNull LoadInitialCallback<Integer, Datum> callback) {

        Call<ShoppingPointTransactionsResponse> responseCall = networkInterface.getShoppingPointTransactions(accessToken, FIRST_PAGE);

        responseCall.enqueue(new Callback<ShoppingPointTransactionsResponse>() {
            @Override
            public void onResponse(Call<ShoppingPointTransactionsResponse> call, Response<ShoppingPointTransactionsResponse> response) {
                if (response.code() == 200){
                    if (response.body().getData() != null){
                        if (response.body().getData().getRecords() != null){
                            if (response.body().getData().getRecords().getData() != null){
                                callback.onResult(response.body().getData().getRecords().getData(), null, FIRST_PAGE + 1);
                                LAST_PAGE = response.body().getData().getRecords().getLastPage();
                            }
                        }
                    }
                }else if (response.code() == 401){

                }else {

                }
            }

            @Override
            public void onFailure(Call<ShoppingPointTransactionsResponse> call, Throwable t) {

            }
        });

    }

    @Override
    public void loadBefore(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Integer, Datum> callback) {

        Call<ShoppingPointTransactionsResponse> responseCall = networkInterface.getShoppingPointTransactions(accessToken, params.key);

        responseCall.enqueue(new Callback<ShoppingPointTransactionsResponse>() {
            @Override
            public void onResponse(Call<ShoppingPointTransactionsResponse> call, Response<ShoppingPointTransactionsResponse> response) {
                if (response.code() == 200){
                    if (response.body().getData() != null){
                        if (response.body().getData().getRecords() != null){
                            if (response.body().getData().getRecords().getData() != null){
                                int adjacentKey = (params.key > 1) ? params.key - 1 : null;
                                callback.onResult(response.body().getData().getRecords().getData(),  adjacentKey);
                            }
                        }
                    }
                }else if (response.code() == 401){

                }else {

                }
            }

            @Override
            public void onFailure(Call<ShoppingPointTransactionsResponse> call, Throwable t) {

            }
        });

    }

    @Override
    public void loadAfter(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Integer, Datum> callback) {

        Call<ShoppingPointTransactionsResponse> responseCall = networkInterface.getShoppingPointTransactions(accessToken, params.key);

        responseCall.enqueue(new Callback<ShoppingPointTransactionsResponse>() {
            @Override
            public void onResponse(Call<ShoppingPointTransactionsResponse> call, Response<ShoppingPointTransactionsResponse> response) {
                if (response.code() == 200){
                    if (response.body().getData() != null){
                        if (response.body().getData().getRecords() != null){
                            if (response.body().getData().getRecords().getData() != null){
                                int key = (params.key < LAST_PAGE) ? params.key + 1 : params.key;
                                callback.onResult(response.body().getData().getRecords().getData(),  key);
                            }
                        }
                    }
                }else if (response.code() == 401){

                }else {

                }
            }

            @Override
            public void onFailure(Call<ShoppingPointTransactionsResponse> call, Throwable t) {

            }
        });

    }
}
