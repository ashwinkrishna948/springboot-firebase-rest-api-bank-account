package com.project.firebase.account.beans;

import java.util.Date;

public class AccountDeleteResponse {
    
     private Date updatedDate;
     private boolean status;
     public Date getUpdatedDate() {
        return updatedDate;
     }
     public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
     }
     public boolean isStatus() {
        return status;
     }
     public void setStatus(boolean status) {
        this.status = status;
     }
}
