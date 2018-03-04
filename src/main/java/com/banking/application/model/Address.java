package com.banking.application.model;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class Address implements Serializable {

   private String unitOrApartmentOrstreetNo;
   private String streetName;
   private String suburb;
   private String city;
   private String state;
   private String country;
   private String pinCode;

   public Address() {

   }

   public String getUnitOrApartmentOrstreetNo() {
      return unitOrApartmentOrstreetNo;
   }

   public void setUnitOrApartmentOrstreetNo(String unitOrApartmentOrstreetNo) {
      this.unitOrApartmentOrstreetNo = unitOrApartmentOrstreetNo;
   }

   public String getStreetName() {
      return streetName;
   }

   public void setStreetName(String streetName) {
      this.streetName = streetName;
   }

   public String getSuburb() {
      return suburb;
   }

   public void setSuburb(String suburb) {
      this.suburb = suburb;
   }

   public String getCity() {
      return city;
   }

   public void setCity(String city) {
      this.city = city;
   }

   public String getState() {
      return state;
   }

   public void setState(String state) {
      this.state = state;
   }

   public String getCountry() {
      return country;
   }

   public void setCountry(String country) {
      this.country = country;
   }

   public String getPinCode() {
      return pinCode;
   }

   public void setPinCode(String pinCode) {
      this.pinCode = pinCode;
   }
}
