package com.pbilbd.ui.dashboard.updatekyc;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.pbilbd.databinding.UpdateKYCFragmentBinding;
import com.pbilbd.dto.responses.placementuser.Datum;
import com.pbilbd.dto.responses.placementuser.PlacementUserResponse;
import com.pbilbd.dto.responses.positionbyplacement.PositionByPlacementResponse;

import java.util.ArrayList;
import java.util.List;

public class UpdateKYCFragment extends Fragment {

    private Context context;
    private UpdateKYCViewModel viewModel;
    private UpdateKYCFragmentBinding binding;

    private List<Datum> placementUserData;
    private List<com.pbilbd.dto.responses.positionbyplacement.Datum> positionByPlacementData;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = UpdateKYCFragmentBinding.inflate(inflater, container, false);
        binding.marqueeText.setSelected(true);
        viewModel =
                new ViewModelProvider(this).get(UpdateKYCViewModel.class);
        placementUserData = new ArrayList<>();
        positionByPlacementData = new ArrayList<>();
        viewModel.initViewModel(context);
        return binding.getRoot();
    }

    @Override
    public void onResume() {
        super.onResume();

        //search placement user on inputs
        binding.etPlacementUser.addTextChangedListener(new TextWatcher() {
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
                Log.e("Item Selected", "FALSE");
            }
        });
        //search placement user selection
        binding.spinnerPlacementUser.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Log.e("Item Selected", "True");
                String placementUserId = placementUserData.get(i).getId();
                positionByPlacement(placementUserId);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    //placement user from db
    private void searchPlacementUser(String searchPlacementUser) {
        viewModel.searchPlacementUser(searchPlacementUser)
                .observe(getViewLifecycleOwner(), new Observer<PlacementUserResponse>() {
                    @Override
                    public void onChanged(PlacementUserResponse placementUserResponse) {
                        if (placementUserResponse != null && placementUserResponse.getData() != null){
                            if (!placementUserResponse.getData().isEmpty()){
                                placementUserData = placementUserResponse.getData();
                                binding.atvPosition.setAdapter(null);
                                ArrayAdapter<Datum> placementUserSpinnerAdapter =
                                        new ArrayAdapter<Datum>(context, android.R.layout.simple_spinner_dropdown_item, placementUserData);
                                binding.spinnerPlacementUser.setVisibility(View.VISIBLE);
                                binding.spinnerPlacementUser.setAdapter(placementUserSpinnerAdapter);
                            }else {
                                binding.atvPosition.setAdapter(null);
                                binding.spinnerPlacementUser.setAdapter(null);
                                binding.spinnerPlacementUser.setVisibility(View.GONE);
                            }
                        }
                    }
                });
    }

    //position from db based on placement
    private void positionByPlacement(String placementUserId){
        viewModel.positionByPlacement(placementUserId)
                .observe(getViewLifecycleOwner(), new Observer<PositionByPlacementResponse>() {
                    @Override
                    public void onChanged(PositionByPlacementResponse positionByPlacementResponse) {
                        if (positionByPlacementResponse != null && positionByPlacementResponse.getData() != null){
                            if (!positionByPlacementResponse.getData().isEmpty()){
                                positionByPlacementData = positionByPlacementResponse.getData();
                                ArrayAdapter<com.pbilbd.dto.responses.positionbyplacement.Datum> positionAdapter =
                                        new ArrayAdapter<com.pbilbd.dto.responses.positionbyplacement.Datum>(context,
                                                android.R.layout.simple_spinner_dropdown_item, positionByPlacementData);
                                binding.atvPosition.setAdapter(positionAdapter);
                            }else {
                                binding.atvPosition.setAdapter(null);
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