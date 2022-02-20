package com.pbilbd.activities.signin;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;
import com.pbilbd.R;
import com.pbilbd.activities.MainActivity;
import com.pbilbd.activities.signup.SignUpActivity;
import com.pbilbd.databinding.ActivitySignInBinding;

public class SignInActivity extends AppCompatActivity {

    private ActivitySignInBinding binding;
    private SignInActivity activity;
    private AwesomeValidation validation;
    private SignInViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivitySignInBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        activity = this;
        validation =
                new AwesomeValidation(ValidationStyle.TEXT_INPUT_LAYOUT);
        viewModel =
                new ViewModelProvider(activity).get(SignInViewModel.class);

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
                    Intent nextActivity = new Intent(activity, MainActivity.class);
                    nextActivity.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    nextActivity.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    nextActivity.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(nextActivity);
                }

            }
        });

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        binding = null;
    }
}