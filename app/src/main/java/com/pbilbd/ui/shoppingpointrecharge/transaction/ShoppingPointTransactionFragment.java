package com.pbilbd.ui.shoppingpointrecharge.transaction;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.pbilbd.adapters.ShoppingPointTransactionAdapter;
import com.pbilbd.databinding.ShoppingPointTransactionFragmentBinding;
import com.pbilbd.dto.responses.shoppingpointtransactions.Datum;

public class ShoppingPointTransactionFragment extends Fragment {

    private Context context;
    private ShoppingPointTransactionFragmentBinding binding;
    private ShoppingPointTransactionViewModel mViewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = ShoppingPointTransactionFragmentBinding.inflate(inflater, container, false);
        mViewModel =
                new ViewModelProvider(this).get(ShoppingPointTransactionViewModel.class);

        mViewModel.getTransactions(context);
        mViewModel.getProductPagedList().observe(getViewLifecycleOwner(), new Observer<PagedList<Datum>>() {
            @Override
            public void onChanged(PagedList<Datum> data) {

                if (data != null){
                    ShoppingPointTransactionAdapter adapter = new ShoppingPointTransactionAdapter();
                    adapter.submitList(data);
                    LinearLayoutManager manager = new LinearLayoutManager(context);
                    binding.rvAllTransaction.setLayoutManager(manager);
                    binding.rvAllTransaction.setAdapter(adapter);
                }
            }
        });
        return binding.getRoot();
    }


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public void onDestroyView() {
        binding = null;
        super.onDestroyView();
    }
}