package com.joaoiora.dao;

import java.util.List;

import com.joaoiora.entity.Customer;

/**
 * @author João Iora
 */
public interface CustomerDAO {

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
