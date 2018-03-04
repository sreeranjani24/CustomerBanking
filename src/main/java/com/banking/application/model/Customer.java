package com.banking.application.model;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.io.Serializable;

@Entity
@Table(name = "CUSTOMER")
@NamedQueries({
      @NamedQuery(name = "Customer.getAllCustomers",
            query = "SELECT cust FROM Customer cust"),
      @NamedQuery(name = "Customer.getCustomerById",
            query = "SELECT cust FROM Customer cust WHERE cust.customerId =:customerId"),
      @NamedQuery(name = "Customer.deleteCustomerById",
            query = "DELETE Customer cust WHERE cust.customerId =:customerId")
       })
public class Customer implements Serializable {

   @Id
   private Integer customerId;
   private Name name;
   private String intials;
   private String title;
   @Embedded
   @AttributeOverrides({@AttributeOverride(name = "country", column = @Column(name = "ADDRESS_COUNTRY")),
         @AttributeOverride(name = "unitOrApartmentOrstreetNo", column = @Column(name = "ADDRESS_LINE_1")),
         @AttributeOverride(name = "streetName", column = @Column(name = "ADDRESS_LINE_2")),
         @AttributeOverride(name = "suburb", column = @Column(name = "ADDRESS_SUBURB")),
         @AttributeOverride(name = "city", column = @Column(name = "ADDRESS_CITY")),
         @AttributeOverride(name = "state", column = @Column(name = "ADDRESS_STATE")),
         @AttributeOverride(name = "postCode", column = @Column(name = "ADDRESS_POSTCODE"))})
   private Address residentialOrMailingAddress = new Address();

   private String sex;
   private String maritalStatus;

   @Max(value = 100)
   @Min(value = 0)
   private Integer creditRating;

   private Boolean isNabCustomer;

   public Customer() {

   }

   public Integer getCustomerId() {
      return customerId;
   }

   public void setCustomerId(Integer customerId) {
      this.customerId = customerId;
   }

   public Name getName() {
      return name;
   }

   public void setName(Name name) {
      this.name = name;
   }

   public String getIntials() {
      return intials;
   }

   public void setIntials(String intials) {
      this.intials = intials;
   }

   public String getTitle() {
      return title;
   }

   public void setTitle(String title) {
      this.title = title;
   }

   public Address getResidentialOrMailingAddress() {
      return residentialOrMailingAddress;
   }

   public void setResidentialOrMailingAddress(Address residentialOrMailingAddress) {
      this.residentialOrMailingAddress = residentialOrMailingAddress;
   }

   public String getSex() {
      return sex;
   }

   public void setSex(String sex) {
      this.sex = sex;
   }

   public String getMaritalStatus() {
      return maritalStatus;
   }

   public void setMaritalStatus(String maritalStatus) {
      this.maritalStatus = maritalStatus;
   }

   public Integer getCreditRating() {
      return creditRating;
   }

   public void setCreditRating(Integer creditRating) {
      this.creditRating = creditRating;
   }

   public Boolean getNabCustomer() {
      return isNabCustomer;
   }

   public void setNabCustomer(Boolean nabCustomer) {
      isNabCustomer = nabCustomer;
   }
}

