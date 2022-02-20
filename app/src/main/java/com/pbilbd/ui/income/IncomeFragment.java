package com.pbilbd.ui.income;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.pbilbd.databinding.FragmentIncomeBinding;

public class IncomeFragment extends Fragment {

    private IncomeViewModel incomeViewModel;
    private FragmentIncomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        incomeViewModel =
                new ViewModelProvider(this).get(IncomeViewModel.class);

        binding = FragmentIncomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}