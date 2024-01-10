package com.example.blockchain_voting_app.ui.signup;

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
import com.example.blockchain_voting_app.ui.login.LoginActivity;
import com.example.blockchain_voting_app.utils.SharedPrefs;

public class SignUpActivity extends AppCompatActivity {
    private SignUpViewModel signUpViewModel;

    private EditText etFirstName;
    private EditText etLastName;
    private EditText etSignupCNP;
    private EditText etPassword;
    private Button btnSignUp, btnIntentLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        signUpViewModel = new ViewModelProvider(this).get(SignUpViewModel.class);
        declareComponents();
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User newUser = createUser();
                User insertedUser = signUpViewModel.insertUser(newUser);
                Log.d("insertedUser", insertedUser.toString());
                SharedPrefs.getUserIdFromSharedPrefs(getApplicationContext());
                Intent mainIntent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(mainIntent);
                finish();
                //TODO:handle case where the user is not created successfully
            }
        });
        btnIntentLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loginIntent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(loginIntent);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    private void signUpUser(User user) {
        signUpViewModel.insertUser(user);
    }

    private User createUser() {
        String firstName = etFirstName.getText().toString().trim();
        String lastName = etLastName.getText().toString().trim();
        String cnp = etSignupCNP.getText().toString().trim();
        String password = etPassword.getText().toString().trim();

        return new User(null,firstName, lastName, cnp, password);
    }

    private void declareComponents(){
        etFirstName = findViewById(R.id.et_first_name);
        etLastName = findViewById(R.id.et_last_name);
        etSignupCNP = findViewById(R.id.et_signup_cnp);
        etPassword = findViewById(R.id.et_password);
        btnSignUp = findViewById(R.id.btn_signup);
        btnIntentLogin = findViewById(R.id.btn_intent_login);
    }

}
