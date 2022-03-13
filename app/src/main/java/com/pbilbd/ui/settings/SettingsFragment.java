package com.pbilbd.ui.settings;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.pbilbd.activities.signin.SignInActivity;
import com.pbilbd.constants.BaseConstants;
import com.pbilbd.databinding.SettingsFragmentBinding;
import com.pbilbd.utils.ExecutorServices;
import com.pbilbd.utils.ProgressDialog;

import es.dmoral.toasty.Toasty;

public class SettingsFragment extends Fragment {

    private SettingsViewModel mViewModel;
    private SettingsFragmentBinding binding;
    private Context context;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = SettingsFragmentBinding.inflate(inflater, container, false);
        mViewModel =
                new ViewModelProvider(this).get(SettingsViewModel.class);
        mViewModel.initViewModel(context);
        clickHandles();
        return binding.getRoot();
    }

    private void clickHandles() {

        //logout btn
        binding.logoutLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logout();
            }
        });
    }

    private void logout() {
        ProgressDialog.show(context);
        ExecutorServices.getExecutor()
                .execute(new Runnable() {
                    @Override
                    public void run() {

                        mViewModel.logout();

                        new Handler(Looper.getMainLooper())
                                .post(new Runnable() {
                                    @Override
                                    public void run() {
                                        mViewModel.getErrorLiveData()
                                                .observe(getViewLifecycleOwner(), new Observer<Integer>() {
                                                    @Override
                                                    public void onChanged(Integer integer) {
                                                        if (integer == 200){
                                                            ProgressDialog.cancel();
                                                            mViewModel.getResponseLiveData()
                                                                    .observe(getViewLifecycleOwner(), new Observer<String>() {
                                                                        @Override
                                                                        public void onChanged(String s) {
                                                                            if (s != null){
                                                                                Toasty.success(context, s).show();
                                                                            }
                                                                        }
                                                                    });

                                                            Intent logoutIntent = new Intent(getActivity(), SignInActivity.class);
                                                            logoutIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                                            logoutIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                                            logoutIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                                            startActivity(logoutIntent);

                                                        }else if (integer == 401){
                                                            ProgressDialog.cancel();
                                                            Toasty.warning(context, BaseConstants.ERROR_UNAUTHORIZED).show();

                                                            Intent logoutIntent = new Intent(getActivity(), SignInActivity.class);
                                                            logoutIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                                            logoutIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                                            logoutIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                                            startActivity(logoutIntent);

                                                        }else if (integer == BaseConstants.FAILURE_ERROR){
                                                            ProgressDialog.cancel();
                                                            Toasty.warning(context, BaseConstants.ERROR_FAILURE).show();
                                                        }else {
                                                            ProgressDialog.cancel();
                                                            Toasty.warning(context, BaseConstants.ERROR_UNKNOWN).show();
                                                        }
                                                    }
                                                });
                                    }
                                });
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