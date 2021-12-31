package com.joaoiora.service;

import java.util.List;

import com.joaoiora.entity.Customer;

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
  Customer loadCustomer(Integer id);

  /**
   * @param id
   */
  void deleteCustomer(Integer id);

}
