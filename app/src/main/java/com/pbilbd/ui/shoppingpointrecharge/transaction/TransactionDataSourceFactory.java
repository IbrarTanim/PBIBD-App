package com.pbilbd.ui.shoppingpointrecharge.transaction;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.DataSource;

public class TransactionDataSourceFactory extends DataSource.Factory {

    private MutableLiveData<TransactionsDataSource> sourceMutableLiveData;
    private Context context;

    public TransactionDataSourceFactory(Context context) {
        this.context = context;
        sourceMutableLiveData = new MutableLiveData<>();
    }

    @NonNull
    @Override
    public DataSource create() {

        TransactionsDataSource dataSource = new TransactionsDataSource(context);

        sourceMutableLiveData.postValue(dataSource);

        return dataSource;
    }

    public MutableLiveData<TransactionsDataSource> getSourceMutableLiveData() {
        return sourceMutableLiveData;
    }
}
