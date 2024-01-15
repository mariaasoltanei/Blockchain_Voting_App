package com.example.blockchain_voting_app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.app.Application;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BlockchainVotingApp extends Application{
    private static Context context;
    ExecutorService executorService = Executors.newFixedThreadPool(4);

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();

    }

    public static Context getAppContext() {
        return context;
    }
}
