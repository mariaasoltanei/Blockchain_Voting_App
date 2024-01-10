package com.example.blockchain_voting_app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.app.Application;

public class BlockchainVotingApp extends Application{
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }

    public static Context getAppContext() {
        return context;
    }
}
