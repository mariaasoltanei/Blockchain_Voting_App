package com.example.blockchain_voting_app.ui.login;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.blockchain_voting_app.R;
import com.example.blockchain_voting_app.models.User;

public class LoginActivity extends AppCompatActivity {
    private LoginViewModel loginViewModel;
    private EditText etLoginCNP;
    private EditText etPassword;
    private Button btnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etLoginCNP = findViewById(R.id.et_login_cnp);
        etPassword = findViewById(R.id.et_password);

        loginViewModel = new ViewModelProvider(this).get(LoginViewModel.class);

        Button loginButton = findViewById(R.id.btn_login);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginUser();
            }
        });
    }

    private void loginUser() {
        String cnp = etLoginCNP.getText().toString().trim();
        String password = etPassword.getText().toString().trim();

        //User user = new User(cnp, password);

        //loginViewModel.insertUser(user);
    }
}
