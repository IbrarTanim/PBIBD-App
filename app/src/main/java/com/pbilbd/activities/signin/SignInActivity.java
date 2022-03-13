package com.pbilbd.activities.signin;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;
import com.pbilbd.R;
import com.pbilbd.activities.MainActivity;
import com.pbilbd.activities.signup.SignUpActivity;
import com.pbilbd.constants.BaseConstants;
import com.pbilbd.databinding.ActivitySignInBinding;
import com.pbilbd.dto.responses.loginresponse.LoginResponse;
import com.pbilbd.utils.ExecutorServices;
import com.pbilbd.utils.ProgressDialog;
import com.pbilbd.utils.SharedPreffManager;

import java.util.Objects;

import es.dmoral.toasty.Toasty;

public class SignInActivity extends AppCompatActivity {

    private ActivitySignInBinding binding;
    private SignInActivity activity;
    private AwesomeValidation validation;
    private SignInViewModel viewModel;
    private SharedPreffManager sharedPreffManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivitySignInBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        /**
         * Open
         * Page
         * Animation
         * */
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                binding.signInMainLayout.transitionToEnd();
            }
        }, 300);


        activity = this;
        validation =
                new AwesomeValidation(ValidationStyle.TEXT_INPUT_LAYOUT);
        viewModel =
                new ViewModelProvider(activity).get(SignInViewModel.class);
        sharedPreffManager =
                new SharedPreffManager(activity);

    }


    @Override
    protected void onResume() {
        super.onResume();
        /**
         * Initialize
         * Views
         * */
        initializeViews();
    }

    private void initializeViews() {

        String passwordRegex = ".{8,}";
        validation.addValidation(activity, binding.loginUserIdLayout.getId(), RegexTemplate.NOT_EMPTY, R.string.warning_empty);
        validation.addValidation(activity, binding.loginPasswordLayout.getId(), passwordRegex, R.string.warning_pass);

        /**
         * Sign
         * Up
         * BTN
         * Work
         * */
        binding.signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent nextActivity = new Intent(activity, SignUpActivity.class);
                nextActivity.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                nextActivity.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                nextActivity.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(nextActivity);
            }
        });

        /**
         * Login
         * BTN
         * Work
         * */
        binding.loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validation.validate()) {
                    String userId = String.valueOf(Objects.requireNonNull(binding.loginUserIdLayout.getEditText()).getText());
                    String password = String.valueOf(Objects.requireNonNull(binding.loginPasswordLayout.getEditText()).getText());

                    loginUser(userId, password);
                }
            }
        });

    }


    private void loginUser(String userId, String password) {

        binding.loginBtn.setEnabled(false);
        //background task start
        ProgressDialog.show(activity);
        ExecutorServices
                .getExecutor()
                .execute(new Runnable() {
                    @Override
                    public void run() {

                        viewModel.initViewModel(userId, password);

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                viewModel
                                        .getErrorLiveData()
                                        .observe(activity, new Observer<Integer>() {
                                            @Override
                                            public void onChanged(Integer integer) {
                                                if (integer == 200) {
                                                    ProgressDialog.cancel();
                                                    viewModel
                                                            .getLoginResponseLiveData()
                                                            .observe(activity, new Observer<LoginResponse>() {
                                                                @Override
                                                                public void onChanged(LoginResponse loginResponse) {
                                                                    if (loginResponse != null) {
                                                                        sharedPreffManager.saveString(BaseConstants.ACCESS_TOKEN, loginResponse.getToken());
                                                                        Log.e("Login", loginResponse.getToken());
                                                                    }
                                                                }
                                                            });
                                                    Toasty.success(activity, "Login successful.", Toasty.LENGTH_LONG).show();
                                                    new Handler().postDelayed(new Runnable() {
                                                        @Override
                                                        public void run() {
                                                            Intent dashboardIntent = new Intent(activity, MainActivity.class);
                                                            dashboardIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                                            dashboardIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                                            dashboardIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                                            startActivity(dashboardIntent);
                                                        }
                                                    }, 500);
                                                } else if (integer == 401) {
                                                    ProgressDialog.cancel();
                                                    viewModel
                                                            .getError401LiveData()
                                                            .observe(activity, new Observer<String>() {
                                                                @Override
                                                                public void onChanged(String s) {
                                                                    if (s != null) {
                                                                        Toasty.warning(activity, s).show();
                                                                    }
                                                                }
                                                            });
                                                    binding.loginBtn.setEnabled(true);
                                                } else if (integer == BaseConstants.UNKNOWN_ERROR) {
                                                    ProgressDialog.cancel();
                                                    Toasty.warning(activity, BaseConstants.ERROR_UNKNOWN).show();
                                                    binding.loginBtn.setEnabled(true);
                                                } else if (integer == BaseConstants.FAILURE_ERROR) {
                                                    ProgressDialog.cancel();
                                                    Toasty.warning(activity, BaseConstants.ERROR_FAILURE).show();
                                                    binding.loginBtn.setEnabled(true);
                                                } else {
                                                    ProgressDialog.cancel();
                                                    Toasty.warning(activity, BaseConstants.ERROR_UNKNOWN).show();
                                                    binding.loginBtn.setEnabled(true);
                                                }
                                            }
                                        });
                            }
                        });
                    }
                });
    }


    @Override
    protected void onDestroy() {
        binding = null;
        super.onDestroy();
    }
}