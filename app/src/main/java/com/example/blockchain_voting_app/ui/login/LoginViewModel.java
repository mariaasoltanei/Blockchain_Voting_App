package com.example.blockchain_voting_app.ui.login;


import androidx.lifecycle.ViewModel;
import com.example.blockchain_voting_app.models.User;
import com.example.blockchain_voting_app.repositories.UserRepository;

public class LoginViewModel extends ViewModel {
    private final UserRepository userRepository;

    public LoginViewModel() {
        userRepository = new UserRepository();
    }

    public void findUserByID(String cnp, String password) {
        userRepository.getUser(cnp, password);
    }

}
