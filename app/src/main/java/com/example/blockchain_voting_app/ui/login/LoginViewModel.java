package com.example.blockchain_voting_app.ui.login;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.blockchain_voting_app.models.User;
import com.example.blockchain_voting_app.repositories.UserRepository;

public class LoginViewModel extends ViewModel {
    private UserRepository userRepository;

    public LoginViewModel() {
        userRepository = new UserRepository();
    }

    public LiveData<User> getUserByUsername(String username) {
        return userRepository.getUserByUsername(username);
    }

    public void insertUser(User user) {
        userRepository.insertUser(user);
    }



}
