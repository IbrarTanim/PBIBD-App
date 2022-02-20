package com.pbilbd.ui.insurancepolicy;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.pbilbd.R;

public class InsurancePolicyFragment extends Fragment {

    private InsurancePolicyViewModel mViewModel;

    public static InsurancePolicyFragment newInstance() {
        return new InsurancePolicyFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.insurance_policy_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(InsurancePolicyViewModel.class);
        // TODO: Use the ViewModel
    }

}