package com.banking.application.customer.service;

import com.banking.application.customer.repository.CustomerRepository;
import com.banking.application.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service("customerservice")
@Transactional
public class CustomerService {
   @Autowired CustomerRepository customerRepository;

   public List<Customer> getAllCustomers() {
      return customerRepository.getAllCustomers();
   }

   public Customer getCustomer(Integer id) {
      return customerRepository.getCustomerById(id);
   }

   public void addCustomer(Customer customer) {
      customerRepository.addCustomer(customer);
   }

   public void updateCustomer(Customer customer) {
      customerRepository.updateCustomer(customer);

   }

   public void deleteCustomer(Integer id) {
      customerRepository.deleteCustomerById(id);
   }

}
