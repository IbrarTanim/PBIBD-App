package com.pbilbd.ui.dashboard.updatekyc;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.pbilbd.databinding.UpdateKYCFragmentBinding;

public class UpdateKYCFragment extends Fragment {

    private UpdateKYCViewModel mViewModel;
    private UpdateKYCFragmentBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = UpdateKYCFragmentBinding.inflate(inflater, container, false);

        binding.marqueeText.setSelected(true);

        return binding.getRoot();
    }


}