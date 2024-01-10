package com.example.blockchain_voting_app.database;



import com.example.blockchain_voting_app.models.User;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;


public abstract class FirestoreDatabase {
    private final FirebaseFirestore firestore = FirebaseFirestore.getInstance();;

    protected CollectionReference getCollectionReference(String collectionName) {
        return firestore.collection(collectionName);
    }

    public abstract User insertUser(User user);

    public abstract void getUser(String cnp, String password);

}
