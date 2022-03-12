package com.pbilbd.ui.dashboard;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import com.pbilbd.constants.BaseConstants;
import com.pbilbd.databinding.FragmentDashboardBinding;
import com.pbilbd.dto.responses.dashboard.DashboardResponse;
import com.pbilbd.utils.ExecutorServices;

import es.dmoral.toasty.Toasty;

public class DashboardFragment extends Fragment {

    private DashboardViewModel dashboardViewModel;
    private FragmentDashboardBinding binding;
    private Context context;
    private String KYC_STATUS;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel =
                new ViewModelProvider(this).get(DashboardViewModel.class);

        binding = FragmentDashboardBinding.inflate(inflater, container, false);

        dashboardViewModel.initViewModel(context);

        getDashboardInfo();

        //init views
        clickHandles();

        return binding.getRoot();
    }

    private void getDashboardInfo() {

        ExecutorServices.getExecutor()
                .execute(new Runnable() {
                    @Override
                    public void run() {

                        dashboardViewModel.getDashboardInfo();

                        new Handler(Looper.getMainLooper())
                                .post(new Runnable() {
                                    @Override
                                    public void run() {

                                        dashboardViewModel.getErrorLiveData()
                                                .observe(getViewLifecycleOwner(), new Observer<Integer>() {
                                                    @Override
                                                    public void onChanged(Integer integer) {
                                                        if (integer == 200) {
                                                            dashboardViewModel.getResponseLiveData()
                                                                    .observe(getViewLifecycleOwner(), new Observer<DashboardResponse>() {
                                                                        @Override
                                                                        public void onChanged(DashboardResponse dashboardResponse) {
                                                                            if (dashboardResponse != null){
                                                                                KYC_STATUS = dashboardResponse.getData().getKycStatus();
                                                                                if (KYC_STATUS != null){
                                                                                    if (KYC_STATUS.equals("0")){
                                                                                        binding.dashTvWarningKycStatus.setVisibility(View.VISIBLE);
                                                                                    }else if (KYC_STATUS.equals("1")){
                                                                                        binding.dashTvWarningKycStatus.setVisibility(View.GONE);
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    });
                                                        } else if (integer == 401) {
                                                            Toasty.warning(context, BaseConstants.ERROR_UNAUTHORIZED).show();
                                                        } else if (integer == BaseConstants.FAILURE_ERROR) {
                                                            Toasty.warning(context, BaseConstants.ERROR_FAILURE).show();
                                                        } else {
                                                            Toasty.warning(context, BaseConstants.ERROR_UNKNOWN).show();
                                                        }
                                                    }
                                                });

                                    }
                                });
                    }
                });

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