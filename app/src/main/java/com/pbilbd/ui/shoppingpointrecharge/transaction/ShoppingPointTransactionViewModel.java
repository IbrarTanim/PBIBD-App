package com.pbilbd.ui.shoppingpointrecharge.transaction;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;

import com.pbilbd.dto.responses.shoppingpointtransactions.Datum;
import com.pbilbd.utils.ExecutorServices;

public class ShoppingPointTransactionViewModel extends ViewModel {

    private LiveData<PagedList<Datum>> transactionListLiveData;
    private MutableLiveData<TransactionsDataSource> dataSourceLiveData;


    public void getTransactions(Context context) {

        TransactionDataSourceFactory factory = new TransactionDataSourceFactory(context);

        dataSourceLiveData = factory.getSourceMutableLiveData();

        PagedList.Config pagedListConfig = (new PagedList.Config.Builder())
                .setEnablePlaceholders(true)
                .setPageSize(20)
                .build();

        transactionListLiveData = (new LivePagedListBuilder<Integer, Datum>(factory, pagedListConfig))
                .setFetchExecutor(ExecutorServices.getExecutor())
                .build();
    }


    public LiveData<PagedList<Datum>> getProductPagedList() {
        return transactionListLiveData;
    }

}