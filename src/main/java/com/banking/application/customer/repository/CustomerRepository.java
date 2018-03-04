package com.banking.application.customer.repository;

import com.banking.application.model.Customer;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class CustomerRepository {

   @PersistenceContext
   private EntityManager entityManager;

   public List<Customer> getAllCustomers() {
      return entityManager.createNamedQuery("Customer.getAllCustomers").getResultList();
   }

   public Customer getCustomerById(Integer customerId) {
      Query query = entityManager.createNamedQuery("Customer.getCustomerById");
      query.setParameter("customerId", customerId);

      return (Customer) query.getSingleResult();
   }

   public void addCustomer(Customer customer) {
      entityManager.persist(customer);
   }

   public void updateCustomer(Customer customer) {
      entityManager.merge(customer);
   }

   public void deleteCustomerById(Integer customerId) {
      Query query = entityManager.createNamedQuery("Customer.deleteCustomerById");
      query.setParameter("customerId", customerId);
      query.executeUpdate();
   }
}
