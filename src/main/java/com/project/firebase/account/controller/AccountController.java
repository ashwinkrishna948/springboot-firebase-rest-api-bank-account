package com.project.firebase.account.controller;

import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.firebase.account.beans.AccountCreateResponse;
import com.project.firebase.account.beans.AccountDeleteResponse;
import com.project.firebase.account.beans.AccountListResponse;
import com.project.firebase.account.entity.AccountEntity;
import com.project.firebase.account.service.AccountService;

@RestController
@RequestMapping("/account")    
public class AccountController 
{
    @Autowired
    AccountService accountService;

    @PostMapping
    @RequestMapping("/")
    public AccountCreateResponse createAccount(@RequestBody AccountEntity account) throws InterruptedException,ExecutionException
    {
       return accountService.createAccount(account);
    }

    @GetMapping("/")
    public AccountListResponse getAllAccounts() throws InterruptedException,ExecutionException
    {
        return accountService.getAccountList();
    }
    
    @GetMapping("/search")
    public AccountListResponse getAccountByName(@RequestParam String key) throws InterruptedException,ExecutionException 
    {
        return accountService.getAccountByKey(key);
    }

    @PutMapping("/update")
    public AccountCreateResponse updateAccount(AccountEntity account) throws InterruptedException,ExecutionException 
    {
        return accountService.updateAccount(account);
    }
    
    @DeleteMapping("/delete")
    public AccountDeleteResponse deleteAccount(@RequestParam String id) throws InterruptedException , ExecutionException
    {
        return accountService.deleteAccount(id);
    }
}
