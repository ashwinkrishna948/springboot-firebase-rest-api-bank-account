package com.project.firebase.account.service;

import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.firebase.cloud.FirestoreClient;
import com.project.firebase.account.beans.AccountCreateResponse;
import com.project.firebase.account.beans.AccountDeleteResponse;
import com.project.firebase.account.beans.AccountListResponse;
import com.project.firebase.account.entity.AccountEntity;
import com.google.api.core.ApiFuture;


public class AccountService {
    
     @Autowired
     AccountCreateResponse accountCreateResponse;

     @Autowired
     AccountListResponse accountListResponse;

     @Autowired
     AccountDeleteResponse accountDeleteResponse;

    public AccountCreateResponse createAccount(AccountEntity account) throws InterruptedException,ExecutionException
    {
        Firestore fireStore = FirestoreClient.getFirestore();
        DocumentReference docReference =fireStore.collection("account").document();
        account.setId(docReference.getId());
        ApiFuture<WriteResult> apiFuture = docReference.set(account);
        accountCreateResponse.setUpdatedDate(apiFuture.get().getUpdateTime().toDate());
        accountCreateResponse.setId(account.getId());  
        return accountCreateResponse;
    }

    public AccountListResponse getAccountList() throws InterruptedException,ExecutionException
    {
        Firestore fireStore = FirestoreClient.getFirestore();
        ApiFuture<QuerySnapshot> apiFuture = fireStore.collection("account").get();
        List<QueryDocumentSnapshot> list = apiFuture.get().getDocuments();
        List<AccountEntity> cccountList =  list.stream().map((doc)->doc.toObject(AccountEntity.class)).collect(Collectors.toList());
        accountListResponse.setList(cccountList);
        return accountListResponse;
    }

    public AccountListResponse getAccountByKey(String key) throws InterruptedException,ExecutionException 
    {
        Firestore fireStore = FirestoreClient.getFirestore();
        ApiFuture<QuerySnapshot> apiFuture = fireStore.collection("account")
                            .whereGreaterThanOrEqualTo("name",key)
                            .whereLessThan("name", key+'z').get();                           
        List<QueryDocumentSnapshot> list = apiFuture.get().getDocuments(); 
        List<AccountEntity> accountList =  list.stream().map((doc)->doc.toObject(AccountEntity.class)).collect(Collectors.toList());
        accountListResponse.setList(accountList);
        return accountListResponse;                   
    }

    public AccountCreateResponse updateAccount(AccountEntity account) throws InterruptedException,ExecutionException 
    { 
        Firestore fireStore = FirestoreClient.getFirestore();
        DocumentReference docReference =fireStore.collection("account").document(account.getId());
        ApiFuture<WriteResult> apiFuture = docReference.set(account);
        accountCreateResponse.setUpdatedDate(apiFuture.get().getUpdateTime().toDate());
        accountCreateResponse.setId(account.getId());  
        return accountCreateResponse;
    }

        
    
    public AccountDeleteResponse deleteAccount(String id) throws InterruptedException,ExecutionException 
    {
        Firestore fireStore = FirestoreClient.getFirestore();
        DocumentReference docReference =fireStore.collection("account").document(id);
        ApiFuture<WriteResult> apiFuture = docReference.delete();
        accountDeleteResponse.setUpdatedDate(apiFuture.get().getUpdateTime().toDate());
        accountDeleteResponse.setStatus(true);  
        return accountDeleteResponse;
    }

}
