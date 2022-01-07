package com.joaoiora.service;

import java.util.List;

import com.joaoiora.model.Customer;

/**
 * @author João Iora
 */
public interface CustomerService {

  /**
   * @return
   */
  List<Customer> getCustomers();

  /**
   * @param customer
   */
  void saveCustomer(Customer customer);

  /**
   * @param id
   *
   * @return
   */
  Customer getCustomer(int id);

  /**
   * @param id
   */
  void deleteCustomer(int id);

}
