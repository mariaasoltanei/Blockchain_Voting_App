package com.example.blockchain_voting_app.ui.signup;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.blockchain_voting_app.models.User;
import com.example.blockchain_voting_app.repositories.UserRepository;

public class SignUpViewModel extends ViewModel {
    private UserRepository userRepository;

    public SignUpViewModel() {
        userRepository = new UserRepository();
    }

    public User insertUser(User user) {
        userRepository.insertUser(user);
        return user;
    }
}
