package com.banking.application.customer.controller;

import com.banking.application.customer.service.CustomerService;
import com.banking.application.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/customer")
public class CustomerController {

   @Autowired CustomerService customerService;

   @RequestMapping(value = "/getAllCustomers", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
   public List<Customer> getCustomers() {
      List<Customer> listOfCustomers = customerService.getAllCustomers();
      return listOfCustomers;
   }

   @RequestMapping(value = "/getCustomer/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
   public Customer getCustomerById(@PathVariable Integer id) {
      return customerService.getCustomer(id);
   }

   @RequestMapping(value = "/addCustomer", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
   public void addCustomer(
         @RequestBody Customer customer) {
      customerService.addCustomer(customer);

   }

   @RequestMapping(value = "/updateCustomer", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
   public void updateCustomer(
         @RequestBody Customer customer) {
      customerService.updateCustomer(customer);
   }

   @RequestMapping(value = "/deleteCustomer/{id}", method = RequestMethod.DELETE)
   public void deleteCustomer(@PathVariable Integer id) {
      customerService.deleteCustomer(id);
   }

}