package com.project.firebase.account.beans;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class AccountCreateResponse {
    
    private String id;
    private Date updatedDate;
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public Date getUpdatedDate() {
        return updatedDate;
    }
    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }
}
