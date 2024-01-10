package com.example.blockchain_voting_app.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.blockchain_voting_app.MainActivity;
import com.example.blockchain_voting_app.R;
import com.example.blockchain_voting_app.models.User;
import com.example.blockchain_voting_app.utils.SharedPrefs;


public class LoginActivity extends AppCompatActivity {
    private LoginViewModel loginViewModel;
    private EditText etLoginCNP;
    private EditText etPassword;
    private Button btnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginViewModel = new ViewModelProvider(this).get(LoginViewModel.class);
        declareComponents();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginViewModel.findUserByID(etLoginCNP.getText().toString().trim(), etPassword.getText().toString().trim());
                SharedPrefs.getUserIdFromSharedPrefs(getApplicationContext());
                Intent mainIntent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(mainIntent);
                finish();
            }
        });
    }

    private void declareComponents() {
        etLoginCNP = findViewById(R.id.et_login_cnp);
        etPassword = findViewById(R.id.et_password);
        btnLogin = findViewById(R.id.btn_login);
    }
}
