package com.example.blockchain_voting_app;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.blockchain_voting_app.models.User;
import com.example.blockchain_voting_app.utils.SharedPrefs;

public class MainActivity extends AppCompatActivity {
    TextView tvHelloUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        declareComponents();
        User user = SharedPrefs.getUserFromSharedPrefs(getApplicationContext());
        tvHelloUser.setText("Hello, " + user.getFirstName() + "!");
    }

    private void declareComponents() {
        tvHelloUser = findViewById(R.id.tv_hello_user);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        SharedPrefs.removeUserFromSharedPrefs(getApplicationContext());
    }
}