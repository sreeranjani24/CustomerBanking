package com.banking.application.model;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class Name implements Serializable{

   private String firstName;
   private String surName;
   private String middleName;

   public Name() {
   }

   public String getFirstName() {
      return firstName;
   }

   public void setFirstName(String firstName) {
      this.firstName = firstName;
   }

   public String getSurName() {
      return surName;
   }

   public void setSurName(String surName) {
      this.surName = surName;
   }

   public String getMiddleName() {
      return middleName;
   }

   public void setMiddleName(String middleName) {
      this.middleName = middleName;
   }
}
