package com.pbilbd.ui.dashboard;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import com.pbilbd.databinding.FragmentDashboardBinding;

public class DashboardFragment extends Fragment {

    private DashboardViewModel dashboardViewModel;
    private FragmentDashboardBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel =
                new ViewModelProvider(this).get(DashboardViewModel.class);

        binding = FragmentDashboardBinding.inflate(inflater, container, false);

        //init views
        clickHandles();

        return binding.getRoot();
    }

    private void clickHandles() {

        /*-----------------------------------------------------------------*/
        binding.dashKycInner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Log.e("TAG", "onClick: ");
                NavHostFragment.findNavController(DashboardFragment.this).navigate(DashboardFragmentDirections.actionNavDashboardToDashUpdateKyc());

            }
        });

        /*-----------------------------------------------------------------*/
        binding.dashWorkShareInner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        /*-----------------------------------------------------------------*/
        binding.dashTransferPointInner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        /*-----------------------------------------------------------------*/
        binding.dashExchangePointInner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        /*-----------------------------------------------------------------*/
        binding.dashIntroducerBonusInner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        /*-----------------------------------------------------------------*/
        binding.dashTierBonusInner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        /*-----------------------------------------------------------------*/
        binding.dashAchievementInner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        /*-----------------------------------------------------------------*/
        binding.dashSaleBonusInner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        /*-----------------------------------------------------------------*/
        binding.dashAffiliatePointInner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        /*-----------------------------------------------------------------*/
        binding.dashShoppingPointInner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}