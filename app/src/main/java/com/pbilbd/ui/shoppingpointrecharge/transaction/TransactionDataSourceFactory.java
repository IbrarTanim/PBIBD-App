package com.pbilbd.ui.shoppingpointrecharge.transaction;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.DataSource;

import com.pbilbd.dto.responses.shoppingpointtransactions.ShoppingPointTransactionsResponse;

public class TransactionDataSourceFactory extends DataSource.Factory {

    private MutableLiveData<TransactionsDataSource> sourceMutableLiveData;
    private Context context;
    private String startDate, endDate;
    private MutableLiveData<ShoppingPointTransactionsResponse> allTransactionsResponseLive;
    private MutableLiveData<Integer> errorLiveData;
    private TransactionsDataSource dataSource;

    public TransactionDataSourceFactory(Context context, String startDate, String endDate) {
        allTransactionsResponseLive = new MutableLiveData<>();
        errorLiveData = new MutableLiveData<>();
        this.context = context;
        this.startDate = startDate;
        this.endDate = endDate;
        sourceMutableLiveData = new MutableLiveData<>();
    }

    @NonNull
    @Override
    public DataSource create() {

        dataSource = new TransactionsDataSource(context, startDate, endDate);

        allTransactionsResponseLive = dataSource.getAllTransactionsResponseLive();

        return dataSource;
    }

    public MutableLiveData<TransactionsDataSource> getSourceMutableLiveData() {
        return sourceMutableLiveData;
    }

    public MutableLiveData<ShoppingPointTransactionsResponse> getAllTransactionsResponseLive() {
        return dataSource.getAllTransactionsResponseLive();
    }

    public MutableLiveData<Integer> getErrorLiveData() {
        return dataSource.getErrorLiveData();
    }
}
