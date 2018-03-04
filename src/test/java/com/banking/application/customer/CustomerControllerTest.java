package com.banking.application.customer;

import com.banking.application.customer.controller.CustomerController;
import com.banking.application.customer.service.CustomerService;
import com.banking.application.model.Customer;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
public class CustomerControllerTest {

   private static final Integer ID_01 = 100;
   private static final Integer ID_02 = 101;
   private static final ObjectMapper objectMapper = new ObjectMapper();

   @InjectMocks
   private CustomerController customerController;

   @Mock
   private CustomerService customerService;

   private MockMvc mockMvc;
   private Customer cust1;
   private Customer cust2;

   @Before
   public void setup() throws Exception {
      cust1 = createCustomer(ID_01);
      cust2 = createCustomer(ID_02);
      this.mockMvc = MockMvcBuilders.standaloneSetup(customerController).build();
      when(customerService.getAllCustomers()).thenReturn(Arrays.asList(cust1, cust2));
      when(customerService.getCustomer(ID_01)).thenReturn(cust1);
   }

   private Customer createCustomer(Integer id) {
      Customer cust = new Customer();
      cust.setCustomerId(id);
      return cust;
   }

   @Test public void getCustomers() throws Exception {
      mockMvc.perform(get("/customer/getAllCustomers"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$[0].customerId", is(ID_01)))
            .andExpect(jsonPath("$[1].customerId", is(ID_02)));
   }

   @Test public void getCustomerById() throws Exception {
      mockMvc.perform(get("/customer/getCustomer/" + ID_01))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.customerId", is(ID_01)));
   }

   @Test public void addCustomer() throws Exception {
      mockMvc.perform(post("/customer/addCustomer" )
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(cust1)))
            .andExpect(status().isOk());
      verify(customerService).addCustomer(any(Customer.class));
   }

   @Test
   public void updateCustomer() throws Exception {
      mockMvc.perform(put("/customer/updateCustomer" )
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(cust1)))
            .andExpect(status().isOk());
      verify(customerService).updateCustomer(any(Customer.class));
   }

   @Test public void deleteCustomer() throws Exception {
      mockMvc.perform(delete("/customer/deleteCustomer/" + ID_01)
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(cust1)))
            .andExpect(status().isOk());
      verify(customerService).deleteCustomer(ID_01);
   }

}