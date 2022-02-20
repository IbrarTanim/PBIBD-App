package com.pbilbd.activities.signup;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Patterns;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;
import com.pbilbd.R;
import com.pbilbd.activities.signin.SignInActivity;
import com.pbilbd.databinding.ActivitySignUpBinding;

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
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                binding.signUpMotionLayout.transitionToEnd();
            }
        }, 300);

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
        String phoneRegex = "^[+]?[0-9]{10,13}$";
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

                if (validation.validate()) {

                    Toasty.success(activity, "Validated").show();

                }

            }
        });
    }

    @Override
    protected void onDestroy() {
        binding = null;
        super.onDestroy();
    }
}