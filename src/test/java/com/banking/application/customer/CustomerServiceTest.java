package com.banking.application.customer;

import com.banking.application.customer.repository.CustomerRepository;
import com.banking.application.customer.service.CustomerService;
import com.banking.application.model.Customer;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CustomerServiceTest {

   @InjectMocks
   private CustomerService customerService;

   @Mock
   private CustomerRepository customerRepository;

   private Customer customer1, customer2;

   @Before
   public void setup() throws Exception {
      customer1 = new Customer();
      customer2 = new Customer();

      customer1.setCustomerId(1000);
      customer2.setCustomerId(1001);

      when(customerRepository.getAllCustomers()).thenReturn(
            Arrays.asList(customer1, customer2));
      when(customerRepository.getCustomerById(
            1000)).thenReturn(customer1);
   }

   @Test
   public void getAllCustomers() throws Exception {
      List<Customer> customerList = customerService.getAllCustomers();
      assertEquals(Arrays.asList(customer1, customer2).size(), customerList.size());

      verify(customerRepository).getAllCustomers();
   }

   @Test
   public void getCustomer() throws Exception {
      Customer customer = customerService.getCustomer(1000);
      assertEquals(customer1.getCustomerId(), customer.getCustomerId());
   }

   @Test
   public void addCustomer() throws Exception {
      customerService.addCustomer(customer1);
      verify(customerRepository).addCustomer(customer1);
   }

   @Test
   public void updateCustomer() throws Exception {
      customerService.updateCustomer(customer1);
      verify(customerRepository).updateCustomer(customer1);
   }

   @Test
   public void deleteCustomer() throws Exception {
      customerService.deleteCustomer(customer1.getCustomerId());
      verify(customerRepository).deleteCustomerById(customer1.getCustomerId());
   }

}