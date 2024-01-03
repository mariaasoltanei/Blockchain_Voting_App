package com.example.blockchain_voting_app.models;

import androidx.lifecycle.LiveData;

public interface IUserDao {

    void insert(User user);

    LiveData<User> getUserByCNP(String cnp);
}
