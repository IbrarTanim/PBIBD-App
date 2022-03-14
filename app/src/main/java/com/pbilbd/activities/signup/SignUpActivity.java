package com.pbilbd.activities.signup;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Patterns;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;
import com.pbilbd.R;
import com.pbilbd.activities.signin.SignInActivity;
import com.pbilbd.constants.BaseConstants;
import com.pbilbd.databinding.ActivitySignUpBinding;
import com.pbilbd.dto.responses.reg422error.Message;
import com.pbilbd.utils.ExecutorServices;
import com.pbilbd.utils.ProgressDialog;

import java.util.HashMap;

import es.dmoral.toasty.Toasty;

public class SignUpActivity extends AppCompatActivity {

    private ActivitySignUpBinding binding;
    private SignUpActivity activity;
    private AwesomeValidation validation;
    private SignUpViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivitySignUpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        activity = this;
        viewModel =
                new ViewModelProvider(activity).get(SignUpViewModel.class);
        validation =
                new AwesomeValidation(ValidationStyle.TEXT_INPUT_LAYOUT);

        /**
         * Open
         * Page
         * Animation
         * */
        binding.signUpMotionLayout.post(new Runnable() {
            @Override
            public void run() {
                binding.signUpMotionLayout.transitionToEnd();
            }
        });

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

        /**
         * Add
         * Validation
         * To
         * Views
         * */
        //String phoneRegex = "^[+]?[0-9]{10,13}$";
        String phoneRegex = ".{10,}";
        String passwordRegex = ".{8,}";
        validation.addValidation(activity, binding.regEtFirstNameLayout.getId(), RegexTemplate.NOT_EMPTY, R.string.warning_empty);
        validation.addValidation(activity, binding.regEtLastNameLayout.getId(), RegexTemplate.NOT_EMPTY, R.string.warning_empty);
        validation.addValidation(activity, binding.regEtEmailLayout.getId(), Patterns.EMAIL_ADDRESS, R.string.warning_email);
        validation.addValidation(activity, binding.regEtPhoneLayout.getId(), phoneRegex, R.string.warning_phone);
        validation.addValidation(activity, binding.regEtUserIdLayout.getId(), RegexTemplate.NOT_EMPTY, R.string.warning_empty);
        validation.addValidation(activity, binding.regEtPasswordLayout.getId(), passwordRegex, R.string.warning_pass);
        validation.addValidation(activity, binding.regEtConfirmPasswordLayout.getId(), binding.regEtPasswordLayout.getId(), R.string.warning_con_pass);
        validation.addValidation(activity, binding.regEtIntroducerLayout.getId(), RegexTemplate.NOT_EMPTY, R.string.warning_empty);

        /**
         * Back
         * To
         * Login
         * BTN
         * */
        binding.loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent nextActivity = new Intent(activity, SignInActivity.class);
                nextActivity.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                nextActivity.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                nextActivity.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(nextActivity);
            }
        });

        /**
         * Sign
         * Up
         * BTN
         * Work
         * */
        binding.regBtnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (binding.regCheckBoxTerms.isChecked()) {
                    if (validation.validate()) {
                        registerUser();
                    }
                } else {
                    Toasty.warning(activity, "Please Accept Terms And Condition!").show();
                }
            }
        });
    }

    private void registerUser() {

        binding.regBtnSignUp.setEnabled(false);

        String firstName = String.valueOf(binding.regEtFirstName.getText());
        String lastName = String.valueOf(binding.regEtLastName.getText());
        String emailAddress = String.valueOf(binding.regEtEmail.getText());
        String phoneNumber = binding.regCpCountryCode.getSelectedCountryCode() + binding.regEtPhone.getText();
        String userId = String.valueOf(binding.regEtUserId.getText());
        String password = String.valueOf(binding.regEtPassword.getText());
        String confirmPassword = String.valueOf(binding.regEtConfirmPassword.getText());
        String introducedBy = String.valueOf(binding.regEtIntroducer.getText());

        HashMap<String, String> registerParams = new HashMap<>();
        registerParams.put("first_name", firstName);
        registerParams.put("last_name", lastName);
        registerParams.put("email", emailAddress);
        registerParams.put("username", userId);
        registerParams.put("phone", phoneNumber);
        registerParams.put("password", password);
        registerParams.put("password_confirmation", confirmPassword);
        registerParams.put("referred_by", introducedBy);

        //background task start
        ProgressDialog.show(activity);
        ExecutorServices
                .getExecutor()
                .execute(new Runnable() {
                    @Override
                    public void run() {

                        viewModel.initViewModel(registerParams);

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {

                                viewModel
                                        .getErrorsLiveData()
                                        .observe(activity, new Observer<Integer>() {
                                            @Override
                                            public void onChanged(Integer integer) {

                                                if (integer == 200) {
                                                    ProgressDialog.cancel();
                                                    viewModel
                                                            .getResponseMessageLiveData()
                                                            .observe(activity, new Observer<String>() {
                                                                @Override
                                                                public void onChanged(String s) {
                                                                    if (s != null) {
                                                                        Toasty.success(activity, s, Toasty.LENGTH_LONG, true).show();
                                                                    }
                                                                }
                                                            });
                                                    new Handler().postDelayed(new Runnable() {
                                                        @Override
                                                        public void run() {
                                                            Intent loginIntent = new Intent(activity, SignInActivity.class);
                                                            loginIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                                            loginIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                                            loginIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                                            startActivity(loginIntent);
                                                        }
                                                    },500);

                                                } else if (integer == 422) {
                                                    ProgressDialog.cancel();
                                                    viewModel
                                                            .getErrorResponseLiveData()
                                                            .observe(activity, new Observer<Message>() {
                                                                @Override
                                                                public void onChanged(Message message) {
                                                                    if (message != null) {
                                                                        if (message.getEmail() != null && message.getEmail().size() > 0) {
                                                                            binding.regEtEmailLayout.setError(message.getEmail().get(0));
                                                                        }
                                                                        if (message.getPhone() != null && message.getPhone().size() > 0) {
                                                                            binding.regEtPhoneLayout.setError(message.getPhone().get(0));
                                                                        }
                                                                        if (message.getUsername() != null && message.getUsername().size() > 0) {
                                                                            binding.regEtUserIdLayout.setError(message.getUsername().get(0));
                                                                        }
                                                                        if (message.getPassword() != null && message.getPassword().size() > 0) {
                                                                            binding.regEtPasswordLayout.setError(message.getPassword().get(0));
                                                                        }
                                                                        if (message.getReferredBy() != null && message.getReferredBy().size() > 0) {
                                                                            binding.regEtIntroducerLayout.setError(message.getReferredBy().get(0));
                                                                        }
                                                                    }

                                                                }
                                                            });
                                                    binding.regBtnSignUp.setEnabled(true);
                                                } else if (integer == BaseConstants.UNKNOWN_ERROR) {
                                                    ProgressDialog.cancel();
                                                    Toasty.warning(activity, BaseConstants.ERROR_UNKNOWN).show();
                                                    binding.regBtnSignUp.setEnabled(true);
                                                } else if (integer == BaseConstants.FAILURE_ERROR) {
                                                    ProgressDialog.cancel();
                                                    Toasty.warning(activity, BaseConstants.ERROR_FAILURE).show();
                                                    binding.regBtnSignUp.setEnabled(true);
                                                } else {
                                                    ProgressDialog.cancel();
                                                    Toasty.warning(activity, BaseConstants.ERROR_UNKNOWN).show();
                                                    binding.regBtnSignUp.setEnabled(true);
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