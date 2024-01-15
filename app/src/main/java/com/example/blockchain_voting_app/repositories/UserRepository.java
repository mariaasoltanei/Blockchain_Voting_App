package com.example.blockchain_voting_app.repositories;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;

import com.example.blockchain_voting_app.BlockchainVotingApp;
import com.example.blockchain_voting_app.database.FirestoreDatabase;
import com.example.blockchain_voting_app.models.User;
import com.example.blockchain_voting_app.utils.SharedPrefs;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.HashMap;
import java.util.Map;

public class UserRepository extends FirestoreDatabase {
///TODO: implement callbacks
    public User insertUser(User user) {
        Map<String, Object> userMap = new HashMap<>();
        userMap.put("firstName", user.getFirstName());
        userMap.put("lastName", user.getLastName());
        userMap.put("cnp", user.getCnp());
        userMap.put("password", user.getPassword());
        getCollectionReference("User").add(userMap).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Log.d("Firebase", "User added successfully!");
                        String userId = documentReference.getId();
                        user.setId(userId);
                        Log.d("Firebase", user.toString());
                        SharedPrefs.addUserToSharedPrefs(user, BlockchainVotingApp.getAppContext());
                        User utest = SharedPrefs.getUserFromSharedPrefs(BlockchainVotingApp.getAppContext());
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w("Firebase", "Error adding user: " + e);
                    }
                });
        return user;
    }

    @Override
    public void getUser(String cnp, String password) {
        getCollectionReference("User").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if(task.isSuccessful()){
                    if(task.getResult().size() > 0){
                        for(QueryDocumentSnapshot document: task.getResult()){
                            if(document.get("cnp").equals(cnp) && document.get("password").equals(password)){
                                User user = new User(document.getId(), document.get("firstName").toString(), document.get("lastName").toString(), document.get("cnp").toString(), document.get("password").toString());
                                SharedPrefs.addUserToSharedPrefs(user, BlockchainVotingApp.getAppContext());
                                Log.d("Firebase", "User found: " + user.toString());
                            }
                            else {
                                Log.d("Firebase", "User not found!" + task.getException());
                            }
                        }
                    }
                    else{
                        Log.d("Firebase", "User not found!" + task.getException());
                    }
                }
            }
        });
    }
}


