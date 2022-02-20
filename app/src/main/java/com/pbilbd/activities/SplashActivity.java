package com.pbilbd.activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.motion.widget.MotionLayout;

import com.pbilbd.activities.signin.SignInActivity;
import com.pbilbd.databinding.ActivitySplashBinding;

@SuppressLint("CustomSplashScreen")
public class SplashActivity extends AppCompatActivity {

    private ActivitySplashBinding binding;
    private SplashActivity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivitySplashBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        activity = this;

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                binding.splashMainLayout.transitionToEnd();
                binding.splashMainLayout.addTransitionListener(new MotionLayout.TransitionListener() {
                    @Override
                    public void onTransitionStarted(MotionLayout motionLayout, int startId, int endId) {

                    }

                    @Override
                    public void onTransitionChange(MotionLayout motionLayout, int startId, int endId, float progress) {

                    }

                    @Override
                    public void onTransitionCompleted(MotionLayout motionLayout, int currentId) {

                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                Intent nextActivity = new Intent(activity, SignInActivity.class);
                                nextActivity.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                nextActivity.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                nextActivity.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                startActivity(nextActivity);
                            }
                        }, 500);

                    }

                    @Override
                    public void onTransitionTrigger(MotionLayout motionLayout, int triggerId, boolean positive, float progress) {

                    }
                });
            }
        }, 300);

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        binding = null;
    }
}