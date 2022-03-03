package com.pbilbd.ui.shoppingpointrecharge.transaction;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.pbilbd.R;

public class ShoppingPointTransactionFragment extends Fragment {

    private ShoppingPointTransactionViewModel mViewModel;

    public static ShoppingPointTransactionFragment newInstance() {
        return new ShoppingPointTransactionFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.shopping_point_transaction_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(ShoppingPointTransactionViewModel.class);
        // TODO: Use the ViewModel
    }

}