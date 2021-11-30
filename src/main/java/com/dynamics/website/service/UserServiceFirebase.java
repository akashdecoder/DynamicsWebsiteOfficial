package com.dynamics.website.service;

import com.dynamics.website.model.CodingUser;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;

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

        return apiFuture.get().getUpdateTime().toString();
    }
}
