package com.project.firebase.account.beans;

import java.util.List;

import org.springframework.stereotype.Component;

import com.project.firebase.account.entity.AccountEntity;

@Component
public class AccountListResponse {
    
    private List<AccountEntity> list;

    public List<AccountEntity> getList() {
        return list;
    }

    public void setList(List<AccountEntity> list) {
        this.list = list;
    }

}
