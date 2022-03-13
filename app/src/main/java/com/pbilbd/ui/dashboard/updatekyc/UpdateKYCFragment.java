package com.pbilbd.ui.dashboard.updatekyc;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.pbilbd.databinding.UpdateKYCFragmentBinding;
import com.pbilbd.dto.responses.placementuser.Datum;
import com.pbilbd.dto.responses.placementuser.PlacementUserResponse;

public class UpdateKYCFragment extends Fragment {

    private Context context;
    private UpdateKYCViewModel viewModel;
    private UpdateKYCFragmentBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = UpdateKYCFragmentBinding.inflate(inflater, container, false);
        binding.marqueeText.setSelected(true);
        viewModel =
                new ViewModelProvider(this).get(UpdateKYCViewModel.class);
        viewModel.initViewModel(context);
        return binding.getRoot();
    }

    @Override
    public void onResume() {
        super.onResume();

        //search placement user on inputs
        binding.atvPlacementUserName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                String searchPlacementUser = String.valueOf(editable);
                searchPlacementUser(searchPlacementUser);
            }
        });
    }

    private void searchPlacementUser(String searchPlacementUser) {
        viewModel.searchPlacementUser(searchPlacementUser)
                .observe(getViewLifecycleOwner(), new Observer<PlacementUserResponse>() {
                    @Override
                    public void onChanged(PlacementUserResponse placementUserResponse) {
                        if (placementUserResponse != null && placementUserResponse.getData() != null){
                            if (!placementUserResponse.getData().isEmpty()){
                                ArrayAdapter<Datum> placementUserSpinnerAdapter = new ArrayAdapter<Datum>(context, android.R.layout.simple_spinner_item, placementUserResponse.getData());
                                binding.atvPlacementUserName.setAdapter(placementUserSpinnerAdapter);
                            }
                        }
                    }
                });
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public void onDestroy() {
        binding = null;
        super.onDestroy();
    }
}