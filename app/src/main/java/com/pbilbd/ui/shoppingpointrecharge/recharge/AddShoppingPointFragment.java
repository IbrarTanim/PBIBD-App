package com.pbilbd.ui.shoppingpointrecharge.recharge;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.pbilbd.R;

public class AddShoppingPointFragment extends Fragment {

    private AddShoppingPointViewModel mViewModel;

    public static AddShoppingPointFragment newInstance() {
        return new AddShoppingPointFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.add_shopping_point_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(AddShoppingPointViewModel.class);
        // TODO: Use the ViewModel
    }

}