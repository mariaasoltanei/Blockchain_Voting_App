package com.example.blockchain_voting_app.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.example.blockchain_voting_app.models.User;
import com.google.gson.Gson;

public class SharedPrefs {
    public static void addUserToSharedPrefs(User user, Context context){
        SharedPreferences sharedPref = context.getSharedPreferences("userDetails", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        Gson gson = new Gson();
        String json = gson.toJson(user);
        editor.putString("user", json);
        editor.apply();
    }

    public static void removeUserFromSharedPrefs(Context context){
        SharedPreferences sharedPref = context.getSharedPreferences("userDetails", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.remove("user");
        editor.apply();
    }

    public static void addUserIdToSharedPrefs(String userId, Context context){
        SharedPreferences sharedPref = context.getSharedPreferences("userDetails", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("userId", userId);
        editor.apply();
    }

    public static String getUserIdFromSharedPrefs(Context context){
        SharedPreferences sharedPref = context.getSharedPreferences("userDetails", Context.MODE_PRIVATE);
        String userId = sharedPref.getString("userId", null);
       // Log.d("userId", userId);
        return userId;
    }
    public static User getUserFromSharedPrefs(Context context){
        SharedPreferences sharedPref = context.getSharedPreferences("userDetails", Context.MODE_PRIVATE);
        String userLogged = sharedPref.getString("user", null);
        Gson gson = new Gson();
        User user = gson.fromJson(userLogged, User.class);
        Log.d("user", user.toString());
        return user;
    }
}
