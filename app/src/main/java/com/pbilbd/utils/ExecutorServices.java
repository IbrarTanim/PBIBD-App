package com.pbilbd.utils;

import android.app.Application;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServices extends Application {

    public static ExecutorService executorServices = Executors.newCachedThreadPool();

    public static ExecutorService getExecutor(){
        return executorServices;
    }
}
