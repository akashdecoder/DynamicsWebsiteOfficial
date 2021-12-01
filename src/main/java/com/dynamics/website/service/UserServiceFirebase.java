package com.dynamics.website.service;

import com.dynamics.website.model.CodingUser;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
public class UserServiceFirebase
{

    public static final String COL_NAME = "code_arena";

    public String saveUser(CodingUser codingUser) throws InterruptedException, ExecutionException
    {
        Firestore firestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> apiFuture = firestore.collection(COL_NAME)
                .document(codingUser.getUsn()).set(codingUser);

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("code_Arena");
        String key = reference.push().getKey();

        reference.child(key).setValue(codingUser, null);

        return apiFuture.get().getUpdateTime().toString();
    }

    public CodingUser getUser(String usn) throws InterruptedException, ExecutionException
    {
        Firestore firestore = FirestoreClient.getFirestore();
        DocumentReference documentReference = firestore.collection(COL_NAME).document(usn);
        ApiFuture<DocumentSnapshot> apiFuture = documentReference.get();

        DocumentSnapshot documentSnapshot = apiFuture.get();

        CodingUser codingUser = null;

        if(documentSnapshot.exists()) {
            codingUser = documentSnapshot.toObject(CodingUser.class);
            return codingUser;
        } else {
            return null;
        }
    }

    public List<CodingUser> getAllUsers()
    {

        Firestore firestore = FirestoreClient.getFirestore();

        CollectionReference collectionReference = firestore.collection(COL_NAME);
        ApiFuture<QuerySnapshot> querySnapshotApiFuture = collectionReference.get();

        try {
            List<CodingUser> codingUserList = querySnapshotApiFuture.get().toObjects(CodingUser.class);
            return codingUserList;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return Collections.<CodingUser>emptyList();
    }
}
