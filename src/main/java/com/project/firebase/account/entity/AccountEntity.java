package com.project.firebase.account.entity;

public class AccountEntity 
{
   private String name;
   private String email;
   private Long mobile;
   private String id;
   private String type;
   private Long amount;
   
   public String getName() {
        return name;
   }
   public String getEmail() {
        return email;
   }
   public Long getMobile() {
        return mobile;
   }
   public String getId() {
        return id;
   }
   public void setName(String name) {
        this.name = name;
   }
   public void setEmail(String email) {
        this.email = email;
   }
   public void setMobile(Long mobile) {
        this.mobile = mobile;
   }
   public void setId(String id) {
        this.id = id;
   }
   public String getType() {
     return type;
   }
   public void setType(String type) {
          this.type = type;
   }
   public Long getAmount() {
          return amount;
   }
   public void setAmount(Long amount) {
          this.amount = amount;
   } 

}
