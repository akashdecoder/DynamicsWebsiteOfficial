package com.dynamics.website.service;

import com.dynamics.website.model.AppUser;
import com.dynamics.website.model.CodingUser;
import com.dynamics.website.model.RoboticsUser;
import com.dynamics.website.model.WorkshopUser;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
public class UserService {
    public static final String COL_NAME = "users";
    public static final String COL_NAME1 = "coding";
    public static final String COL_NAME2 = "robotics";
    public static final String COL_NAME3 = "workshops";



    public String saveUser(AppUser user) throws InterruptedException, ExecutionException {
        Firestore firestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> apiFuture = firestore.collection(COL_NAME)
                .document(user.getFirstName()).set(user);
        return apiFuture.get().getUpdateTime().toString();
    }

    public String saveUser(CodingUser codingUser) throws InterruptedException, ExecutionException {
        Firestore firestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> apiFuture = firestore.collection(COL_NAME1)
                .document(codingUser.getFirstName()).set(codingUser);
        return apiFuture.get().getUpdateTime().toString();
    }

    public String saveUser(RoboticsUser user) throws InterruptedException, ExecutionException {
        Firestore firestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> apiFuture = firestore.collection(COL_NAME2)
                .document(user.getFirstName()).set(user);
        return apiFuture.get().getUpdateTime().toString();
    }

    public String saveUser(WorkshopUser user) throws InterruptedException, ExecutionException {
        Firestore firestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> apiFuture = firestore.collection(COL_NAME3)
                .document(user.getFirstName()).set(user);
        return apiFuture.get().getUpdateTime().toString();
    }

    public AppUser getUser(String name) throws InterruptedException, ExecutionException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        DocumentReference documentReference = dbFirestore.collection(COL_NAME).document(name);
        ApiFuture<DocumentSnapshot> future = documentReference.get();

        DocumentSnapshot document = future.get();

        AppUser user = null;

        if(document.exists()) {
            user = document.toObject(AppUser.class);
            return user;
        }else {
            return null;
        }
    }

    public CodingUser getCodingUser(String name) throws InterruptedException, ExecutionException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        DocumentReference documentReference = dbFirestore.collection(COL_NAME1).document(name);
        ApiFuture<DocumentSnapshot> future = documentReference.get();

        DocumentSnapshot document = future.get();

        CodingUser user = null;

        if(document.exists()) {
            user = document.toObject(CodingUser.class);
            return user;
        }else {
            return null;
        }
    }

    public RoboticsUser getRoboticsUser(String name) throws InterruptedException, ExecutionException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        DocumentReference documentReference = dbFirestore.collection(COL_NAME2).document(name);
        ApiFuture<DocumentSnapshot> future = documentReference.get();

        DocumentSnapshot document = future.get();

        RoboticsUser user = null;

        if(document.exists()) {
            user = document.toObject(RoboticsUser.class);
            return user;
        }else {
            return null;
        }
    }

    public WorkshopUser getWorkshopUser(String name) throws InterruptedException, ExecutionException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        DocumentReference documentReference = dbFirestore.collection(COL_NAME3).document(name);
        ApiFuture<DocumentSnapshot> future = documentReference.get();

        DocumentSnapshot document = future.get();

        WorkshopUser user = null;

        if(document.exists()) {
            user = document.toObject(WorkshopUser.class);
            return user;
        }else {
            return null;
        }
    }



}
