package com.example.blockchain_voting_app.ui.signup;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.blockchain_voting_app.R;
import com.example.blockchain_voting_app.models.User;

public class SignUpActivity extends AppCompatActivity {
    private SignUpViewModel signUpViewModel;

    private EditText etFirstName;
    private EditText etLastName;
    private EditText etSignupCNP;
    private EditText etPassword;
    private Button btnSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        signUpViewModel = new ViewModelProvider(this).get(SignUpViewModel.class);

        etFirstName = findViewById(R.id.et_first_name);
        etLastName = findViewById(R.id.et_last_name);
        etSignupCNP = findViewById(R.id.et_signup_cnp);
        etPassword = findViewById(R.id.et_password);
        btnSignUp = findViewById(R.id.btn_signup);

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signUpUser();
            }
        });
    }
    private void signUpUser() {
        String firstName = etFirstName.getText().toString().trim();
        String lastName = etLastName.getText().toString().trim();
        String cnp = etSignupCNP.getText().toString().trim();
        String password = etPassword.getText().toString().trim();

        User user = new User(firstName, lastName, cnp, password);

        signUpViewModel.insertUser(user);
    }
}
